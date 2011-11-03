<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" indent="yes"	encoding="UTF-8" 
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"/>		
	<xsl:template match="/nutrition">
	<html>
			<head>
				<title>xslt question 4.2</title>
			</head>
			<body>
				<h1>nutrition table</h1>
				<p><xsl:value-of select="@date"/></p>
				<table border="1">
					<tbody>
						<tr>
							<th>Plat</th>
							<th>Calorie</th>
							<th>Gras</th>
							<th>Glucides</th>
							<th>Proteines</th>
						</tr>
					</tbody>
	<xsl:apply-templates select="plat">
		<xsl:sort select="@nom"/>
	</xsl:apply-templates>
	</table>
	</body>
	</html>
	</xsl:template>	
	
	<xsl:template match="plat">
		<tr> 
			<td><xsl:value-of select="@nom"/></td>
			<td><xsl:value-of select="@calorie"/></td> 
			<td><xsl:value-of select="@gras"/></td>
			<td><xsl:value-of select="@glucides"/></td>
			<td><xsl:value-of select="@proteines"/></td> 
		</tr>
	</xsl:template>	
</xsl:stylesheet>