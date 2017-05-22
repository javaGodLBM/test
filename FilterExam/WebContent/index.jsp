<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>AServlet호출</h1>
<form action="/FilterExam/a" method="post">
주소 : <input type="text" name="address"> <input type="submit" value="AServlet호출">
</form>

<h1>BServlet호출</h1>
<form action="/FilterExam/b" method="post">
주소 : <input type="text" name="address"> <input type="submit" value="BServlet호출">
</form>

<h1>CServlet호출</h1>
<form action="/FilterExam/c" method="post">
주소 : <input type="text" name="address"> <input type="submit" value="CServlet호출">
</form>
</body>
</html>