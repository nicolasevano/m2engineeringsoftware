<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#006600">
	<h1><font color="#FFFF00">Calcul de base</font></h1>
	<f:view>
		<font color="#FFFF00">
			<h:form>
				<hr color="#FFFF00" />
				<h:outputLabel for="operande1" value="opérande 1:"/>
				&nbsp;<h:inputText id="operande1" value="#{calBean.operande1}" required="true" />
				<br/>
				<h:outputLabel for="operande2" value="opérande 2:"/>
				&nbsp;<h:inputText id="operande2" value="#{calBean.operande2}" required="true" />
				<hr color="#FFFF00" />
				<h:commandButton action="#{calBean.plus}" value="+" />
				<h:commandButton action="#{calBean.moin}" value="-" />
			</h:form>
		</font>
	</f:view>
	
</body>
</html>