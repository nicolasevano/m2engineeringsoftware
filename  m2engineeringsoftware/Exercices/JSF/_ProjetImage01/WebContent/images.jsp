<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>projet image 01</title>
<style type="text/css">
      .général {background-color: black; color: yellow; }
      body {font-family: verdana, Arial; background-color: yellow; color: blue; }
</style> 
</head>
<body>
	<f:view>
		<h:form>
			<h4>
				Fichier image :
				<h:inputText value="#{traitement.nomFichier}" size="50" />
			</h4>
			<h:panelGrid columns="2" cellpadding="3" styleClass="général"
				rendered="#{traitement.présente}">
				<h:graphicImage url="LireImage" />
				<h:graphicImage url="Histogramme" />
				<h:outputText
					value="Taille originale : #{traitement.largeur} x #{traitement.hauteur}" />
			</h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>