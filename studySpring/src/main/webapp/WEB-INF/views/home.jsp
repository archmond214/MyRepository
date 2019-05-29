<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
	<title>${userTitle}</title>
</head>
<body>
<h1>
	Hello world!  ha~ha~ha!
</h1>
<P>  The time on the server is ${serverTime}. </P><br>
get post test~~~<br>

<form action="/test/getTest.do" method="get">
	<input type="text" name="title"><br>
	<input type="text" name="name"><br>
	<input type="text" name="age"><br>
	<input type="password" name="pw"><br>
	<button type="submit">get test Event </button>
</form>

<form action="/test/postTest.daum" method="post">
	<input type="text" name="title"><br>
	<input type="text" name="name"><br>
	<input type="text" name="age"><br>
	<input type="password" name="pw"><br>
	<input type="email" name="email"><br>
	<button type="submit">post test Event </button>
</form>

<br><br>



	<spring:message code="fail.common.msg"/><br>
  	<spring:message code="fail.common.sql"/><br>
  	<spring:message code="errors.required"/><br>
  	<spring:message code="errors.minlength"/><br>
  	
  	
  	<spring:message code="fail.common.sql" arguments="119, 말짜!"/><br>
  	<spring:message code="errors.required" arguments="입력하고자, 하는 이름"/><br>
  	
  	<c:set var="test" value="한글은 넘무 좋아영||55"></c:set>
  	<spring:message var="errorMessage" code="fail.common.sql" arguments="${test }" argumentSeparator="||"/><br>
  	<spring:message code="errors.required" arguments="입력하고자, 하는 이름" argumentSeparator="&&"/><br>	
  	
  	${errorMessage }



</body>
</html>
