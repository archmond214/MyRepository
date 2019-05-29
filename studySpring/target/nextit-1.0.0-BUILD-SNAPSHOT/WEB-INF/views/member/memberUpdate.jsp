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

    <title> 회원 정보 수정 하기</title>
    
  </head>

  <body>
  	<form action="/member/memberUpdateProc.do" method="post">
  		<input type="hidden" name="seqNo" value="${memberInfo.seqNo }">
  		<table class="table">
  			<tbody>
  				<tr>
  					<th>아이디</th>
  					<td><input type="text" name="usrId"  class="form-control" value="${memberInfo.usrId }"></td>
  				</tr>
  				<tr>
  					<th>비밀번호</th>
  					<td><input type="password" name="usrPwd" class="form-control" value="${memberInfo.usrPwd }"></td>
  				</tr>
  				<tr>
  					<th>이름</th>
  					<td><input type="text" name="usrName" class="form-control" value="${memberInfo.usrName }"></td>
  				</tr>
  				<tr>
  					<th>이메일</th>
  					<td><input type="text" name="usrEmail" class="form-control" value="${memberInfo.usrEmail }"></td>
  				</tr>
  				<tr>
  					<th>핸드폰</th>
  					<td><input type="text" name="usrHp" class="form-control" value="${memberInfo.usrHp }"></td>
  				</tr>
  				<tr>
  					<th>팩스</th>
  					<td><input type="text" name="usrFax" class="form-control" value="${memberInfo.usrFax }"></td>
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
  					<td><input type="number" name="usrAge" class="form-control"></td>
  				</tr>
  				<tr>
  					<th colspan="2">
  						<button type="submit" class="form-control" >수정</button>
  					</th>
  					
  				</tr>
  			</tbody>
  		</table>
  	</form>
  		
  </body>
</html>