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

    <title> 제이슨 (Spring MVC)</title>
    
    <script type="text/javascript">
    
    $(document).ready(function() {
    	$("#btnJsonTestMap").on("click",function(e){
    		e.preventDefault(); //기본 이벤트 막기 
    		$.ajax('/json/testData.json',{
    			method : "POST",
    			dataType : "json", // type of response data
    			data : {
    				key : "key name",
    				title : "홍길동~~~말짜~~~"
    				},
    				success:function(data,status,xhr){ // success callback function
    				console.log(data);
    				//alert(data);
    				//alert(JSON.stringify(data));
    				//map or VO 객체...
    				//alert(data.title);
    				
    				//map 객체
    				/*$.each(data,function(key, value){
    					console.log(value);
    					var rs="";
    					 rs += '<tr>';
    					rs += ' <th> ' + data.name + '  </th>';
    					rs += ' <th> ' + data.title + '</th>';
    					rs += '</tr>';
    					 */
    					 
    					//List객체
    					$.each(data.info,function(idx, item){
    						var rs="";	
    						rs += '<tr>';
    	    				rs += ' <th> ' + idx + '  </th>';
    	    				rs += ' <th> ' + JSON.stringify(item) + '</th>';
    	    				rs += ' <th> ' + item.tel1 + '</th>';
    	    				rs += ' <th> ' + item.email + 'error exception' + '</th>';
    	    				rs += '</tr>';
    					
    					$("#testDisplay").append(rs);
    				});
    				
    				/* $.each(data,function(key, value){
    					console.log(value);
    					var rs="";
    					rs += '<tr>';
    					rs += ' <th> ' + key + '  </th>';
    					rs += ' <th> ' + value + '</th>';
    					rs += '</tr>';
    					
    					$("#testDisplay").append(rs);
    				});
    */
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
  <button id="btnJsonTestMap">  map test </button>
  		<table class="table">
  			<tbody id="testDisplay">
  				
  			</tbody>
  		</table>
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  </body>
</html>