<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +212 635
										405 251</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i>
										zakariahili@gmail.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="<c:url value='/index' />"><img
								src="
							<c:url value='/resources/images/home/logo.png' />"
								alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<!-- div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div-->

							<!--div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									< li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div-->
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
							
							
							<sec:authorize access="hasRole('ROLE_USER')">
								<li><a href="<c:url value="/Utilisateur/" />"><i class="fa fa-user"></i> Mon Compte</a></li>
								</sec:authorize>
							<sec:authorize access="hasRole('ROLE_REPRESENTANT')">
								<li><a href="<c:url value="/Representant/" />"><i class="fa fa-user"></i> Mon Compte</a></li>
								</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EQUIPE')">
								<li><a href="<c:url value="/Equipe/" />"><i class="fa fa-user"></i> Mon Compte</a></li>
								</sec:authorize>	
								
								
								
								<li><a href="#"><i class="fa fa-star"></i> Subscribe</a></li>
								<!-- li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li-->


								<sec:authorize access="!isAuthenticated()">
									<li><a href="login.html"><i class="fa fa-lock"></i>
											Authentification</a></li>
								</sec:authorize>
								<c:url value="/logout" var="logoutUrl" />
								<sec:authorize access="isAuthenticated()">
									<li><a href="<c:url value="/logout" />"><i class="fa fa-lock"></i> Se
											Déconnecter</a></li>
											
								</sec:authorize>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html" class="active">Accueil</a></li>
								
								
								<li><a href="contact-us.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-6">

						<f:form action="chercher" method="post" commandName="send">
							<div class="input-group">

								<span class="input-group-btn"> <input type="text"
									class="form-control" name="produit" placeholder="Produit">
									<button class="btn btn-default" type="submit" value="chercher">Chercher!</button>
								</span>
								<!-- /input-group -->
							</div>
						</f:form>
						<a href="rechercheAvancee">Recherche Avancée </a>

					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->
</body>
</html>