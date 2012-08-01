<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alea 03</title>
</head>
<body style="background-color:#FFFF00">
<h1 style="background-color:#FFBD4F">C'est fini: le test est limité a trois coups</h1>
<hr color="#000000" />
	<f:view>
		<h:form>
			<h2 style="background-color:#FFBD4F">
				<h:outputLabel for="numberToFind" value="Nombre a trouver :" />
				&nbsp;<h:outputLabel id="numberToFind" value="#{nombreBean.nombreARechercher}" />
			</h2>
			<br />
		</h:form>
	</f:view>
<hr color="#000000" />
<h2 style="background-color:#FFBD4F"><a href="./alea.jsf" ><font color="#405EA4">Recommencer.</font></a></h2>
</body>
</html>