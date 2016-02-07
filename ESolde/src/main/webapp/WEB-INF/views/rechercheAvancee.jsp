<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<%@include file="head.html"%>

</head>

<body>

	<%@include file="header.jsp"%>

<div id="page-wrapper">
           
            
            <div class="row">
                <div class="col-lg-6 col-sm-offset-3">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            
                        </div>
                        <!-- /.panel-heading -->
                        <div class="">
                          
                          
                       <div class="container">
		<div class="col-sm-12 ">

		
	<div class="container">
		<f:form class="form-inline" role="form" action="RechercheAvancee">
			<div class="form-group">
				<label for="text">Produit</label> 
				<input name="produit" >
			</div>
			<button type="submit" class="btn btn-default">Chercher</button>
			<br /><br />
			<div class="form-group">
				<select id="basic" name="categorie"
							class="selectpicker show-tick form-control"
							data-live-search="true">
					<option value="0">"Toutes categorie"</option>
					<c:forEach items="${categories}" var="item">
						<option value="${item.getId_categorie()}">${item.getDescription_categorie()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<select id="basic" name="magasin"
							class="selectpicker show-tick form-control"
							data-live-search="true">
					<option value="0">"Tous les magasins"</option>
					<c:forEach var="item" items="${magasins}">
						<option value="${item.getId_Magasin()}">${item.getSlogan()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Prix max</label><input name="prix_min" />
			</div>

		</f:form>
	</div>
	
		</div>
	</div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                    <!-- /.panel -->
                   
                    <!-- /.panel -->
                </div>
                
            </div>
            <!-- /.row -->
        </div>
	

</body>
<!-- footer -->

<%@include file="footer.html"%>



</html>