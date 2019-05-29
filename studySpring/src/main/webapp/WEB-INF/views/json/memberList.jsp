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

    <title> json  회원 목록  (Spring MVC)</title>
    <script type="text/javascript">
    
    $(document).ready(function() {
		//<form id="searchVo" action="" method="get">
    	//form tag 안에서 엔터 또는 클릭 이벤트를 잡아서 처리 할 경우...    	
    	$("#searchVo").on("submit",function(e){
    		//$("#btnSearchEvent").on("click",function(e){
    		e.preventDefault(); //기본 이벤트 막기 
    		
    		alert($('#searchVo').serialize());
    		
    		$.ajax('/json/memberListProc.json',{
    			method : "POST",
    			dataType : "json", // type of response data
    			data : $('#searchVo').serialize(),
    				success:function(data,status,xhr){ // success callback function
    					console.log(data);
    					 
    					$('#memberList').empty();
    					//List객체
    					$.each(data, function(idx, item){
    						var rs="";	
    						rs += '<tr>';
    	    				rs += ' <th> ' + item.usrId + '  </th>';
    	    				rs += ' <th> ' + item.usrName + '</th>';
    	    				rs += ' <th> ' + item.usrEmail + '</th>';
    	    				rs += ' <th> ' + item.usrHp + '</th>';
    	    				rs += ' <th> ' + item.regDt + '</th>';
    	    				rs += '</tr>';
    					
    					$("#memberList").append(rs);
    				});
    				},
    				error : function(jqXhr, textStatus, errorMessage){ //error callback
    					console.log(jqXhr);
    					console.log(textStatus);
    					console.log(errorMessage);
    			}
    		}); //$.ajax end
    	});// on ("click") end
    });//document end
    
    
    </script>
  </head>

  <body>
  
  	<form id="searchVo" action="" method="get">
  	<input type="hidden" name="curPage" value="1">
  		<table class="table">
  			<tr>
  				<th> 검색 조건 </th>
  				<th>
  					<select name="searchType">
  						<option value="usr_id"> 아이디 </option>
  						<option value="usr_name"> 이름 </option>
  						<option value="usr_email"> 이메일 </option>
  					</select>
  				</th>
  				<th> 검색어 </th>
  				<th><input type="text" name="searchText"></th>
  				<th>
  					<button id="btnSearchEvent" type="submit"> 검색</button>
  				</th>
  				<th>
  					<a href="/json/memberInsertFront.do"> 회원 가입</a>
  				</th>
  			</tr>
  		</table>
  	</form>
  
  
  
  	<table class="table">
  		<thead>
  			<tr>
				<th colspan="5">
					<button id="btnSearchEvent" type="button" > 검색 </button>
				</th>
			</tr>  
  		
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 이메일 </th>
				<th> 핸드폰 </th>
				<th> 가입일 </th>
			</tr>  		
  		</thead>
  		<tbody id="memberList">
  		
  		
  		
  		</tbody>
  	
  	
  	
  	</table>
  		
  	
  </body>
</html>