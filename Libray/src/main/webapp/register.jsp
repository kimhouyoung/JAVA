<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/common.css">
<body>
	<header>
		<h3 class="txt">쇼핑몰 회원관리 ver 1.0</h3>
		<nav><%@include file="nav.jsp"%></nav>
	</header>
	<section>
		<br> <br> <br>
		<div align="center">
			<h2>대여도서 등록</h2>
			<br>
			<form name="form" action="RegisterCtrl" method="post"
				onsubmit="return validate();">
				<input type="hidden" name="action" value="member" />
				<table>
					<tr>
						<th>대여일자</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>대여번호(자동채번)</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>도서코드</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>고객번호</th>
						<td><input type="text"></td>
					</tr>
					<tr>
						<th>반납기한(대여일 7일후)</th>
						<td><input type="text"></td>
					</tr>
						<th colspan=2><input type="submit" value="등록"><input
							type="button" onclick="location.href='GetMember'" value="조회" /></th>
				</table>
			</form>
		</div>
	</section>
	<footer>
		<%@include file="footer.jsp"%>
	</footer>
</body>
</html>