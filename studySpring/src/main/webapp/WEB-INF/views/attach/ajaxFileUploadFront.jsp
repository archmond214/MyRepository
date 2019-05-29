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

    <title> 비동기 (Spring MVC)</title>
<script type="text/javascript" defer="defer">
    	$(document).ready(function(){
    	//첨부 파일 추가...
    		$(".btn_file_new").on("click",function(){
    			
    			var fileView = "";
    			
    			fileView = '<div>';
    			fileView += ' <input type="file" name="attachFiles">';
    			fileView += ' <button type="button"';
    			fileView += ' class="btn_file_remove form-control"> 삭제 </button>';
    			fileView += ' </div>';
    			$(".file_area").append(fileView);
    		
    		});
    		//신규 파일 삭제
    		
    		$(".file_area").on("click",".btn_file_remove",function(){
    			$(this).parent().remove();
    		});
    		//폼 (submit) 이벤트
    		$("#fileVo").on("submit",function(event){
    			event.preventDefault();
    			//파일 업로드 jquery.form.js 파일을 추가
    			//post 방식으로 비동기 파일 업로드 플러그인 설치...ajaxSubmit 메소드 사용
    		$(this).ajaxSubmit({
    			type: 'post',
    			url: '/attach/ajaxFileUploadProc.json',
    			data: $('#fileVo').serialize(),
    			success:function(msg){
    				alert(JSON.stringify(msg));
    			},
    			error:function(jqXhr, textStatus, errorMessage){
    				alert(errorMessage);
    				}
    		});
    	});
    });
</script>
    
  </head>

  <body>
  
	<!--  -->
	<!--  -->
	<form id="fileVo" name="fileVo" method="post" enctype="multipart/form-data">
		<!-- <input type="text" name="serviceType" value="NOTICE" > -->
		<select name="serviceType" class="form-control">
		<option value ="FAQ" ${boardInfo.serviceType eq 'FAQ' ? 'selected="selected"':'' }> 댕댕댕</option>
  		<option value ="NOTICE" ${boardInfo.serviceType eq 'NOTICE' ? 'selected="selected"':'' }> 냥냥냥</option>
  		<option value ="DATA" ${boardInfo.serviceType eq 'DATA' ? 'selected="selected"':'' }> 배경</option>
		
		</select>
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boTitle" size="60"></td>
				</tr>
			
				<tr>
					<th>첨부 파일</th>
					<td>
						<div class="file_area">
							<div>
							<button type="button" class="btn_file_new form-control">추가</button>
							</div>
						
							<div>
							<input type="file" name="attachFiles">
							<button type="button" class="btn_file_remove form-control">삭제</button>
							</div>
						</div>
					</td>
				</tr>
				
			<tr>
				<td colspan="2"> <button type="submit">저장</button></td>
			</tr>
			</tbody>
		</table>
	</form>  

  
  		
  	
  </body>
</html>