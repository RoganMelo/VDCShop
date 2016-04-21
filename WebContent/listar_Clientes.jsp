<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>

<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a Loja VDC</h4>


	<article class="modulo width_full">
		<header>
			<h3 class="tabs_involved">Clientes</h3>

		</header>


		<div id="tab1" class="tab_conteudo">
			<form id="form1" action="ServletCliente" method="post">
				<table class="tabela" cellspacing="0">
					<thead>
						<tr>
							<th>Nome</th>
							<th>CPF</th>
							<th>Endereco</th>
							<th>Acoes</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>${cliente.nome}</td>
							<td>${cliente.cpf}</td>
							<td>${cliente.endereco}</td>
							<td>
									<input id="editar1" type="button" value="" onclick="funcao1('Editar','${cliente.nome}');" class="submit_btn"
									style="background: url(images/icn_edit.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									<input id="apagar1" type="button" value="" onclick="funcao1('Apagar','${cliente.nome}');" class="submit_btn"
									style="background: url(images/icn_trash.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
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