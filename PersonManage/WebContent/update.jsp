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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>모든 리스트 보기</title>
<script type="text/javascript">
function goInsert(){
	window.location.href = "./insert.jsp";
}
function deleteRow(no){
	var url = "./delete";
	var param = "num="+no;
	
	$.ajax({
		type	: "POST",
		url		: url,
		data	: param,
		success : function(response, textStatus, jqXHR){
			var resultJson = JSON.parse(response);
			console.log(resultJson);
			
			if(resultJson.result == '1'){
				console.log("delete ok");
				window.location.reload();
			}else{
				console.log("delete ok");
			}
		}
	});
}
</script>
</head>
<body>

<table border="1">
	<tr>
		<th>no</th>
		<th>번호</th>
		<th>이름</th>
		<th>생년월일</th>
		<th>주소</th>
		<th>우편번호</th>
		<th>전화번호</th>
		
	</tr>
	<%for(int i=0; i<list.size(); i++){
		Person person = list.get(i);%>
	<tr>
		<th><%=i%></th>
		<th><input type="number" name="num" value="<%=person.getNo() %>"/></th>
		<th><input type="text" name="num" value="<%=person.getName() %>"/></th>
		<th><input type="text" name="num" value="<%=person.getBirth() %>"/></th>
		<th><input type="text" name="num" value="<%=person.getAddress()%>"/></th>
		<th><input type="number" name="num" value="<%=person.getPostCode()%>"/></th>
		<th><input type="text" name="num" value="<%=person.getPhone()%>"/></th>
	</tr>
	<%} %>
</table>

<input type="button" value="새로입력" onclick="javascript:goInsert();"/>
</body>
</html>