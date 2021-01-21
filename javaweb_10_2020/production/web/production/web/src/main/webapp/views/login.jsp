<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" http-equiv="Content-Type"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, text/html">
<title>Login</title>

</head>
<body>
	<h1 style="color: #808080">
		FOLLOW <strong style="color: #f896f8">Thủy Heo</strong> ON SOCIAL
		MEDIA
	</h1>
	<div class="container justify-content-center">
		<div class="Login-box justify-content-center">
			<div class="row">
				<div class="col-md-6 login-right">
					<h2 style="color: black">Login</h2>
					<c:if test="${not empty message }">
						<div class="alert alert-${alert} ">
							<p class="justify-content-center">${message}</p>
						</div>
					</c:if>

<!-- <script>
	function myFunction() {
		alert("alo");
	}
</script> -->

					<form type="submit" method="post" action="<c:url value='/login'/>">
						<div class="form-group">
							<label style="color: black">Username</label> <input type="text"
								name="userName" value="" placeholder="Username"
								class="form-control">
						</div>

						<div class="form-group">
							<label style="color: black">Password</label> <input
								type="password" name="passWord" value="" placeholder="Password"
								class="form-control">
						</div>

						<div class="form-group">
							<input type="checkbox" name="remember"> <label
								style="color: black">Remember me</label>
						</div>

						<!-- <input type="hidden" value="" id="page" name="page" /> -->
						<div>
							<input type="submit" name="submit" value="login" />
							<button>
								<a href='<c:url value="/register"/>'>Register</a>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="social-media">
		<a href="#"><i class="fab fa-facebook"></i></a> <a href="#"><i
			class="fab fa-twitter"></i></a> <a href="#"><i
			class="fab fa-whatsapp"></i></a> <a href="#"><i
			class="fab fa-instagram"></i></a> <a href="#"><i
			class="fab fa-youtube"></i></a>
	</div>
</body>
</html>