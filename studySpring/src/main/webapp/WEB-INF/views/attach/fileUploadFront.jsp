<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="개인 프로젝트...">
    <meta name="author" content="길현종">

    <title> 파일 업로드...(Spring MVC)</title>
    
  </head>

  <body>
  
  <h1>${fileInfo.status}:${fileInfo.message}</h1>
  
  
  <!-- 첨부 파일을 보내기 위해서는
  <form action="attach/fileUploadProc.do" enctype="multipart/form-data" method="post">
  	enctype, emthod 필수!!!!필수필수!
   -->
  	<form action="/attach/fileUploadProc.do" enctype="multipart/form-data" method="post">
  		<table class="table">
		  	<tbody>
		  		<tr>
		  			<td><input type="text" name="title"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td>
		  				<button type="submit" > 파일 업로드 </button>
		  			</td>
		  		</tr>
		  	</tbody>
  		</table>
  	</form>	
  	
  	<hr><hr>
  	  	<form action="/attach/fileUploadPartProc.do" enctype="multipart/form-data" method="post">
  		<table class="table">
		  	<tbody>
		  		<tr>
		  			<td><input type="text" name="title"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td>
		  				<button type="submit" > 파일 업로드 </button>
		  			</td>
		  		</tr>
		  	</tbody>
  		</table>
  	</form>	
  </body>
</html>