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
   h2 { background-color: #006633; padding: 5px; border : groove; }
   body {font-family: verdana, Arial; color: yellow; background-color: green; }
</style>
</head>
<body>
	<h2>Calcul sur des opérations de base</h2>
	<f:view>
		<h:form>
		<hr color="#FFFF00" />
			<h:panelGrid id="panel" columns="2" cellpadding="3" styleClass="général" rowClasses="un, deux" width="80%">
				
				<f:facet name="header" >
					<h:outputLabel value="Liste des operandes" style="background-color:#1B5E55"/>
				</f:facet>
				
				<h:outputLabel for="operande1" value="operande 1:" />
				<h:inputText id="operande1" value="#{calculBean.operande1}" immediate="true" />
				<h:outputLabel for="operande2" value="operande 2:"/>
				<h:inputText id="operande2" value="#{calculBean.operande2}" immediate="true" />
				<h:outputLabel for="operande3" value="operande 3:" />
				<h:inputText id="operande3" value="#{calculBean.operande3}" immediate="true" />
				<f:facet name="footer" >
					<h:selectOneRadio id="operation" value="#{calculBean.operation}" >
						<f:selectItem itemValue="+" itemLabel="Addition"/>
						<f:selectItem itemValue="-" itemLabel="Soustraction" />
						<f:selectItem itemValue="*" itemLabel="Multiplication" />
					</h:selectOneRadio>
				</f:facet>
			</h:panelGrid>
			<hr color="#FFFF00" />
			<h:commandButton action="#{calculBean.computeOperation}" value="Valider l'opèration" />
			<hr color="#FFFF00" />
			<h2><h:outputText value="#{calculBean.operationExpression}" /></h2>
		</h:form>
	</f:view>
</body>
</html>