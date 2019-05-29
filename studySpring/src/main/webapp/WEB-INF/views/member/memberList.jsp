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

    <title> 회원 관리 (리스트) ${userTitle}</title>
    <script type="text/javascript" defer="defer">
    $(document).ready(function(){
    	$frm = $('#searchVo');
    	//서브밋 버튼 클릭시
    	$('button[type=submit]', $frm).click(function(e){
    		e.preventDefault();//이벤트 전파 막기
    		//검색 버튼이 클릭이 되면,, 1페이지 부터 보이도록 설정 
    		$('input[name=curPage]',$frm).val(1);
    		 $frm.submit(); 
    });
    	
    	//class="goPage" Id버튼 클릭시 
    	$(".goPage").click(function () {
			/* alert($(this).data("curpage")); */
			var title = $(this).data("title");
			/* alert(title); */
			//data-curpage="${i}"
			var curPage = $(this).data("curpage");
			$('input[name=curPage]').val(curPage);
			$frm.submit();
		});
    });
    
    
    </script>
  </head>

  <body>

	<form id="searchVo" action="" method="get">
		 <input type="hidden" name="curPage" value="${searchVo.curPage}">
		
		<table class="table">
			<tr>
			<th>검색조건</th>
			<th>
				<select name="searchType">
					<option value="usr_id"${param.searchType  eq 'usr_id'? 'selected="selected"' : '' }>아이디</option>
					<option value="usr_name" ${param.searchType  eq 'usr_name'? 'selected="selected"' : '' }>이름</option>
					<option value="usr_email" ${param.searchType  eq 'usr_email'? 'selected="selected"' : '' }>이메일</option>
				</select>
			</th>
				<th>검색어</th>
				<th><input type="text" name="searchText"></th>
				<th>	
					<button type="submit">검색</button>
				</th>
			</tr>
		</table>
	</form>

  		<table class="table">
  			<tbody >
  			<tr>
  			
  				<th>순번</th>
  				<th>아이디</th>
  				<th>이름</th>
  				<th>이메일</th>
  				<th>핸드폰</th>
  				<th>아이피</th>
  				<th>작성일자</th>
  			</tr>
  				<c:forEach var="memberVo" items="${memberList }" >
  				<c:url var="viewUrl" value="/member/memberView.do">
  					<c:param name="seqNo" value="${memberVo.seqNo }"/>
  				
  				</c:url>
  				<tr>
  				<td>${memberVo.num }</td>
	  				<td>
	  					<a href="${viewUrl}">${memberVo.usrId}</a>
	  				</td>
	  				
	  				<td>
	  					<a href="${viewUrl}">${memberVo.usrName}</a>
	  				</td>
	  				<td>${memberVo.usrEmail}</td>
	  				<td>${memberVo.usrHp}</td>
	  				<td>${memberVo.usrIp}</td>
	  				<td>${memberVo.regDt}</td>
	  			</tr>
	  			</c:forEach>
  			</tbody>
  		</table>
  		<nav>
  			<ul class="pagination pagination-lg">
  			<!-- 이전 버튼 -->
  			<c:choose>
  				<c:when test="${searchVo.startPage eq 1}">
  					<li>
  						<a aria-label="Previous" class="page-link">
  							<span aria-hidden="true"> << 이전</span>
  						</a>
  					</li>
  				</c:when>
  			
  				<c:otherwise>
  				<li>
  					<a href="#" data-curpage="${searchVo.startPage -1}" class="prev goPage page-link" aria-label="Previous">
  						<span aria-hidden="true"> << 이전</span>
  					</a>
  				</li>
  				</c:otherwise>
  			</c:choose>
  		
  			<c:forEach var="i" begin="${searchVo.startPage}" end="${searchVo.endPage}">
  				<c:choose>
  					<c:when test="${i eq searchVo.curPage}">
  						<li class="active"> <a class="page-link">${i}</a></li>
  					</c:when>
  					<c:otherwise>
  						<li>
  							<a href="#" data-curpage="${i}" data-title="말짜=${i}" class="page-link goPage">${i}</a>
  						</li>
  					</c:otherwise>
  				</c:choose>
  			
  			</c:forEach>
  		
  		
  		<!-- 다음 버튼 -->
  		
  		<c:choose>
  			<c:when test="${searchVo.endPage < searchVo.totalPageCount}">
  						<li>
  							<a href="#" data-curpage="${searchVo.endPage}" class="page-link next goPage"
  							aria-label="Next" title="Next">
  							<span aria-hidden="true">다음 >></span>
  							</a>
  						</li>
  						</c:when>
  				<c:otherwise>
  				<li>
  						<a 
  							aria-label="Next" title="Next" class="page-link">
  							<span aria-hidden="true">다음 >></span>
  							</a>
  						</li>
  				</c:otherwise>
  		</c:choose>
  		</ul>
  		</nav>
  </body>
</html>