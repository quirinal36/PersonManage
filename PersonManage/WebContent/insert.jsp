<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새정보입력</title>

</head>
<body>
<form method="POST" action="./save">
	<table>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" size="15"/></td>
		</tr>
		<tr>
			<th>번호</th>
			<td><input type="text" name="num" size="15"/></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="birth" size="15"/></td>
		</tr>
		<tr>
			<th colspan="2">
			<input type="submit" value="저장"/>
			</th>
		</tr>
	</table>
</form>

</body>
</html>