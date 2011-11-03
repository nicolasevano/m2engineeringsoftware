<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" indent="yes"	encoding="UTF-8" 
		doctype-system="nutrition.dtd"/>		
	<xsl:template match="/recettes">
		<xsl:apply-templates select="recette"/>
	</xsl:template>	
	
	<xsl:template match="recette"> 
	<plat nom="{nom}" proteines="{nutrition/@proteines}" gras="{nutrition/@gras}" calorie="{nutrition/@calories}" glucides="{nutrition/@glucides}" alcool="{nutrition/@alcool}" >
	<!--xsl:atttribute ../-->
	
	</plat>
	</xsl:template>	
</xsl:stylesheet>