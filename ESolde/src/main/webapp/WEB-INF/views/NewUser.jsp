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
	  
            <div class="row">
                <div class="col-lg-8 col-sm-offset-2">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            Nouveau Utilisateur
                        </div>
                        <!-- /.panel-heading -->
                        <div class="">
	<div class="container">
		<div class="col-sm-12  col-md-pull-0">
			<f:form class="form-horizontal" role="form" action="registerUser">
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Nom:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text" name="Nom"
							placeholder="Votre Nom">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Prenom:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text" name="Prenom"
							placeholder="Votre Prenom">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Date de
						Naissance:</label>
					<div class="input-group col-md-3">
						<input type="date" class="form-control" id="text" name="Date"
							placeholder="1992/06/12">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="text">Login:</label>
					<div class="input-group col-md-3">
						<input type="text" class="form-control" id="text" name="Login"
							placeholder="Login">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="email">Email:</label>
					<div class="input-group col-md-3">
						<input type="email" class="form-control" id="email" name="Email"
							placeholder="Enter email">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="pwd">Password:</label>
					<div class="input-group col-md-3">
						<input type="password" class="form-control" id="pwd"
							name="Password" placeholder="Enter password">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-5">
						<button type="submit" class="btn btn-default">Enregistrer</button>
					</div>
				</div>
			</f:form>
		</div>
	</div></div></div></div></div>
</body>
<%@include file="footer.html"%>
</html>