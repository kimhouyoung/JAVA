<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<title>글 상세</title>
</head>

<body>
	<div align="center" style="margin: auto auto">
		<h3>글 상세</h3>
		<h3>님 로그인 환영합니다...... 
			Log-out
		</h3>
		<hr>
		<form action="GetBoardListCtrl" method="post">
			<input name="seq" type="hidden" value=""/>
			<table class="table" style="width: 800px">
				<tr>
					<td>제목</td>
					<td align="left">
						<input name="title" type="text" value="" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정" class="btn btn-primary"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="">글삭제</a>&nbsp;&nbsp;&nbsp; 
		<a href="">글목록</a>
	</div>
</body>
</html>










