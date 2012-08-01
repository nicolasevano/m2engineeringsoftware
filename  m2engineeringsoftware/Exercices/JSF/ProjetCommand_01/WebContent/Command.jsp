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
   .g�n�ral {background-color: #006633; font-weight: bold; }
   .gras {font-weight: bold; }
   h2, h3 { background-color: #006633; padding: 5px; border : groove; }
   body {font-family: verdana, Arial; color: yellow; background-color: green; }
   .erreur {color: white;}
</style>
</head>
<body>
<h2>Passez votre commande</h2>
	<f:view>
		<h:form>
			<hr color="#FFFF00" />
			<h:panelGrid cellpadding="3" styleClass="g�n�ral" columns="3"
				rowClasses="un, deux">
				<h:outputText value="Article :" />
				<h:inputText id="article" value="#{commande.article}"
					required="true"
					requiredMessage="Pr�cisez votre article." />
				<h:message for="article" errorClass="erreur" />
				<h:outputLabel value="Prix :" />
				<h:inputText id="prix" value="#{commande.prix}" 
					required="true" 
					requiredMessage="Le prix doit �tre compris en tre 10 et 10000."
					validatorMessage="Le prix doit �tre compris en tre 10 et 10000.">
					<f:convertNumber minFractionDigits="2" maxFractionDigits="2" />
					<f:validateDoubleRange minimum="10" maximum="10000" />
				</h:inputText>
				<h:message for="prix" errorClass="erreur" />
				<h:outputLabel value="Quantit� :" />
				<h:inputText id="quantite" value="#{commande.quantite}"
					required="true" 
					requiredMessage="La quantit� minimum doit �tre �gale � 1."
					validatorMessage="La quantit� n'est pas bonne !">
					<f:validateLongRange minimum="1" />
				</h:inputText>
				<h:message for="quantite" errorClass="erreur" />
				<h:outputLabel value="Adresse :" />
				<h:inputText id="addresse" value="#{commande.addresse}"
					required="true" requiredMessage="Pr�cisez l'addresse." />
				<h:message for="addresse" errorClass="erreur" />
				<h:outputLabel value="Code postal :" />
				<h:inputText id="zipCode" value="#{commande.zipCode}"
					required="true" requiredMessage="Le code postal peut �tre compris entre 1000 et 98900."
					validatorMessage="Rentrez un code postal coh�rent.">
					<f:validateLength minimum="5" maximum="5" />
					<f:validateLongRange minimum="1000" maximum="98900" />
				</h:inputText>
				<h:message for="zipCode" errorClass="erreur" />
				<h:outputLabel value="Ville :" />
				<h:inputText id="ville" value="#{commande.city}" required="true" requiredMessage="Pr�cisez la ville."/>
				<h:message for="ville" errorClass="erreur" />
				<h:outputLabel value="Adresse Mail :" />
				<h:inputText id="mail" value="#{commande.mail}" required="true" requiredMessage="Pr�cisez le mail."/>
				<h:message for="mail" errorClass="erreur" />
				<h:outputLabel value="Carte de credit :" />
				<h:inputText id="creditCart" value="#{commande.creditCart}"
					required="true" requiredMessage="Pr�cisez le No de la carte de cr�dit."
					validatorMessage="Le code de la carte n'est pas valide !">
					<f:validateLength minimum="13" />
				</h:inputText>
				<h:message for="creditCart" errorClass="erreur" />
				<h:outputLabel value="Expiration (ex:02/2007) :" />
				<h:inputText id="expiration" value="#{commande.date}"
					required="true" requiredMessage="Pr�cisez la date d'expriration de la commande.">
					<f:convertDateTime pattern="MM/yyyy" />
				</h:inputText>
				<h:message for="expiration" errorClass="erreur" />
			</h:panelGrid>
			<h:commandButton value="Commander" action="#{commande.command}" />
			<h:commandButton value="Annuler" action="#{commande.annuler}"
				immediate="true" />
			<hr color="#FFFF00" />
		</h:form>
	</f:view>
</body>
</html>