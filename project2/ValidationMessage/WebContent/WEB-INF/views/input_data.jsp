<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags" %>
--%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<%--
	<form action='input_pro' method='post'>
		data1 : <input type='text' name='data1'><br>
		<spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data1') }">
				<spring:message code="${errors.getFieldError('data1').codes[0] }"/><br>
			</c:if>
		</spring:hasBindErrors>
		data2 : <input type='text' name='data2'><br>
		<spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data2') }">
				<spring:message code="${errors.getFieldError('data2').codes[0] }"/><br>
			</c:if>
		</spring:hasBindErrors>
		<button type='submit'>확인</button>
	</form> 
	--%>
	
	<!-- form 커스텀태그를 이용하는 방법이 최종방법. 가장 깔끔하다. -->
	<form:form action='input_pro' modelAttribute="dataBean1" method='post'>
		data1 : <form:input path='data1' type='text'/><br>
				<form:errors path='data1' /><br>
		data2 : <form:input path='data2' type='text'/><br>
				<form:errors path='data2' /><br>
		<form:button type='submit'>확인</form:button>
	</form:form>
</body>
</html>