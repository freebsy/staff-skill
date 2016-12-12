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
<title>Insert title here</title>
</head>
<body>
<h3>STAFF���� ��ȸȭ��</h3>
<form name="add" action="<c:url value='/StaffSearch'/>" method="post" onSubmit="return check_form()">
<table border="1">
    <tr>
        <td>�̸�</td>
        <td><input type="text" id="name" name="name"/></td>
        <td>����</td>
        <td>
        <input type="checkbox" class="gender" name="gender" value="male"/>��
        <input type="checkbox" class="gender" name="gender" value="female"/>��
        </td>
        <td>����</td>
        <td>
            <select name="religionNum">
            <option>--��������---</option>
            <c:forEach items="${rgList}" var="r">
            <option value="${r.no}">${r.name}</option>
            </c:forEach>
            </select>
        </td>
    </tr>
    
    <tr>
        <td>�з�</td>
        <td>
            <c:forEach items="${shList}" var="s">
            <input type="checkbox" class="school" id="schoolNum" name="schoolNum" value="${s.no}">${s.graduate}
            </c:forEach>
        </td>
        <td>���</td>
        <td colspan="3">
        <c:forEach items="${skList}" var="sk">
        <input type="checkbox" class="skill" id="skillNum" name="skillNum" value="${sk.no}">${sk.name}
        </c:forEach>
        </td>
    </tr>
    
    <tr>
        <td>������</td>
        <td colspan="5">
        <input type="Date" id="graduateDay" name="graduateDay1"> ~ 
        <input type="Date" id="graduateDay" name="graduateDay2">
        </td>
    </tr>
    
    <tr>
        <td colspan="6" align="center">
        <input type="submit" value="���">
        <input type="reset" value="�ʱ�ȭ">
        </td>
    </tr>
</table>
</form>
</body>
</html>