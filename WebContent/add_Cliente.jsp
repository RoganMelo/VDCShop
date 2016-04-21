<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo ao cadastro de Clientes</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Adicionar Cliente</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form action="ServletCliente" method="post">
					<fieldset>
						<label>Nome</label> 
						<input type="text" name="nome"> <br> <br>
						
						<label>CPF</label> 
						<input type="text" required="required" name="CPF" pattern="[0-9]+$" /> <br> <br> 
						
						<label>Endereço</label>
						<input type="text" name="endereco">
					</fieldset>
			</div>
			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit"  name="operacao" value="Adicionar" class="btn_concluir">
					<input type="reset" value="Limpar">
				</div>
			</footer>
			</form>
		</article>
		<!-- fim do form -->



		<div class="espaco"></div>
	</section>


</body>

</html>