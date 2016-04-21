<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo ao cadastro de Blu Ray</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Adicionar Bluray</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form action="ServletBluRay" method="post">
					<fieldset>
						<label>Titulo</label> <input type="text" name="titulo"> <br>
						<br> <label>Preço</label> <input type="number" name="preco"
							required="required" pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$"
							step="0.01" min="0" id="valor_preco" /> <br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<!-- colocar  -->
						<label>Data de Lançamento</label> <input type="date" pattern="dd/MM/yyyy" name="dataLancamento"
							required="required" id="bluray_data" /><br>

						<div class="espaco"></div>

						<label>Duplo ?</label> <br>
						<br> <input type="checkbox" name="duplo" value="true" id="bluray_duplo">
						<br>
						<br> <label> Tema</label> <br>
						<br> <input type="radio" name="tema" value="Acao"
							id="bluray_temaAcao">Ação <input type="radio" name="tema"
							value="Aventura" id="bluray_temaAventura">Aventura <input
							type="radio" name="tema" value="Ficcao" id="bluray_temaFiccao">Ficção
						<br>

						<div class="espaco"></div>


						<label>Quantidade</label> <input type="number" name="quantidade" min="0"
							required="required" pattern="[0-9]+$" id="bluray_qtd" />
					</fieldset>
			</div>
			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" name="operacao" value="Adicionar" class="btn_concluir"
						id="concluirBluRay">
						 <input type="reset" value="Limpar"
						id="limparBluRay">
				</div>
			</footer>
			</form>
		</article>
		<!-- fim do form -->



		<div class="espaco"></div>
	</section>


</body>

</html>