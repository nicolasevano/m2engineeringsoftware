<?xml version="1.0" encoding="ISO-8859-15"?>
<!-- DOC - TP XPath -->
<!-- test3.xsl -->
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:top500="http://www.top500.org/xml/top500/1.0"
	>
	<xsl:output method="xml" version="1.0" indent="yes"	encoding="ISO-8859-15" 
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"/>
	
<!-- Placer l'EXPRESSION XPATH DANS LE SELECT CI-DESSOUS -->
<!-- par exemple : la ville du premier site -->
	
	<xsl:variable name="UnitedStatesCount" >
		<xsl:value-of select='count(//top500:site[contains(./top500:country/text(),"United States")])'/>
	</xsl:variable>
	
	<xsl:variable name="test" >
		<!-- xsl:for-each select="//top500:site[not(top500:manufacturer=preceding-sibling::top500:site/top500:manufacturer)]
		/top500:manufacturer"-->
			<!--  xsl:value-of select="count(//top500:site[contains(top500:manufacturer/text(),string(.)])"/-->
		<!-- /xsl:for-each-->
		<xsl:if test="(//top500:site[contains(./top500:country/text(),'China')]/year) &gt; 2005">
			<xsl:value-of select="true"/> 
		</xsl:if>
		<xsl:if test="(every $date in (//top500:site[contains(./top500:country/text(),'China')]/year) satisfies $date &gt; 2005)">
			<xsl:value-of select="false"/> 
		</xsl:if>
	</xsl:variable>
	
<!-- Produire une page XHTML -->
	<xsl:template match="//top500:list">
		<html>
			<head>
				<title>Question 3 XPath</title>
			</head>
			<body>
				<h1>Question 3 - binôme Sylvie et Nicolas </h1>
				<p><strong>Top 500 </strong><xsl:value-of select="@date"/></p>
				<h2>
					<xsl:text>L'évaluation de l'expression XPath donne </xsl:text>
				</h2>
	 			<p><xsl:value-of select='$test'/></p>            	
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="text()|@*" />
	
</xsl:stylesheet>
