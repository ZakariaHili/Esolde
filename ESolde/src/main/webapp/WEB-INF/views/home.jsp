<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<p>
		Hi
		<sec:authentication var="principal" property="principal" />
		
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" var="username" />
			
			<c:url value="/logout" var="logoutUrl" />

			<!-- csrt for log out-->
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h2>
					Welcome : ${pageContext.request.userPrincipal.name} | <a
						href="javascript:formSubmit()"> Logout</a>
				</h2>
			</c:if>

		</sec:authorize>

	</p>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
