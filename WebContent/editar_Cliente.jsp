<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>

	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo à página de edição de clientes</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Editar Cliente</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form action="ServletCliente" method="post">
					
					<fieldset>
						<label>Nome</label> 
						<input type="text" name="nome" value="${cliente.nome}" > <br> <br>
						
						<label>CPF</label> 
						<input type="number" required="required" name="CPF" value="${cliente.cpf}" pattern="[0-9]+$" /> <br> <br> 
						
						<label>Endereço</label>
						<input type="text" name="endereco" value="${cliente.endereco}">
					</fieldset>
			</div>

			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" value="Alterar" name="operacao" class="btn_concluir">
					<input type="reset" value="Limpar">
					<input  id="nomeProduto" name="nomeProduto" type="hidden" value="${cliente.nome}"/>
				</div>
			</footer>
			</form>
		</article>
		<!-- fim do form -->



		<div class="espaco"></div>
	</section>


</body>

</html>