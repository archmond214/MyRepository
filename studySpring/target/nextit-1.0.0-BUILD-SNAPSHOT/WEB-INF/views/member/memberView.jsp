<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="개인 프로젝트...">
    <meta name="author" content="길현종">

    <title> 회원 상세 정보 (View)</title>
    
  </head>

  <body>
  
 
  
  
  <form action="/member/memberUpdateFront.do" method="post">
  		<table class="table" >
  			<tbody>
  				<tr>
  					<th>아이디</th>
  					<td>${memberInfo.usrId }</td>
  				</tr>
  				<tr>
  					<th>비밀번호</th>
  					<td>${memberInfo.usrPwd }</td>
  				</tr>
  				<tr>
  					<th>이름</th>
  					<td>${memberInfo.usrName }</td>
  				</tr>
  				<tr>
  					<th>이메일</th>
  					<td>${memberInfo.usrEmail }</td>
  				</tr>
  				<tr>
  					<th>핸드폰</th>
  					<td>${memberInfo.usrHp }</td>
  				</tr>
  				<tr>
  					<th>팩스</th>
  					<td>${memberInfo.usrFax }</td>
  				</tr>
  				<tr>
  					<th>성별</th>
  					<td>
  						<select name="usrGender" class="form-control">
  							<option value="M" ${memberInfo.usrGender eq 'M'? 'selected="selected"' : '' }>남성</option>
  							<option value="W" ${memberInfo.usrGender eq 'W'? 'selected="selected"' : '' }>여성</option>
  						</select>
  					</td>
  				</tr>
  				<tr>
  					<th>나이</th>
  					<td>${memberInfo.usrAge }</td>
  				</tr>
  				<tr>
  					<th colspan="2">
  						<c:url var="updateUrl" value="/member/memberUpdateFront.do">
  							<c:param name="seqNo" value="${memberInfo.seqNo }"/>
  						</c:url>
  						
  						
  						<a href="${updateUrl}">수정</a>
  						
  						<c:url var="deleteUrl" value="/member/memberDeleteProc.do">
  							<c:param name="seqNo" value="${memberInfo.seqNo }"/>
  						</c:url>
  						
  						
  						<a href="${deleteUrl }">삭제</a>
  						
  					</th>
  					
  				</tr>
  				
  			</tbody>
  		</table>
  		
  		
  	</form>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  		
  	
  </body>
</html>