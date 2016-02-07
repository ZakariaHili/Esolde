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
<div class="container"><div class="col-sm-4 col-sm-offset-4">
	<f:form class="form-horizontal" role="form" action="registerRepresentant" enctype="multipart/form-data">
	<div class="form-group">
			<label class="control-label col-sm-2" for="text">Categorie:</label>
	<select name="categorie">
          <c:forEach  items="${categories}" var="item">
            <option value="${item.getId_categorie()}">${item.getDescription_categorie()}</option>
          </c:forEach>
        </select></div>
	<div class="form-group">
			<label class="control-label col-sm-2" for="text">Marque:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="text" name="Marque"
					placeholder="Votre Nom">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="text">Description:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="text" name="Description"
					placeholder="Votre Prenom">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="text">Image</label>
			<input type="file" name="Image" class="file"> 
		</div>
	
			<div class="form-group">
			<label class="control-label col-sm-2" for="text">Filiale</label>
				<select name="filiale" class="selectpicker">
					<c:forEach var="item" items="${filiale}">
						<option value="${item.getId_Filiale()}">${item.getNom_Filiale()}</option>
					</c:forEach>
				</select>
			</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="text">Login:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="text" name="Login"
					placeholder="Login">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="Email"
					placeholder="Enter email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwd" name="Password"
					placeholder="Enter password">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Enregistrer</button>
			</div>
		</div>
	</f:form>
	</div></div>
	
</body>
<%@include file="footer.html"%>
</html>