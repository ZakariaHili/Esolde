<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>


</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
       <jsp:include page="header.jsp" />
       <!-- Navigation -->

        <div id="page-wrapper">
           
            
            <div class="row">
                <div class="col-lg-8 col-sm-offset-2">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            Ajouter une Magasin
                        </div>
                        <!-- /.panel-heading -->
                        <div class="">
                          
                          
                       <div class="container">
		<div class="col-sm-12 col-md-pull-1">

			<f:form class="form-horizontal" role="form" action="SaveMagasin"
				enctype="multipart/form-data">
				<div class="col-sm-offset-3 ">
					
				</div>

				

				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Slogan:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text" name="Slogan"
							placeholder="Slogan">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Frome juridique:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text"
							name="Frome_juridique" placeholder="Frome juridique">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Chiffre d'affaire:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text"
							name="Chiffre_affaire" placeholder="en DH">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Date creation:</label>
					<div class="input-group col-md-3">
						<input type="date" class="form-control" id="date"
							name="Date_creation" placeholder="Date_creation">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Direction:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text"
							name="Direction" placeholder="Direction">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Logo</label> <input
						type="file" name="file" class="input-group col-md-3">
				</div>



				<div class="form-group">
					<div class="col-sm-offset-3 ">
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
