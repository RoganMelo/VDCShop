function funcao1(operacao, nomeProduto) {
	
	 if(operacao == "CarrinhoLivro" || operacao == "CarrinhoCd" || operacao == "CarrinhoBluRay"){ 
		 if (confirm("Adicionar ao carrinho?")) {
			setAcao(operacao, nomeProduto);
			}
		}
	
	 else
	if(operacao == "Editar"){
		setAcao(operacao, nomeProduto);
	}
	
	else if(operacao == "Apagar"){
				if (confirm("Tem certeza que deseja excluir?")) {
					setAcao(operacao, nomeProduto);
		}
		
		

	if (operacao == "Carrinho"){
		setAcao(operacao, nomeProduto);
	}
}
	
	
function SomenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}

function redireciona(paramLink) {

	location.href = paramLink;
}

function setAcao(operacao, nomeProduto) {
	var campo = document.getElementById('operacao');
	var produto = document.getElementById('nomeProduto');
	campo.value=operacao;
	produto.value=nomeProduto;
	document.forms['form1'].submit();

}
}