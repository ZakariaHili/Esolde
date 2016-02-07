<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>
<script language="javascript" type="text/javascript">
	// And in the list.js file
	function fillCategory() {
		// this function is used to fill the category list on load
		
		<c:forEach var="item" items="${categories}">	
		addOption(document.drop_list.Category, "${item.getId_categorie()}", "${item.getDescription_categorie()}", "");
		</c:forEach>
	}
	

	
	function SelectSubCat() {
		// ON selection of category this function will work
		removeAllOptions(document.drop_list.SubCat);
	
		
		
		if (document.drop_list.Category.value != ''){
			<c:forEach var="item" items="${produits}">	
			if(${item.categorie.getId_categorie()}==document.drop_list.Category.value)
			
				addOption(document.drop_list.SubCat, "${item.getId_Produit()}", "${item.getMarque()}");
			
			</c:forEach>
		
		}
	
	}
	
	/////////////////////////
	function removeAllOptions(selectbox) {
		var i;
		for (i = selectbox.options.length - 1; i >= 0; i--) {
			// selectbox.options.remove(i);
			selectbox.remove(i);
		}
	}
	function addOption(selectbox, value, text) {
		var optn = document.createElement("OPTION");
		optn.text = text;
		optn.value = value;
		selectbox.options.add(optn);
	}
</script>


</head>

<body bgcolor="#ffffff" text="#000000" link="#0000ff" vlink="#800080"
	alink="#ff0000" onload="fillCategory();">

    <div id="wrapper">

        <!-- Navigation -->
       <jsp:include page="header.jsp" />
       <!-- Navigation -->

        <div id="page-wrapper">
           
            
            <div class="row">
                <div class="col-lg-8 col-sm-offset-2">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            Ajouter Promotion
                        </div>
                        <!-- /.panel-heading -->
                        <div class="">
                          
                          
                       <div class="container">
		<div class="col-sm-12 col-md-pull-1">
			<f:form name="drop_list" role="form" action="SavePromotion"
				method="POST" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Categorie:</label>
					<div class="input-group col-md-3">
						<SELECT NAME="Category"
							class="form-control"
							data-live-search="true" onChange="javascript:SelectSubCat();">

							
						</SELECT>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Marque:</label>
					<div class="input-group col-md-3">
						<SELECT NAME="SubCat" class=" form-control"
							data-live-search="true" onChange="javascript:SelectSub2Cat();">
							
						</SELECT>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Debut Promotion:</label>
					<div class="input-group col-md-3">
						<input type="date" class="form-control" id="text"
							name="Date_debut_promotion">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Fin Promotion:</label>
					<div class="input-group col-md-3">
						<input type="date" class="form-control" id="text"
							name="Date_Fin_Promotion" >
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Prix Original:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text"
							name="Prix_original" placeholder="250">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Prix Solde:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text"
							name="Prix_Solde" placeholder="150">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 ">
						<button type="submit" class="btn btn-default">Enregistrer</button>
					</div>
				</div>
			</f:form>
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
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="footer.jsp"%>
</body>
</html>
