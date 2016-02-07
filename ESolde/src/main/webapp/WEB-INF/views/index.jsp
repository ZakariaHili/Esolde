<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html lang="fr">
<head>
<%@include file="head.html"%>
</head>
<!--/head -->

<body>
	<jsp:include page="header.jsp" />



	<section id="slider"><!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#slider-carousel" data-slide-to="1"></li>
						<li data-target="#slider-carousel" data-slide-to="2"></li>
					</ol>

					<div class="carousel-inner">
						<div class="item active">
							<div class="col-sm-6">
								<h1>
									<span>E</span>-Solde <span>M</span>aroc
								</h1>
								<h2>Économisez sur vos achats!!</h2>
								<p>E-Solde Maroc propose des solutions dans de nombreux domaines pour dépenser moins et mieux.</p>
								<button type="button" class="btn btn-default get">Get
									it now</button>
							</div>
							<div class="col-sm-6">
								<img src="<c:url value='/resources/images/home/gale2.jpg' />"
									class="girl img-responsive" alt="" />
							</div>
						</div>
						<div class="item">
							<div class="col-sm-6">
								<h1>
									<span>E</span>-Solde Maroc
								</h1>
								<h2>Plateforme promotionnelle</h2>
								<p>Suivi en temps réel grace aux notifications.</p>
								<button type="button" class="btn btn-default get">Get
									it now</button>
							</div>
							<div class="col-sm-6">
								<img src="<c:url value='/resources/images/home/girl2.jpg' />"
									class="girl img-responsive" alt="" /> <img
									src="<c:url value='/resources/images/home/pricing.png' />"
									class="pricing" alt="" />
							</div>
						</div>

						<div class="item">
							<div class="col-sm-6">
								<h1>
									<span>E</span>-Solde Maroc
								</h1>
								<h2>Abonnement Gratuit</h2>
								<p>Abonnez-vous à notre newsletter pour bénéficier de nos meilleures offres.</p>
								<button type="button" class="btn btn-default get">Get
									it now</button>
							</div>
							<div class="col-sm-6">
								<img src="<c:url value='/resources/images/home/gal3.jpg' />"
									class="girl img-responsive" alt="" /> 
							</div>
						</div>

					</div>

					<a href="#slider-carousel" class="left control-carousel hidden-xs"
						data-slide="prev"> <i class="fa fa-angle-left"></i>
					</a> <a href="#slider-carousel"
						class="right control-carousel hidden-xs" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>

			</div>
		</div>
	</div>
	</section>
	<!--/slider-->

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">
					<h2>Categories</h2>
					<div class="panel-group category-products" id="accordian">
						<!--category-productsr-->
						<div class="panel panel-default">
						<c:forEach items="${categories}" var="cat" varStatus="status"
							begin="0" end="5">
						
						<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian"
										href="#c${cat.getId_categorie()}"> <span class="badge pull-right"><i
											class="fa fa-plus"></i></span> ${cat.getDescription_categorie()}
									</a>
								</h4>
							</div>
						
							<div id="c${cat.getId_categorie()}" class="panel-collapse collapse">
								<div class="panel-body">
									<ul>
									<c:forEach  items="${cat.produits }" varStatus="prod" begin="0" end="15">
									<li><a href="#">${cat.produits.get(prod.getIndex()).getMarque() } </a></li>
									</c:forEach>
										
									</ul>
								</div>
							</div>
							</c:forEach>
						</div>
						
						
						
						
						
					</div>
					<!--/category-products-->

					
					<!--/brands_products-->

					
					<!--/price-range

				<div class="shipping text-center">
						<!--shipping-
						<img src="<c:url value='/resources/images/home/shipping.jpg' />"
							alt="" />
					</div>
					/shipping-->

				</div>
			</div>

			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Produits</h2>
					<c:forEach items="${produits}" var="prod" varStatus="status"
						begin="0" end="5"> &nbsp;
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">

									<div class="productinfo text-center">
										<img src="photoProd?idProdt=${prod.produits.getId_Produit()}"
											alt="" />
										<h2>${prod.getPrix_Solde()}DH</h2>
										<p>${prod.produits.getMarque()}</p>
										<a href="ProductDetails?idProd=${prod.getId_Promotion()}" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Détails</a>
									</div>

									<div class="product-overlay">
										<div class="overlay-content">
											<h2>${prod.getPrix_Solde()}DH</h2>
											<p>${prod.produits.getDescription()}</p>
											<a href="ProductDetails?idProd=${prod.getId_Promotion()}" class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Détails</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										
										<li><a href="#"><i class="fa fa-plus-square"></i>Ajouter Pour comparer</a></li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>


				</div>
				<!--features_items-->


				<!--category-tab-->
				<div class="category-tab">
					<div class="col-sm-12">
						<ul class="nav nav-tabs">

							<c:forEach items="${categories}" var="prod" varStatus="status"
								begin="0" end="5">
								<c:choose>
									<c:when test="${status.getIndex() == 0}">
										<li class="active"><a href="#${prod.getId_categorie()}"
											data-toggle="tab"> ${prod.getDescription_categorie()}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="#${prod.getId_categorie()}"
											data-toggle="tab">${prod.getDescription_categorie()}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>

					</div>


					<div class="tab-content">
						<c:forEach items="${categories}" var="cat" varStatus="status"
							begin="0" end="4">
							<c:choose>
								<c:when test="${status.getIndex() == 0}">

									<div class="tab-pane fade active in"
										id="${cat.getId_categorie()}">
								</c:when>
								<c:otherwise>
									<div class="tab-pane fade " id="${cat.getId_categorie()}">
								</c:otherwise>
							</c:choose>
							
							<c:forEach items="${promotion}" var="prom">
								<c:choose>
									<c:when
										test="${cat.getId_categorie()==prom.produits.categorie.getId_categorie()}">
										
										<div class="col-sm-3">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<img
															src="photoProd?idProdt=${prom.produits.getId_Produit()}"
															alt="" />
														<h2>${prom.getPrix_Solde()}DH</h2>
														<p>${prom.produits.getMarque()}</p>
														<a href="ProductDetails?idProd=${prom.getId_Promotion()}" class="btn btn-default add-to-cart"><i
															class="fa fa-shopping-cart"></i>Détails</a>
													</div>

												</div>
											</div>
										</div>
									</c:when>

								</c:choose>

							</c:forEach>
							</div>
							</c:forEach>
					</div>

					
				</div>
			
			<!--/category-tab-->

			<div class="recommended_items">
				<!--recommended_items-->
				<h2 class="title text-center">Produits Recommandés</h2>

				<div id="recommended-item-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<c:forEach items="${bas_prix}" var="prom" varStatus="status"
							begin="0" end="5" step="1">
							
					<c:choose>
					<c:when test="${status.getIndex() ==0}">
					<div class="item active">
					</c:when>
					<c:when test="${status.getIndex()== 3}">
					</div><div class="item">
					</c:when>
					</c:choose>
								
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img
														src="photoProd?idProdt=${prom.produits.getId_Produit()}"
														alt="" />
													<h2>${prom.getPrix_Solde()}DH</h2>
													<p>${prom.produits.getMarque()}</p>
													<a href="ProductDetails?idProd=${prom.getId_Promotion()}" class="btn btn-default add-to-cart"><i
														class="fa fa-shopping-cart"></i>Détails</a>
												</div>

											</div>
										</div>
									</div>
								
							

						</c:forEach>
</div>

					</div>
					<a class="left recommended-item-control"
						href="#recommended-item-carousel" data-slide="prev"> <i
						class="fa fa-angle-left"></i>
					</a> <a class="right recommended-item-control"
						href="#recommended-item-carousel" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>
			</div>
			<!--/recommended_items-->

		</div>
	</div>
	
	</section>

	<!-- footer -->

	<%@include file="footer.html"%>
</body>
</html>
</html>