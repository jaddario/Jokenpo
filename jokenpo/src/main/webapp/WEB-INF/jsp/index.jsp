<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index JSP</title>
</head>
<body>
	<form:form action="criaJogador" modelAttribute="jogador">

		<h1>Adicione jogadores:</h1>
		<br>
		<br> Jogador: <form:input path="nome" />
		<br>
		<br> Jogada:
		<select id="country" name="country">
			<option value="PEDRA">Pedra</option>
			<option value="PAPEL">Papel</option>
			<option value="TESOURA">Tesoura</option>
			<option value="LAGARTO">Lagarto</option>
			<option value="SPOCK">Spock</option>
		</select>

		<input type="submit" value="Adicionar Jogador" />
	</form:form>


</body>
</html>