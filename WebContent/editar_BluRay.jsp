<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>


<section id="principal" class="column">

	<h4 class="alert_info">Bem vindo a pagina de edição de Blu Ray</h4>


	<div class="limpar"></div>

	<article class="modulo width_full">
		<header>
			<h3>Adicionar Bluray</h3>
		</header>
		<form action="ServletBluRay" method="post">
			<div class="conteudo_do_modulo">
				<fieldset>
					<label>Titulo</label> 
					<input type="text" name="titulo" value="${bluRay.titulo}"> <br><br> 
					
					<label>Preço</label> 
					<input type="number" name="preco" value="${bluRay.preco}"required="required" pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$"
						step="0.01" min="0" id="valor_preco" /> <br> <br> <br>
					<br> <br> <br>
					
					
					<!-- colocar  -->
					<label>Data de Lançamento</label> 
					<input type="date" name="dataLancamento" value="${bluRay.data_de_publicacao}" pattern="dd/MM/yyyy" required="required" id="bluray_data" /><br>

					<div class="espaco"></div>

					<label>Duplo ?</label> <br> <br> 
					<input type="checkbox" <c:if test="${bluRay.isDuplo()}">checked="checked"</c:if> name="duplo" value="" id="bluray_duplo">
						
						
						 <br> <br> <label>
						Tema</label> <br> <br> 
						<input type="radio" name="tema"	value="Acao" ${bluRay.tema == 'Acao' ? 'checked' : ''} id="bluray_temaAcao">Ação
						<input type="radio" name="tema"	value="Aventura" ${bluRay.tema == 'Aventura' ? 'checked' : ''} id="bluray_temaAcao">Aventura
						<input type="radio" name="tema"	value="Ficcao" ${bluRay.tema == 'Ficcao' ? 'checked' : ''} id="bluray_temaAcao">Ficção

					<div class="espaco"></div>


					<label>Quantidade</label> 
					<input type="number" name="quantidade" value="${bluRay.quantidade}" min="0" required="required" pattern="[0-9]+$" id="bluray_qtd" />
				</fieldset>
			</div>
			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" value="Alterar" class="btn_concluir"
						id="concluirBluRay" name="operacao"> <input
						type="reset" value="Limpar" id="limparBluRay">
					<input  id="nomeProduto" name="nomeProduto" type="hidden" value="${bluRay.titulo}"/>
				</div>
		</form>
		</footer>
	</article>
	<!-- fim do form -->



	<div class="espaco"></div>
</section>


</body>

</html>