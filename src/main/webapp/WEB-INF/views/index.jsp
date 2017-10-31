<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
	<title>Home page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body> 
	<!-- Form links -->
	<c:url value="/" var="home" />
	<c:url value="/produtos/form" var="form" />

	<div>
	  <nav class="navbar navbar-dark bg-dark">
	    <a class="navbar-brand" href="${home}">eBook Spring MVC - Casa do Código</a>
	  </nav>
	</div>
	<div class="jumbotron">
	  <h1 class="display-3">Bem-vindo!</h1>
	  <p class="lead">O projeto está em desenvolvimento.</p>
	  <hr class="my-4">
	  <p>Acesse o conteúdo já desenvolvido até o presente momento.</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${form}" role="button">Produtos</a>
	  </p>
	</div>
</body>
</html>