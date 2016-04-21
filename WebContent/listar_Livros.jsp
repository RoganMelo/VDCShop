<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a Loja VDC</h4>


	<article class="modulo width_full">
		<header>
			<h3 class="tabs_involved">Livro</h3>

		</header>

		<form id="form1" action="ServletLivro" method="post" >
			<div id="tab1" class="tab_conteudo">
				<table class="tabela" cellspacing="0">
					<thead>

						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Data de publicação</th>
							<th>Edição</th>
							<th>Tema</th>
							<th>ISBN</th>
							<th>Quantidade</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${livros}" var="livro">
						<tr>

							<td>${livro.titulo}</td>
							<td>${livro.preco}</td>
							<td>${livro.data_de_publicacao}</td>
							<td>${livro.edicao}°</td>
							<td>${livro.tema}</td>
							<td>${livro.ISBN}</td>
							<td>${livro.quantidade}</td>
							<td>

									<input id="editar1" type="button" value="" onclick="funcao1('Editar','${livro.titulo}');" class="submit_btn"
									style="background: url(images/icn_edit.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									<input id="apagar1" type="button" value="" onclick="funcao1('Apagar','${livro.titulo}');" class="submit_btn"
									style="background: url(images/icn_trash.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
								</td>	
						</c:forEach>
						<input  id="nomeProduto" name="nomeProduto" type="hidden" value=""/>
						<input  id="operacao" name="operacao" type="hidden" value=""/>
					</tbody>
				</table>
			</div>
		</form>
		<!-- final #tab1 -->
	</article>




	<div class="espaco"></div>
</section>


</body>

</html>