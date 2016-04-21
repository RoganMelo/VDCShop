<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt">

<head>
<meta charset="utf-8" />
<title>VDC Shop</title>

<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" />
<script src="javaScriptExterno.js"></script>

</head>


<body>

	<header id="cabecalho">
		<hgroup>
			<h1 class="nome_do_site">
				<a href="ServletPedido?paramLink=index">HOME - VDC Shop</a>
			</h1>
			
			<h2 class="nome_da_pagina">
			
			<form action="ServletPedido" method="post">
				<input name="operacao" style="float: left; width: 110px; margin: 15px;" value= "ConcluirPedido" id="Concluir_Compra" type="submit" class="btn_concluir"></input>
			</form>
			
				VDC <a style="float: right;" href="ServletPedido?paramLink=Sair">Logout</a>
			</h2>
			
		</hgroup>
	</header>

	<section id="segunda_barra">
		<!-- essa barra é só pra separar as coisas -->
	</section>
