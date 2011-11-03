<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" indent="yes"	encoding="UTF-8" 
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"/>	
<xsl:template match="/recettes">	
<html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<title>XSL 2/2</title>
	</head>
	<body>
		<h1>cuisine livre</h1>
				<ol>
					<xsl:apply-templates select="recette" mode="index">
						<xsl:sort select="nom"/>
					</xsl:apply-templates>
				</ol>
				<table border="1">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Ingredient</th>
							<th>preparation</th>
							<th>note</th>
							<th>nutrition</th>
						</tr>
					</thead>
					<tbody>
						<xsl:apply-templates select="recette" mode="detail">
							<xsl:sort select="nom"/>
						</xsl:apply-templates>
					</tbody>
				</table>
	</body>
</html>		
</xsl:template>
<xsl:template match="recette" mode="index">
	<li><a href="#{generate-id()}"><xsl:value-of select="nom"/></a></li>
</xsl:template>
		
<xsl:template match="recette" mode="detail">
	<tr id="{generate-id()}"> 
		<td><xsl:value-of select="nom"/></td>
		<td><xsl:value-of select="ingredient"/></td> 
		<td><xsl:value-of select="preparation"/></td>
		<td><xsl:value-of select="note"/></td>
		<td><xsl:value-of select="nutrition"/></td> 
	</tr>
</xsl:template>

<xsl:template match="ingredient">
	<xsl:if "./@qte">
		<xsl:value-of select="@nom "/>
		<xsl:value-of select="@qte "/>
		<xsl:value-of select="@unit "/>
	</xsl:if>	
	<xsl:if "./ingredient">
		
	</xsl:if>
</xsl:template>

</xsl:stylesheet>