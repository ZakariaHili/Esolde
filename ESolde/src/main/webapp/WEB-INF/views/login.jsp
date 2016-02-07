<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<%@include file="head.html"%>
</head>

<body>

	<%@include file="header.jsp"%>


	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->

					<h2>Login to your account</h2>
					<c:if test="${not empty error}">
						<div ><p class="bg-danger">${error}</p></div>
					</c:if>
					<form action="j_spring_security_check" method="post">
						<input type="text" placeholder="Login" name="Login" /> <input
							type="Password" placeholder="Password" name="Password" /> <span>
							<input type="checkbox" class="checkbox"> Garder ma
							session ouverte
						</span> <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-default">Login</button>
					</form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">Ou</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>Creer un nouveau Compte</h2>
					<table>
						<tr>
							<td>
								<form action="NewUser">
									<button type="submit" class="btn btn-default">Nouveau
										Utilisateur</button>
								</form>
							</td>
							<td>
								<form action="NewRepresentant">
									<button type="submit" class="btn btn-default">Nouveau
										Représentant</button>
								</form>
							</td>
						<tr>
					</table>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
	<!--/form-->

</body>
<!-- footer -->

<%@include file="footer.html"%>



</html>