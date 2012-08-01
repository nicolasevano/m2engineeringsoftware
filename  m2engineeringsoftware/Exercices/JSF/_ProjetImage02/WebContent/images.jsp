<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>projet image 03</title>
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
			<h:panelGrid columns="2" cellpadding="3" styleClass="général" rendered="#{traitement.présente}">
               <h:commandButton image="LireImage" actionListener="#{traitement.changerCentreZoom}"/>
               <h:graphicImage url="Histogramme" />
               <h:panelGroup>
                  <h:outputText value="#{traitement.largeur} x #{traitement.hauteur} -- " />
                  <h:outputText value="Vignette : " />
                  <h:selectOneMenu value="#{traitement.largeurVignette}" valueChangeListener="#{traitement.changeLargeur}" onchange="submit()">
                     <f:selectItems value="#{traitement.largeurs}" />
                  </h:selectOneMenu>
               </h:panelGroup>                              
               <h:selectOneRadio value="#{traitement.typeCourbe}" valueChangeListener="#{traitement.changeHistogramme}" onchange="submit()">
                  <f:selectItem itemLabel="R" itemValue="rouge"/>
                  <f:selectItem itemLabel="V" itemValue="vert"/>
                  <f:selectItem itemLabel="B" itemValue="bleu"/>
                  <f:selectItem itemLabel="RVB" itemValue="toutes"/>
               </h:selectOneRadio>               
               <h:graphicImage url="Retouche" rendered="#{traitement.traitement}"/>
               <h:graphicImage url="Zoom" />
               <h:panelGroup rendered="#{traitement.traitement}">
                  <h:outputText value="Luminosité " />
                  <h:inputText size="3" value="#{traitement.intensité}" valueChangeListener="#{traitement.changeIntensité}" onchange="submit()">
                     <f:validateLongRange minimum="-50" maximum="50" />
                  </h:inputText>
                  <h:outputText value=" -- Contraste " />
                  <h:inputText size="3" value="#{traitement.contraste}" valueChangeListener="#{traitement.changeContraste}" onchange="submit()">
                     <f:validateLongRange minimum="-50" maximum="50" />
                  </h:inputText>              
               </h:panelGroup>
               <h:panelGroup>
                  <h:selectBooleanCheckbox value="#{traitement.traitement}" valueChangeListener="#{traitement.changeTraitement}" onchange="submit()"/>
                  <h:outputText value="Traitement" />                  
               </h:panelGroup>            
            </h:panelGrid>
		</h:form>
	</f:view>
</body>
</html>