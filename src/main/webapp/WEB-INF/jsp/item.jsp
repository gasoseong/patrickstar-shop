<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<img src=${item.image}>
	<h3>상품명: ${item.name}</h3>
	<h3>카테고리: ${item.category}</h3>
	<h3>URL: ${item.url}</h3>
	<h3>판매가: ${item.price}</h3>
	<h3>제조국: ${item.origin}</h3>
</body>
</html>