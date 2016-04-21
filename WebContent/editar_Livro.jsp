<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo ao editar  de Livros</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Editar Livro</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form action="ServletLivro" method="post">
					<fieldset>
						<label>Titulo</label> 
						<input type="text" name="titulo" value="${livro.titulo}"> <br> <br>
						<label>Preço</label> 
						<input type="number" required="required" name="preco" value="${livro.preco}"
							pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" step="0.01" min="0" />
						<br> <br> <br> <br> <br> <br> 
						<label>Data	de Lançamento</label> 
						<input type="date" required="required" name="dataLancamento" value="${livro.data_de_publicacao}"/> <br>	<br> 
						
						<label>Edição</label> <br> <br> 
						<select name="edicao">
							<option value="" ${livro.edicao == '1' ? 'selected="selected"' : ''}>1°</option>
							<option value="" ${livro.edicao == '2' ? 'selected="selected"' : ''}>2°</option>
							<option value="" ${livro.edicao == '3' ? 'selected="selected"' : ''}>3°</option>
						</select> <br> <br> <br> 
						<label> Tema</label> <br> <br>
						<input type="radio" name="tema" value="Acao" ${livro.tema == 'Acao' ? 'checked' : ''}>Ação 
						<input type="radio" name="tema" value="Aventura" ${livro.tema == 'Aventura' ? 'checked' : ''}>Aventura 
						<input type="radio" name="tema" value="Ficcao" ${livro.tema == 'Ficcao' ? 'checked' : ''}>Ficção <br>
						<br> 
						<label>ISBN</label> <input type="number" value="${livro.ISBN}"
							required="required" name="ISBN" pattern="[0-9]+$" /> <br>
						<br> 
						<label>Quantidade</label> 
						<input type="number" required="required" name="quantidade" value="${livro.quantidade}" pattern="[0-9]+$" min="0"/> <br>
						<br>

					</fieldset>

			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" name="operacao" value="Alterar"
						class="btn_concluir">
					<input type="reset" value="Limpar">
					<input  id="nomeProduto" name="nomeProduto" type="hidden" value="${livro.titulo}"/>
				</div>
			</footer>
			</form>
		</article>
		<!-- fim do form -->



		<div class="espaco"></div>
	</section>


</body>

</html>