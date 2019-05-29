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

    <title> 회원 가입</title>
    
	<script type="text/javascript">
	
	//회원 가입시 id 체크시 사용할 json Type 초기 데이터 생성.
	var joinInfo = {status:false,checkId:"",message:""};
	
    $(document).ready(function() {
		//<form id="searchVo" action="" method="get">
    	//form tag 안에서 엔터 또는 클릭 이벤트를 잡아서 처리 할 경우...    	
    	$("#memberInsert").on("submit",function(e){
    		//$("#btnSearchEvent").on("click",function(e){
    		e.preventDefault(); //기본 이벤트 막기 
    		alert("가입 버튼 클릭");
    		alert($('#memberInsert').serialize());
    	
    		alert("아이디 체크 여부.."+ joinInfo.status);
    		//서버에서 인증된 아이디 
    		alert(joinInfo.checkId);
    		//html화면에 입력된 input value 
    		alert($('input[name=usrId]').val());
    		var userId =$('input[name=usrId]').val();
    		
    		if(!joinInfo.status &&joinInfo.checkId != userId){
    			// 인증 받고, 입력된 아이디와, input value 값이 동일 한지 비교... 동일=가입진행
	    		/* 	alert("회원 가입 ajax 실행..");
	    		}else{ */
    			// 인증 체크를 다시 시도....
    			alert("아이디 중복 체크를 다시 시도해주세요"); 
    			//submit 이벤트 종료..
    			return false;
    		}
       		$.ajax('/json/insertMemberInfo.json',{
    			method : "POST",
    			dataType : "json", // type of response data
    			data : $('#memberInsert').serialize(),
    				success:function(data,status,xhr){ // success callback function
    					console.log(data);
    					alert(JSON.stringify(data));
    					if(data.status){
    						location.href="/json/memberListFront.do";
    					}
    				},
    				error : function(jqXhr, textStatus, errorMessage){ //error callback
    					console.log(jqXhr);
    					console.log(textStatus);
    					console.log(errorMessage);
    			}
    		}); //$.ajax end
       	}); // on ("click") end
       	
    	 	$("#idCheck").on("click",function(e){
       			//$("#btnSearchEvent").on("click",function(e){
           		e.preventDefault(); //기본 이벤트 막기 
           		alert("중복 체크 클릭");
           		alert($('#memberInsert').serialize()); 
       		
    	 	$.ajax('/json/findIdCheckProc.json',{
    			method : "POST",
    			dataType : "json", // type of response data
    			data : $('#memberInsert').serialize(),
    			
    				success:function(data,status,xhr){ // success callback function
    					console.log(data);
    					alert(data.message);
    					alert(data.status);
    			
    					if(data.status){
    						joinInfo = data;
    					}
    				},
    				error : function(jqXhr, textStatus, errorMessage){ //error callback
    					console.log(jqXhr);
    					console.log(textStatus);
    					console.log(errorMessage);
    			}
    		}); //$.ajax end
       	}); // on ("click") end
    }); //document end
    
</script>
  
  </head>

  <body>
  	
  	<form action="" id="memberInsert" method="post">
  		<table class="table" >
  			<tbody>
  				<tr>
  					<th>아이디</th>
  					<td><input type="text" name="usrId" class="form-control"></td>
  					<td><button id="idCheck" type="button" class="btn btn-default"> 아이디 중복 체크 </td>
  				</tr>
  				<tr>
  					<th>비밀번호</th>
  					<td><input type="password" name="usrPwd" class="form-control"></td>
  				</tr>
  				<tr>
  					<th>이름</th>
  					<td><input type="text" name="usrName" class="form-control"></td>
  				</tr>
  				<tr>
  					<th>이메일</th>
  					<td><input type="text" name="usrEmail" class="form-control"></td>
  				</tr>
  				<tr>
  					<th>핸드폰</th>
  					<td><input type="text" name="usrHp" class="form-control"></td>
  				</tr>
  				<tr>
  					<th>팩스</th>
  					<td><input type="text" name="usrFax" class="form-control"></td>
  				</tr>
  				<tr>
  					<th>성별</th>
  					<td>
  						<select name="usrGender" class="form-control">
  							<option value="M">남성</option>
  							<option value="W">여성</option>
  						</select>
  					</td>
  				</tr>
  				<tr>
  					<th>나이</th>
  					<td><input type="number" name="usrAge" class="form-control"></td>
  				</tr>
  				<tr>
  					<th colspan="2">
  						<button type="submit" class="form-control" >가입</button>
  					</th>
  					
  				</tr>
  				
  			</tbody>
  		</table>
  		
  		
  	</form>
  	
  </body>
</html>