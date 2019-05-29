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

<title>글 작성하기..(로그인 사용자만..)</title>

</head>

<body>
	<form action="/board/boardInsertProc.do" method="post" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th>게시판 종류</th>
					<td><select name="serviceType">
							<option value="FAQ">FAQ</option>
							<option value="NOTICE">NOTICE</option>
							<option value="DATA">DATA</option>

					</select></td>

				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>

				</tr>

				<tr>
					<th>내용</th>
					<td><textarea rows="20" cols="60" name="contents"></textarea>
					</td>
				</tr>
				
				<tr>
		  			<td rowspan="5">첨부파일</td>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		<tr>
		  			<td><input type="file" name="attachFiles"></td>
		  		</tr>
		  		</tr>
		  		
				<tr>
					<th colspan="2">
						<button type="submit">저장</button>
					</th>
				</tr>

			</tbody>

		</table>
	</form>

</body>
</html>