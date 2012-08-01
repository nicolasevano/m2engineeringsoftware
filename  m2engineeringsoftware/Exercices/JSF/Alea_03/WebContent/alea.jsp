<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alea 03</title>
</head>
<body style="background-color:#FFFF00">
<h1>Recherche d'un nombre aléatoir entre 1 et 15 </h1>
<hr color="#000000" />
<f:view>
	<h:form>
		<h:outputLabel for="userNumber" value="Introduiser votre nombre:"/>
		&nbsp;
		<h:inputText id="userNumber" value="#{nombreBean.valeur}" required="true"/>
		&nbsp;<font color='#A45140'><h:outputLabel for="userNumber" value="#{nombreBean.progression}" /></font>
		<br/>
		<h:outputLabel for="userTentatives" value="Tentatives :"/>
		<font color='#A45140'>
		<h:outputLabel id="userTentatives" value="#{nombreBean.tentative}" />
		</font>
		&nbsp; fois.
		<br/>
		<h:commandButton action="#{nombreBean.fini}" value="Valider Votre Choix" disabled="#{ ( nombreBean.tentative > 2 ) || ( nombreBean.nombreARechercher == nombreBean.valeur ) }"/>
		<h:commandButton action="#{nombreBean.init}" value="Tout recommencer" disabled="#{ !( nombreBean.tentative > 2 ) && ( nombreBean.nombreARechercher != nombreBean.valeur ) }" />
		<h:commandButton action="#{infoBean.info}" value="Informations générales" />
	</h:form>
	<hr color="#000000" />
	<h2><font color="#405EA4"><h:outputLabel id="userResultat" value="#{nombreBean.resultat}" /></font></h2>
</f:view>
</body>
</html>