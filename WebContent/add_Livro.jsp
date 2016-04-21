<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo ao cadastro de Livros</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Adicionar Livro</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form action="ServletLivro" method="post">
					<fieldset>
						<label>Titulo</label> <input type="text" name="titulo"> <br> <br>
						<label>Preço</label> <input type="number" required="required" name="preco"
							pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" step="0.01" min="0" />
						<br> <br> <br> <br> <br> <br> <label>Data
							de Lançamento</label> <input type="date" required="required" name="dataLancamento"/> <br>
						<br> <label>Edição</label> <br> <br> <select name="edicao">
							<option value="1">1°</option>
							<option value="2">2°</option>
							<option value="3">3°</option>
						</select> <br> <br> <br> <label> Tema</label> <br> <br>
						<input type="radio" name="tema" value="Acao">Ação <input
							type="radio" name="tema" value="Aventura">Aventura <input
							type="radio" name="tema" value="Ficcao">Ficção <br>
						<br> <label>ISBN</label> <input type="number"
							required="required" name="ISBN" pattern="[0-9]+$" /> <br>
						<br> <label>Quantidade</label> <input type="number"
							required="required" name="quantidade" pattern="[0-9]+$" min="0"/> <br>
						<br>

					</fieldset>
			</div>
			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" name="operacao" value="Adicionar"
						class="btn_concluir">
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