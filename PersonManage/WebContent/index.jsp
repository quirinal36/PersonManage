<%@page import="java.util.List"%>
<%@page import="www.person.manager.Person"%>
<%@page import="www.person.manager.db.DButil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
DButil dbUtil = new DButil();
List<Person> list = dbUtil.getPeople();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>모든 리스트 보기</title>
<script type="text/javascript">
function goInsert(){
	window.location.href = "./insert.jsp";
}
</script>
</head>
<body>

<table border="1">
	<tr>
		<th>no</th><th>번호</th><th>이름</th><th>생년월일</th>
	</tr>
	<%for(int i=0; i<list.size(); i++){
		Person person = list.get(i);%>
	<tr>
		<th><%=i%></th>
		<th><%=person.getNo() %></th>
		<th><%=person.getName() %></th>
		<th><%=person.getBirth() %></th>
	</tr>
	<%} %>
</table>

<input type="button" value="새로입력" onclick="javascript:goInsert();"/>
</body>
</html>