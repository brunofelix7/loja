<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de produtos</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
		integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
		crossorigin="anonymous">
	<style>
	html {
		margin: 20px;
	}
	</style>
</head>
<body>
	<h3>
		Cadastro de produtos <span class="badge badge-primary">Casa do
			Código</span>
	</h3>
	<hr class="my-4">
	<form method="POST" action="/loja/produtos" style="width: 40%;">
		<div class="form-group">
			<label for="title">Título</label> <input type="text"
				class="form-control"
				placeholder="Ex: Spring MVC - Domine o Principal Framework Web"
				name="title" id="title">
		</div>
		<div class="form-group">
			<label for="description">Descrição</label>
			<textarea class="form-control" placeholder="Ex: eBook Spring MVC"
				name="description" id="description" rows="5" cols="20"></textarea>
		</div>
		<div class="form-group">
			<label for="pages">Número de paginas</label> <input type="text"
				placeholder="Páginas" class="form-control" name="pages" id="pages"
				style="width: 25%;">
		</div>
		<!-- Para passar uma lista de valores do formulário para o controller do Spring MVC, é necessário o uso do [] -->
		<!-- Usamos o varStatus para conseguir ter acesso ao índice atual do loop e, com isso, ir construindo os inputs. -->
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div class="form-group" style="width: 25%;">
				<label for="price_${bookType}">${bookType}</label> <input
					type="text" placeholder="R$ Preço" class="form-control"
					name="prices[${status.index}].value" id="price_${bookType}" /> <input
					type="hidden" class="form-control"
					name="prices[${status.index}].bookType" value="${bookType}" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" class="btn btn-primary" value="Enviar">
			<a class="btn btn-light" href="/loja" role="button">Voltar</a>
		</div>
	</form>
</body>
</html>