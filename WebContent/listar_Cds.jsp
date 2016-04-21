<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>



<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a Lista de CD's</h4>


	<article class="modulo width_full">
		<header>
			<h3 class="tabs_involved">CD</h3>

		</header>


		<div id="tab1" class="tab_conteudo">
			<form id="form1" action="ServletCd" method="post">
				<table class="tabela" cellspacing="0">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Data de lançamento</th>
							<th>Duplo?</th>
							<th>Nº de Faixas</th>
							<th>Quantidade</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${cds}" var="cd">
						<tr>

							<td>${cd.titulo}</td>
							<td>${cd.preco}</td>
							<td>${cd.data_de_publicacao}</td>
							<td>${cd.isDuplo()}</td>
							<td>${cd.quantidade_faixas}</td>
							<td>${cd.quantidade}</td>
								<td>
								
									<input id="editar1" type="button" value=""
									onclick="funcao1('Editar','${cd.titulo}');" class="submit_btn"
									style="background: url(images/icn_edit.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">

									<input id="apagar1" type="button" value=""
									onclick="funcao1('Apagar','${cd.titulo}');" class="submit_btn"
									style="background: url(images/icn_trash.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">


								</td></c:forEach>
						<input  id="nomeProduto" name="nomeProduto" type="hidden" value=""/>
						<input  id="operacao" name="operacao" type="hidden" value=""/>
					</tbody>
				</table>
			</form>
		</div>
		<!-- final #tab1 -->

	</article>





	<div class="espaco"></div>
</section>


</body>

</html>