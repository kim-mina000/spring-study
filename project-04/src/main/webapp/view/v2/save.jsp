<!-- jstl 라이브러리 추가 (C 태그) java코드를 편하게 쓰려고 만든 라이브러리-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- C태그추가 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jstl: jsp 페이지에서 java 코드를 쉽게 작성할 수 있는 태그 라이브러리 -->
	<!-- 컨트롤러에서 전달받은 member 객체의 저보를 출력 -->
	<c:out value="${member.no }"/> 번째 <c:out value="${member.userId }" /> 회원을 추가했습니다!
	<!-- 컨트롤러에서 addAttribute로 보내준 member변수를 사용  -->
</body>
</html>