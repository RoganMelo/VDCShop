<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>
	
	
	
	<section id="principal" class="column">
		
		<h4 class="alert_info">Bem vindo a Loja VDC</h4>
		
			
		<article class="modulo width_full">
		<header><h3 class="tabs_involved">Carrinho</h3>
		
		</header>

			<form id="form1" action="ServletPedido">
			<div id="tab1" class="tab_conteudo">
			
			<table class="tabela"> 
			<thead> 
				<tr> 
   					<th>Nome</th>
					<th>Quantidade</th>  
    				<th>Preço</th>
    				<th>Preço total</th>  
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.titulo}</td>
							<td>${produto.quantidade}</td>
							<td>${produto.preco}</td>
							<td>${produto.preco * produto.quantidade}</td>
						</tr>								
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td><b>Total</b></td>
							<td><b>${pedido.getTotal()}</b></td>
						</tr>
						
			</tbody> 
			</table>
			</div><!-- final #tab1 -->
			<footer>
						
				<label style="padding-left: 10px;">Forma de pagamento: </label>
				<select style="width:20%; padding-left: 10px; margin-top: 5px;">
								<option>Cartão</option>
								<option>Boleto</option>
								<option>Débito</option>
				</select>

				<div class="area_de_botoes">

					
					<input type="submit" name="operacao" value="Concluir" class="btn_concluir">
					<input type="submit" name="operacao" value="Cancelar">
				
				</form>
				</div>
			</footer>
				
		</article>


		<div class="limpar"></div>
		
			

		
		
		<div class="espaco"></div>
	</section>


</body>

</html>