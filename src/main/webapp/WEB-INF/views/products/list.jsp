<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listagem de produtos</title>
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
	<c:if test="${not empty message}">
		<div class="alert alert-success" role="alert">
			${message}
		</div>
	</c:if>
	<table class="table">
		<thead class="thead-inverse">
			<tr>
				<td>Titulo</td>
				<td>Descrição</td>
				<td>Valores</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><a href="<c:url value='/produtos/show/'/>${product.id}">${product.title}</a></td>
					<td>${product.description}</td>
					<td>
						<c:forEach items="${product.prices}" var="price">
							[${price.value} - ${price.bookType}]
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
