<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>

	<section id="segunda_barra"><!-- essa barra é só pra separar as coisas --></section>
	
	<div align="center" >
	        <fieldset style="width:60%;">
	            <legend>ENTRAR</legend>
	        <form action="ServletLogin" method="post">
	            
	        <label>Login: </label>
	        <input type="text" name="nome" placeholder="Digite o seu login" required>
	       
        
        	
	        <label>Senha: </label>
	        <input type="password" name="senha" placeholder="Digite a sua senha" required>
	       
        
       
	       	  
	       <footer>
	       	<div class="espaco" style="margin-top:3%;"></div>
				<div class="area_de_botoes">
					
					<input type="submit" value="Concluir" class="btn_concluir">
					<input type="reset" value="Limpar">
				</div>
			</footer>
			
	        </form>
        
        
	        </fieldset>
	    </div>
		<div class="espaco"></div>
	</section>


</body>

</html>