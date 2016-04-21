<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a Lista de BLU-RAY's</h4>


	<article class="modulo width_full">
		<header>
			<h3 class="tabs_involved">BLU-RAY</h3>

		</header>

		<div id="tab1" class="tab_conteudo">
			<form id="form1" action="ServletBluRay" method="post">
				<table class="tabela" cellspacing="0">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Data de lançamento</th>
							<th>Duplo?</th>
							<th>Tema</th>
							<th>Quantidade</th>
							<th>Ações</th>
						</tr>
					</thead>
					
					<tbody>
					
							<c:forEach items="${bluRays}" var="bluRay">
							<tr>
								<td>${bluRay.titulo}</td>
								<td>${bluRay.preco}</td>
								<td>${bluRay.data_de_publicacao}</td>
								<td>${bluRay.isDuplo()}</td>
								<td>${bluRay.tema}</td>
								<td>${bluRay.quantidade}</td>
								<td>
								
									<input id="editar1" type="button" value=""onclick="funcao1('Editar','${bluRay.titulo}');"
									class="submit_btn"style="background: url(images/icn_edit.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">

									<input id="apagar1" type="button" value=""onclick="funcao1('Apagar','${bluRay.titulo}');"
									class="submit_btn"style="background: url(images/icn_trash.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">

								</td>
							</c:forEach>
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