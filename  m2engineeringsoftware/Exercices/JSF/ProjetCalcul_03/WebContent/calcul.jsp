<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calcul 02</title>
<style type="text/css">
   .un {background-color: #00CC00; }
   .deux {background-color: #009900; }
   .général {background-color: #006633; font-weight: bold; }
   .gras {font-weight: bold; }
   h2, h3 { background-color: #006633; padding: 5px; border : groove; }
   body {font-family: verdana, Arial; color: yellow; background-color: green; }
</style>
</head>
<body>
	<h2>Calcul sur des opérations de base</h2>
	<f:view>
		<h:form>
			<h:outputText value="Nombres d'opérandes:" />
			<h:selectOneMenu value="#{calculBean.nbOperande}">
				<f:selectItems value="#{calculBean.possibleNbOperande}"/>
			</h:selectOneMenu>
			<h:commandButton action="Changer" value="Changer le Nombre" />
		</h:form>
		<h:form>
		<hr color="#FFFF00" />
			<h:dataTable value="#{calculBean.operandes.listOp}" var="operande" cellpadding="3" styleClass="général" rowClasses="un, deux">
				<f:facet name="header" >
					<h:outputLabel value="Liste des operandes" />
				</f:facet>
				<h:column>
					<h:outputLabel value="operande #{operande.numero}:" />
				</h:column>
				<h:column>
					<h:inputText value="#{operande.valeur}" immediate="true" />
				</h:column>
				<f:facet name="footer" >
					<h:selectOneRadio id="operation" value="#{calculBean.operation}" styleClass="gras">
						<f:selectItem itemValue="+" itemLabel="Addition" />
						<f:selectItem itemValue="-" itemLabel="Soustraction" />
						<f:selectItem itemValue="*" itemLabel="Multiplication" />
					</h:selectOneRadio>
				</f:facet>
			</h:dataTable>
			<hr color="#FFFF00" />
			<h:commandButton action="#{calculBean.computeOperation}" value="Valider l'opèration" />
			<hr color="#FFFF00" />
			<h2><h:outputText value="#{calculBean.operationExpression}" /></h2>
		</h:form>
		<hr color="#FFFF00" />
		<h3>
		<h:form>
			<h:outputLabel value="Historique" />&nbsp;
			<h:commandButton action="#{calculBean.validerHistorique}" value="Cacher" rendered="#{calculBean.montrerHistorique}" />
			<h:commandButton action="#{calculBean.validerHistorique}" value="Montrer" rendered="#{not calculBean.montrerHistorique}"/>
			<h:dataTable value="#{calculBean.historique}" var="historique" rendered="#{calculBean.montrerHistorique}">
				<h:column>
					<h:outputText value="#{historique}" styleClass="gras"/>
				</h:column>
			</h:dataTable>
		</h:form>
		</h3>
	</f:view>
</body>
</html>