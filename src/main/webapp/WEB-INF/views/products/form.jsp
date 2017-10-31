<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	<!-- O Spring disponibiliza na view os erros de validacao encontrados -->
	<!--<c:forEach items="${requestScope['org.springframework.validation.BindingResult.product'].allErrors}" var="error">
		${error.field} ${error.code}<br/>
	</c:forEach>-->
	
	<!-- Exibe os errors com a taglib do Spring -->
	<!-- <spring:hasBindErrors name="product">
		<ul>
			<c:forEach items="${errors.allErrors}" var="error">
				<li style="color:red;">${error.field} ${error.code}</li>
				<li style="color:red;"><spring:message code="${error.code}" text="${error.defaultMessage}"/></li>
			</c:forEach>
		</ul>
	</spring:hasBindErrors> -->

	<h3>Cadastro de produtos <span class="badge badge-primary">Casa do Código</span></h3>
	<hr class="my-4">
	
	<!-- Form links -->
	<c:url value="/" var="home" />
	<c:url value="/produtos" var="produtos" />
	
	<form:form method="POST" action="${produtos}" style="width: 40%;" commandName="product">
		<div class="form-group">
			<label for="title" style="font-weight:bold;">Título</label> 
			<form:input path="title" class="form-control" placeholder="Ex: Spring MVC - Domine o Principal Framework Web" />
			<form:errors path="title" style="color:red; font-size:12px;" />
		</div>
		<div class="form-group">
			<label for="description" style="font-weight:bold;">Descrição</label>
			<form:textarea path="description" class="form-control" placeholder="Ex: eBook Spring MVC" rows="5" cols="20" />
			<form:errors path="description" style="color:red; font-size:12px;" />
		</div>
		<div class="form-group">
			<label for="pages" style="font-weight:bold;">Número de paginas</label> 
			<form:input path="pages" placeholder="Páginas" class="form-control" style="width: 25%;" />
			<form:errors path="pages" style="color:red; font-size:12px;" />
		</div>
		<div class="form-group">
			<label for="releaseDate" style="font-weight:bold;">Data de lançamento</label> 
			<form:input type="date" path="releaseDate"/>
			<form:errors path="releaseDate"/>
		</div>
		<!-- Para passar uma lista de valores do formulário para o controller do Spring MVC, é necessário o uso do [] -->
		<!-- Usamos o varStatus para conseguir ter acesso ao índice atual do loop e, com isso, ir construindo os inputs. -->
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div class="form-group" style="width: 25%;">
				<label for="price_${bookType}" style="font-weight:bold;">${bookType}</label> 
				<form:input placeholder="R$ Preço" class="form-control" path="prices[${status.index}].value" id="price_${bookType}" /> 
				<form:hidden class="form-control" path="prices[${status.index}].bookType" value="${bookType}" />
			</div>
		</c:forEach>
		<div>
			<input type="submit" class="btn btn-primary" value="Enviar">
			<a class="btn btn-light" href="${home}" role="button">Voltar</a>
		</div>
	</form:form>
</body>
</html>