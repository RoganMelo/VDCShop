<%@ include file="topo_index.jsp"%>
<%@ include file="menu.jsp"%>

<!-- um form para cada tabela, cada um tem um id diferente(por botão) -->

<section id="principal" class="column">

<h4 class="alert_info">Bem vindo a Loja VDC</h4>


<article class="modulo width_full">
<header>

<!-- mandar para o servlet pedido  -->
<!-- Div do livro -->
<h3 class="tabs_involved">Livro</h3>
</header>
<div id="tab1" class="tab_conteudo">
<form id="form1" action="ServletPedido" method="post">
<table class="tabela" cellspacing="0">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Quantidade</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${livros}" var="livro">
						<tr>

							<td>${livro.titulo}</td>
							<td>${livro.preco}</td>
							<td>${livro.quantidade <= 0 ? '"Esgotado"' : livro.quantidade}</td>
							<td>

									<input id="apagar1" type="button" value="" onclick="funcao1('CarrinhoLivro','${livro.titulo}');" class="submit_btn"
									style="background: url(images/icn_buy.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
								</td>	
						</c:forEach>
						<input  id="nomeProduto" name="nomeProduto" type="hidden" value=""/>
						<input  id="operacao" name="operacao" type="hidden" value=""/>

					</tbody>
				</table>

			</form>
</div>
<!-- final  Div do livro -->
<!-- final #tab1 -->
</article>
<article class="modulo width_full">
<header>



<h3 class="tabs_involved">CD</h3>
</header>
<!-- Div do CD -->
<div id="tab1" class="tab_conteudo">
<form id="form1" action="ServletPedido" method="post">
<table class="tabela" cellspacing="0">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Quantidade</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${cds}" var="cd">
						<tr>

							<td>${cd.titulo}</td>
							<td>${cd.preco}</td>
							<td>${cd.quantidade <= 0 ? '"Esgotado"' : cd.quantidade}</td>
							<td>

									<input id="apagar1" type="button" value="" onclick="funcao1('CarrinhoCd','${cd.titulo}');" class="submit_btn"
									style="background: url(images/icn_buy.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
								</td>	
						</c:forEach>
						<input  id="nomeProduto" name="nomeProduto" type="hidden" value=""/>
						<input  id="operacao" name="operacao" type="hidden" value=""/>

					</tbody>
</table>
</form>
</div>
<!-- final Div do Cd -->
<!-- final #tab2 -->


</article>
<article class="modulo width_full">
<header>
<!-- Div do BluRay -->
<h3 class="tabs_involved">Blu Ray</h3>
</header>
<div id="tab1" class="tab_conteudo">
<form id="form1" action="ServletPedido" method="post">
<table class="tabela" cellspacing="0">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Quantidade</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${bluRays}" var="bluRay">
						<tr>

							<td>${bluRay.titulo}</td>
							<td>${bluRay.preco}</td>
							<td>${bluRay.quantidade <= 0 ? '"Esgotado"' : bluRay.quantidade}</td>
							<td>

									<input id="apagar1" type="button" value="" onclick="funcao1('CarrinhoBluRay','${bluRay.titulo}');" class="submit_btn"
									style="background: url(images/icn_buy.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
								</td>	
						</c:forEach>
						<input  id="nomeProduto" name="nomeProduto" type="hidden" value=""/>
						<input  id="operacao" name="operacao" type="hidden" value=""/>

					</tbody>
</table>
</form>
</div>

<!--final Div do BluRay -->
<!-- final #tab3 -->
</article>





<div class="limpar"></div>





<div class="espaco"></div>
</section>


</body>

</html>