<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#006600" >
<h1><font color="#FFFF00">Le résultat est:</font></h1>
	<f:view>
		<font color="#FFFF00">
		<h:outputText id="operande1" value="#{calBean.operande1}" />
		+
		<h:outputText id="operande2" value="#{calBean.operande2}" />
		=
		<h:outputText id="result" value="#{calBean.operande1+calBean.operande2}" />
		</font>
	</f:view>
</body>
</html>