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
	<f:view locale="#{calculBean.langue}">
		<f:loadBundle basename="com.sodifrance.locate.version" var="msgs" />
		<h2>
			<h:outputText value="#{msgs.title}" />
		</h2>
		<h:form>
			<h:commandButton action="#{calculBean.français}"
				image="FrenchFlag.jpg" />
			<h:commandButton action="#{calculBean.anglais}"
				image="EnglishFlag.jpg" />
			<br />
			<h:outputText value="#{msgs.titleOperande}" />
			<h:selectOneMenu value="#{calculBean.nbOperande}">
				<f:selectItems value="#{calculBean.possibleNbOperande}" />
			</h:selectOneMenu>
			<h:commandButton action="Changer" value="#{msgs.ChangeNBOperande}" />
			<hr color="#FFFF00" />
			<h:dataTable value="#{calculBean.operandes.listOp}" var="operande"
				cellpadding="3" styleClass="général" rowClasses="un, deux">
				<f:facet name="header">
					<h:outputLabel value="#{msgs.OperandeList}" />
				</f:facet>
				<h:column>
					<h:outputLabel value="#{msgs.Operande} #{operande.numero}:" />
				</h:column>
				<h:column>
					<h:inputText value="#{operande.valeur}" immediate="true" />
				</h:column>
				<f:facet name="footer">
					<h:selectOneRadio id="operation" value="#{calculBean.operation}"
						styleClass="gras">
						<f:selectItem itemValue="+" itemLabel="#{msgs.Add}" />
						<f:selectItem itemValue="-" itemLabel="#{msgs.Minus}" />
						<f:selectItem itemValue="*" itemLabel="#{msgs.Time}" />
					</h:selectOneRadio>
				</f:facet>
			</h:dataTable>
			<hr color="#FFFF00" />
			<h:commandButton action="#{calculBean.computeOperation}"
				value="#{msgs.SubmitOperation}" />
			<hr color="#FFFF00" />
			<h2>
				<h:outputText value="#{calculBean.operationExpression}" />
			</h2>
			<hr color="#FFFF00" />
			<h3>
				<h:outputLabel value="#{msgs.HistoryTitle}" />
				&nbsp;
				<h:commandButton action="#{calculBean.validerHistorique}"
					value="#{msgs.Hide}" rendered="#{calculBean.montrerHistorique}" />
				<h:commandButton action="#{calculBean.validerHistorique}"
					value="#{msgs.Show}" rendered="#{not calculBean.montrerHistorique}" />
				<h:dataTable value="#{calculBean.historique}" var="historique"
					rendered="#{calculBean.montrerHistorique}">
					<h:column>
						<h:outputText value="#{historique}" styleClass="gras" />
					</h:column>
				</h:dataTable>
			</h3>
		</h:form>
	</f:view>
</body>
</html>