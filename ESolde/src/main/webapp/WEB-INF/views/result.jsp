<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.html"%>
</head>
<!--/head -->

<body>
	<jsp:include page="header.jsp" />
	<div class="features_items">
		<!--features_items-->
		<h2 class="title text-center">Résultats</h2>
		<c:forEach items="${produits}" var="prod" varStatus="status" begin="0"
			end="5">
			<div class="col-sm-4">
				<div class="product-image-wrapper">
					<div class="single-products">

						<div class="productinfo text-center">
							<img src="photoProd?idProdt=${prod.produits.getId_Produit()}"
								alt="" />
							<h2>${prod.getPrix_Solde()}DH</h2>
							<p>${prod.produits.getMarque()}</p>
							<a href="ProductDetails?idProd=${prod.getId_Promotion()}"
								class="btn btn-default add-to-cart"><i
								class="fa fa-shopping-cart"></i>Détails</a>
						</div>

						<div class="product-overlay">
							<div class="overlay-content">
								<h2>${prod.getPrix_Solde()}DH</h2>
								<p>${prod.produits.getDescription()}</p>
								<a href="ProductDetails?idProd=${prod.getId_Promotion()}"
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Détails</a>
							</div>
						</div>
					</div>
					<div class="choose">
						<ul class="nav nav-pills nav-justified">

							<li><a href="#"><i class="fa fa-plus-square"></i>Ajouter
									Pour comparer</a></li>
						</ul>
					</div>
				</div>
			</div>
		</c:forEach>


	</div>

	<%@include file="footer.html"%>
</body>
</html>