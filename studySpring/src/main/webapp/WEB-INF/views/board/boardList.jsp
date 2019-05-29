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

    <title> 게시판 목록 (Board List) </title>
    
  </head>

  <body>
  
  	<table class="table">
  		<thead>
  		
  				<tr>
  					<td colspan="4" style="text-align:center;">
  						<c:url var="insertUrl" value="/board/boardInsertForm.do"/>
  						<a href="${insertUrl }" class="btn btn-default"> 등록 </a>
  					</td>		
  				</tr>
  		
  				<tr>
  					<th>순번</th>
  					<th>제목</th>
  					<th>작성자</th>
  					<th>조회수</th>
  					<th>사진</th>
  					
  				</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="boardVo" items="${boardList }"> 
  			<c:url var="viewUrl" value="/board/boardViewFront.do">
  				<c:param name="seqNo" value="${boardVo.seqNo }"></c:param>
  			</c:url>
  			
			
  				<tr>
  					<td>${boardVo.num }</td>
  					<td>
  						<a href="${viewUrl}">
  							${boardVo.title }
  						</a>
  					</td>
  					
  					<td>${boardVo.updUser }</td>
  					<td>${boardVo.readCount }</td>
  					
  					
  					<c:forEach var="attachVo" items="${attachList }"> 
			  			<c:url var="downloadUrl" value="/attach/fileDownload.do">
			  				<c:param name="seqNo" value="${boardVo.seqNo }"></c:param>
			  			</c:url>
  					
  					<td>미리보기
	  					<img alt="사진" src="${downloadUrl }" width="150px" height="150px">
	  				</td>
	  				</c:forEach>
  				</tr>
  			
  		</c:forEach>
  		</tbody>
  	</table>
  </body>
</html>