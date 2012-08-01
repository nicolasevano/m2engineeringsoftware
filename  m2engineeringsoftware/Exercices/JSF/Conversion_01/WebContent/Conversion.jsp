<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conversion 01</title>
<style type="text/css">
   .un {background-color: #00CC00; }
   .deux {background-color: #009900; }
   .général {background-color: #006633; font-weight: bold; }
   .gras {font-weight: bold; }
   .textBlue{font-weight: bold; color: blue;}
   .textYellow{font-weight: bold; color: yellow;}
   h2, h3 { background-color: #006633; padding: 5px; border : groove; }
   body {font-family: verdana, Arial; color: yellow; background-color: orange; }
   hr{color: black}
</style>
</head>
<body>
	<f:view>
		<h:form>
			<h1>
				<h:outputLabel value="Convertion monétaire" />
			</h1>
			<hr />
			<h:outputLabel value="Aujourd'hui nous sommes le:"
				styleClass="textYellow" />
			<br />
			<h:panelGroup>
				<h:outputText value="#{conversion.date}" styleClass="textBlue">
					<f:convertDateTime type="date" pattern="EEEEEEEE d MMM yyyy" />
				</h:outputText>
			</h:panelGroup>
			<br />
			<h:outputLabel value="Et il est:" styleClass="textYellow" />
			<br />
			<h:panelGroup styleClass="textBlue">
				<h:outputText value="#{conversion.date}" styleClass="textBlue">
					<f:convertDateTime type="date" pattern="h" />
				</h:outputText>
				h
				<h:outputText value="#{conversion.date}" styleClass="textBlue">
					<f:convertDateTime type="date" pattern="mm" />
				</h:outputText>
				mn
				<h:outputText value="#{conversion.date}" styleClass="textBlue">
					<f:convertDateTime type="date" pattern="ss" />
				</h:outputText>
				s
			</h:panelGroup>
			<br />
			<br />
			<h:inputText
				value="#{conversion.resultat}"
				immediate="true" />&nbsp; x &nbsp;
				<h:inputText value="#{conversion.quantité}" immediate="true" />
			<br />
			<br />
			<h:commandButton value="Euro->Franc"
				action="#{conversion.convertEuroToFranc}" />&nbsp; 
		<h:commandButton value="Franc->Euro"
				action="#{conversion.convertFrancToEuro}" />
			<br />
			<hr />
			<br />
			<h:outputText value="#{conversion.euros}" styleClass="textYellow" />&nbsp;&euro;&nbsp;x&nbsp;
		<h:outputText value="#{conversion.quantité}" styleClass="textYellow" />&nbsp; = &nbsp;
		<h:outputText value="#{conversion.euros * conversion.quantité}"
				styleClass="textYellow" />&nbsp;&euro;
		<br />
			<br />
			<h:outputText value="#{conversion.francs}" styleClass="textYellow" />&nbsp;F&nbsp;x&nbsp;
		<h:outputText value="#{conversion.quantité}" styleClass="textYellow" />&nbsp; = &nbsp;
		<h:outputText value="#{conversion.francs * conversion.quantité}"
				styleClass="textYellow" />&nbsp;F
		<br />
			<br />
		</h:form>
	</f:view>
</body>
</html>