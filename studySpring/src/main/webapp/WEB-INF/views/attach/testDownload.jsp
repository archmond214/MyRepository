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

    <title> 다운로드~ (Spring MVC)</title>
    
  </head>

  <body>
  
  		<table class="table"> 
  		<tbody>
  				<tr>
  					<th>이미지 종류</th>
  					<td>
  						<select name="serviceType" class="form-control">
  							<option value ="FAQ" ${boardInfo.serviceType eq 'FAQ' ? 'selected="selected"':'' }> 댕댕댕 </option>
  							<option value ="NOTICE" ${boardInfo.serviceType eq 'NOTICE' ? 'selected="selected"':'' }> 냥냥냥 </option>
  							<option value ="DATA" ${boardInfo.serviceType eq 'DATA' ? 'selected="selected"':'' }> 배경</option>
  						</select>
  					</td>
  					
  				</tr>
  				</tbody>
  				
  			<c:forEach var="attachVo" items="${attachList}">
  			
	  			<c:url var="downloadUrl" value="/attach/fileDownload.do">
	  				<c:param name="seqNo" value="${attachVo.seqNo }"/>
	  			</c:url>
	  			
	  			<tr>
	  				<td>
	  					${attachVo.seqNo},
	  					${attachVo.fileName},
	  					${attachVo.saveSize}
	  				</td>
	  				<td>미리보기
	  					<img alt="" src="${downloadUrl}" width="150px" height="150px">
	  				</td>
	  				<td>
	  					<a href="${downloadUrl}">
	  						다운로드
	  					</a>
	  				</td>
	  			</tr>
  			</c:forEach>
  			<tr>
  			
  			</tr>
  		</table>
  	
  </body>
</html>