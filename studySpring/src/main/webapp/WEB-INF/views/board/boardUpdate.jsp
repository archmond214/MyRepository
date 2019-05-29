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

    <title> 게시판 수정 화면 </title>
    
  </head>

  <body>

  	<form action="/board/boardUpdateProc.do" method="post">
  		<input type="hidden" name="seqNo" value="${boardInfo.seqNo }">
  		<table class="table">
  			<tbody>
  				<tr>
  					<th>게시판 종류</th>
  					<td>
  						<select name="serviceType" class="form-control">
  							<option value ="FAQ" ${boardInfo.serviceType eq 'FAQ' ? 'selected="selected"':'' }> 공지사항</option>
  							<option value ="NOTICE" ${boardInfo.serviceType eq 'NOTICE' ? 'selected="selected"':'' }> 질의응답</option>
  							<option value ="DATA" ${boardInfo.serviceType eq 'DATA' ? 'selected="selected"':'' }> 자료실</option>
  						</select>
  					</td>
  					
  				</tr>
  				
  				<tr>
  					<th>제목</th>
  	
  					<td><input type="text" name="title"  class="form-control" value="${boardInfo.title }"></td>
  			
  				</tr>
  				
  				<tr>
  					<th>내용</th>
  					<td>
  						<textarea rows="20" cols="60" name="contents" class="form-control">${boardInfo.contents }</textarea>
  					</td>
  				</tr>
  				<tr>
  					<th colspan="2"> 
  						<button type="submit"> 저장 </button>
  					</th>
  				</tr>
  			
  			
  			</tbody>
  		
  		</table>
  	
  	</form>
  	
  </body>
</html>