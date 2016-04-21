<%@ include file="topo.jsp"%>
<%@ include file="menu.jsp"%>



	<section id="principal" class="column">

		<h4 class="alert_info">Bem vindo a pagina de Edição de CD</h4>


		<div class="limpar"></div>

		<article class="modulo width_full">
			<header>
				<h3>Editar CD</h3>
			</header>
			<div class="conteudo_do_modulo">
				<form id="form1" action="ServletCd" method="post">
					<fieldset>
						<label>Titulo</label> 
						<input type="text" name="titulo" value="${cd.titulo}"> <br> <br>
						<label>Preço</label> 
						<input type="number" name="preco" value="${cd.preco}" required="required"pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$" step="0.01" min="0" />
						<br> <br> <br> <br> <br> <br> 
						<label>Data	de Lançamento</label> 
						<input type="date" value="${cd.data_de_publicacao}" name="dataLancamento" required="required" /><br>

						<div class="espaco"></div>

						<label>Duplo ?</label> <br> <br> 
						<input type="checkbox" name="duplo" <c:if test="${cd.isDuplo()}">checked="checked"</c:if> value="sim"> <br> <br> 
						
						<label>Número de faixas</label> 
						<input type="text" name="faixas" value="${cd.quantidade_faixas}" required="required" name="numbers"	pattern="[0-9]+$" min="0"/> <br> <br> 
						
						<label>Quantidade</label>
						<input type="number" name="quantidade" value="${cd.quantidade}" required="required" name="numbers"
							pattern="[0-9]+$" min="0"/> <br> <br>

					</fieldset>
			</div>
			<footer>
				<div class="area_de_botoes">

					<input type="submit" value="Alterar" name="operacao" class="btn_concluir">
					<input type="reset" value="Limpar">
					<input  id="nomeProduto" name="nomeProduto" type="hidden" value="${cd.titulo}"/>
				</div>
			</footer>
			</form>
		</article>
		<!-- fim do form -->



		<div class="espaco"></div>
	</section>


</body>

</html>