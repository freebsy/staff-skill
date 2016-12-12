<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Dao.*" %>
<%@page import="Dto.*" %>
<%@page import="controller.*" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>:::STAFF정보 등록 화면:::</title>
</head>
<body>
	<h3>:::STAFF정보 등록 화면:::</h3>
	<form name="staffinsert" action="<c:url value='/staff/staffinsert'/>" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text"/>
				</tr>
				<tr>
				<td>주민등록번호</td>
				<td> <input type="text" name="sn1" id="sn1" size="4"/> 
				- <input type="password" name="sn2" id="sn2" size="4"/>
				</td>
				<td>종교</td>
				<td>
					<select name="rgno">
						<c:forEach items="${rgList}" var="r">
						<option value="${r.no}">${r.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>	
				<tr>
					<td>학력</td>
					<td>
						<c:forEach items="${shList}" var="s">
						<input type="radio" class="school"name="school" id="schoolNo" value="${s.no}">${s.graduate}
						</c:forEach>
					</td>
					<td>기술</td>
					<td colspan="3">
					<c:forEach items="${skList}" var="sk">
				<input type="checkbox" class="skill" name="skill" value="${sk.no}">${sk.name}
				</c:forEach>				
					</td>
				</tr>
			
				<tr>
					<td>졸업일</td>
					<td colspan="5">
					<input type="Date" name="graduateDay" id="graduateDay">
					</td>
				</tr>	
			<tr>
				<td>
				<td colspan="6" align="center">
				<input type="submit" value="확인">
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>