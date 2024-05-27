<%@page import="com.example.demo.domain.Member"%>
<%@page import="com.example.demo.domain.MemberRepository" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 자바 코드를 사용 -->
<%
	MemberRepository repository = new MemberRepository();
	
	String username = request.getParameter("username");
	String password = request.getParameter("password"); // 파라미터
	
	Member member = Member.builder().userId(username).password(password).build(); // 회원생성
	
	Member newMember = repository.save(member); // 저장소에 추가
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= newMember.getNo() %> 번째 <%= newMember.getUserId() %> 회원을 추가 했습니다!
</body>
</html>