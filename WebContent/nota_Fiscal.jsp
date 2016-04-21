<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>
	
	
	<section id="principal" class="column">
		
		<h4 class="alert_info">Bem vindo a Loja VDC</h4>
		
			
		<article class="modulo width_full">
		<header><h3 class="tabs_involved">Nota</h3>
		
		</header>

		
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
				 
			</tbody> 
			</table>
			</div><!-- final #tab1 -->
			<footer>
				
				<div class="area_de_botoes">
					<label style="padding-left: 10px;"><b>Total: </b>   <b> ${pedido.getTotal()}</b> </label>
										
				</div>
			</footer>
				
		</article>


		<div class="limpar"></div>
		
			
		
		
		
		<div class="espaco"></div>
	</section>


</body>

</html>