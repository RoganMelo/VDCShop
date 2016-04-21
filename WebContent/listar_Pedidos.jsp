<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>

<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a Loja VDC</h4>


	<article class="modulo width_full">
		<header>
			<h3 class="tabs_involved">Pedidos</h3>

		</header>

		<!-- mudar de para input type submit -->
		<div id="tab1" class="tab_conteudo">
			<form id="form1" action="ServletPedido" method="post">
				<table class="tabela" cellspacing="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Produtos</th>
							<th>Total</th>
							<th>Ações</th>
						</tr>
					</thead>
						<tbody>
					<c:forEach items="${pedidos}" var="pedido">
						<tr>
							<td>${pedido.getId()}</td>
						 	<td>${pedido.getCliente().getNome()}</td>
							<td>${pedido.toString()}</td>
							<td>${pedido.getTotal()}</td>
							<td>

									<input id="apagar1" type="button" value="" onclick="funcao1('Apagar','${pedido.getId()}');" class="submit_btn"
									style="background: url(images/icn_trash.png) no-repeat; cursor: pointer; border: none; height: 20px; width: 20px;">
									
									
							</td>
						</tr>	
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