<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.html"%>

</head>

<body>

	<%@include file="header.jsp"%>

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
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="<c:url value='photoProd?idProdt=${prod.produits.getId_Produit()}' />" alt="" />
								<h3>ZOOM</h3>
							</div>
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								
								  <!-- Wrapper for slides -->
								    <div class="carousel-inner">
										<div class="item active">
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar1.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar2.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar3.jpg' />" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar1.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar2.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar3.jpg' />" alt=""></a>
										</div>
										<div class="item">
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar1.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar2.jpg' />" alt=""></a>
										  <a href=""><img src="<c:url value='/resources/images/product-details/similar3.jpg' />" alt=""></a>
										</div>
										
									</div>

								  <!-- Controls -->
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="<c:url value='/resources/images/product-details/new.jpg' />" class="newarrival" alt="" />
							
								<h2>${prod.produits.getMarque() }</h2>
								<p>${prod.produits.getDescription() }</p>
								<img src="<c:url value='/resources/images/product-details/rating.png' />" alt="" />
								<span>
									<span>${ prod.getPrix_Solde()}DH</span>
									
								</span>
								<p><b>Prix Original:</b> ${ prod.getPrix_original()}DH</p>
								<p><b>Magasin:</b> ${prod.representant_magasin.filiale.get(0).magasin.getSlogan()} </p>
								<fmt:parseDate pattern="yyyy-MM-dd" value="${prod.getDate_Fin_Promotion()}" var="parsedDateD" />
												<fmt:formatDate value="${parsedDateD}" pattern="yyyy-MM-dd" var="DateD"/>
											<tr class="odd gradeX">
								
								<p><b>Date de fin de la promotion:</b> ${DateD}</p>
								
								<a href=""><img src="<c:url value='/resources/images/product-details/share.png' />" class="share img-responsive"  alt="" /></a>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								
								<li class="active"><a href="#Commentaires" data-toggle="tab">Commentaires (${count})</a></li>
							</ul>
						</div>
						<div class="tab-content">
							
							
							
							
							<div class="tab-pane fade active in" id="reviews" >
							
								<div class="col-sm-12">
								
									
								
								<c:forEach items="${commentaires}" var="comment">
								
								<fmt:parseDate pattern="yyyy-MM-dd HH:mm" value="${comment.getDate_commentaire()}" var="parsedDateFin" />
												<fmt:formatDate value="${parsedDateFin}" pattern="HH:mm" var="hour"/>
												
												<fmt:formatDate value="${parsedDateD}" pattern="yyyy-MM-dd" var="day"/>
									<ul>
										<li><a href=""><i class="fa fa-user"></i>${comment.utilisateur.getLogin() }</a></li>
										<li><a href=""><i class="fa fa-clock-o">${hour }</i></a></li>
										<li><a href=""><i class="fa fa-calendar-o"></i>${day }</a></li>
									</ul>
									
									<p>${comment.getBody_Commentaire()}</p>
									<hr class="divider">
									</c:forEach>
									
									<sec:authorize access="isAuthenticated()">
									<p><b>écrire un commentaire</b></p>
									
									<f:form action="saveComment" >
										<input type="hidden" name="idprod" value="${idProd}">
										<textarea name="Body_Commentaire" ></textarea>
										<b>Rating: </b> <img src="<c:url value='/resources/images/product-details/rating.png' />" alt="" />
										<input type="submit" value="Envoyer" type="button" class="btn btn-default pull-right" >
										
									</f:form>
									</sec:authorize>
								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					</div></div></div></section>
	<%@include file="footer.html"%>				
</body>
</html>