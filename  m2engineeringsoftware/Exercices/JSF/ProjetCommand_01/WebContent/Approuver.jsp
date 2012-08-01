<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Command 01</title>
<style type="text/css">
   .un {background-color: #00CC00; }
   .deux {background-color: #009900; }
   .général {background-color: #006633; font-weight: bold; }
   .gras {font-weight: bold; }
   h2, h3 { background-color: #006633; padding: 5px; border : groove; }
   body {font-family: verdana, Arial; color: yellow; background-color: green; }
   .error {color: white;}
</style>
</head>
<body>
	<f:view>
		<h:form>
			<hr color="#FFFF00" />
			<h:panelGrid cellpadding="3" styleClass="général" columns="2"
				rowClasses="un, deux">
				<h:outputText value="Article :" />
				<h:outputText id="article" value="#{commande.article}" />
				<h:outputLabel value="Prix :" />
				<h:outputText id="prix" value="#{commande.prix}" />
				<h:outputLabel value="Quantité :" />
				<h:outputText id="quantite" value="#{commande.quantite}" />
				<h:outputLabel value="Adresse :" />
				<h:outputText id="addresse" value="#{commande.addresse}" />
				<h:outputLabel value="Code postal :" />
				<h:outputText id="zipCode" value="#{commande.zipCode}" />
				<h:outputLabel value="Ville :" />
				<h:outputText id="ville" value="#{commande.city}" />
				<h:outputLabel value="Adresse Mail :" />
				<h:outputText id="mail" value="#{commande.mail}" />
				<h:outputLabel value="Carte de credit :" />
				<h:outputText id="creditCart" value="#{commande.creditCart}" />
				<h:outputLabel value="Expiration (ex:02/2007) :" />
				<h:outputText id="expiration" value="#{commande.date}">
					<f:convertDateTime pattern="MM/yyyy" />
				</h:outputText>
			</h:panelGrid>
			<h:commandButton value="Confirmer votre commande"
				action="#{commande.init}" />
		</h:form>
	</f:view>
</body>
</html>