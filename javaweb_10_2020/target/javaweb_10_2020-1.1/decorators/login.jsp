<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><dec:title default="Login" /></title>

<meta name="viewport" http-equiv="Content-Type"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, text/html">
<!-- css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/template/login/login.css'/>" media="all" />
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
</head>
<body onload="welcome()" class="body">

	<!-- Page Content -->
		<dec:body />
	<!-- Page Content -->
 <script type="text/javascript" src="js.js"></script>
</body>
</html>