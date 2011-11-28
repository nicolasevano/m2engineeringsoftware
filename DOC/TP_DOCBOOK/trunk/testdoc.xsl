<?xml version="1.0" encoding="UTF8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:date="http://exslt.org/dates-and-times"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
<xsl:output method="xml" indent="yes" encoding="UTF8" lang="fr"/>
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<!-- Modèle de mise en page -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4">
    				<fo:region-body margin-top="15mm" margin-bottom="15mm" />
    				<fo:region-before extent="20mm" /> 
					<fo:region-after extent="10mm"/>
  				</fo:simple-page-master>
			</fo:layout-master-set>

			<!-- Séquence de pages -->
			<fo:page-sequence master-reference="A4">
				<fo:static-content flow-name='xsl-region-before' font-size="12pt">
					<xsl:apply-templates select="article" mode="header"/>
				</fo:static-content>
				<fo:static-content flow-name='xsl-region-after' font-size="12pt">
					<fo:block text-align="right">page <fo:page-number/> </fo:block>	
				</fo:static-content>
				<fo:flow flow-name='xsl-region-body' font-size="20pt">
					<xsl:apply-templates select="article" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="article" mode="header">
		<fo:block text-align="center" font-size="12pt" space-after="30pt" 
				  padding="10pt" padding-left="30pt" padding-right="30pt">
				<fo:table text-align="center" table-layout="fixed" width="100%"
					border="1pt solid black" space-after="10pt" space-before="10pt">
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-column column-width="proportional-column-width(1)" />
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell column-number="1" border="1pt solid black">
								<fo:block>
									<fo:inline font-style="normal" font-size="8pt">
									<!-- work for two author -->
										<xsl:text>Auteurs: </xsl:text>
										<xsl:value-of select="articleinfo/author[2]/firstname" />
										<xsl:text>-</xsl:text>
										<xsl:value-of select="articleinfo/author[2]/surname" />
										<xsl:text>/</xsl:text>
										<xsl:value-of select="articleinfo/author[1]/firstname" />
										<xsl:text>-</xsl:text>
										<xsl:value-of select="articleinfo/author[1]/surname" />
									</fo:inline>
								</fo:block>
							</fo:table-cell>
							<fo:table-cell column-number="2" border="1pt solid black">
								<fo:block font-style="italic">
									<xsl:value-of select="./articleinfo/title" />
								</fo:block>
							</fo:table-cell>
							<fo:table-cell column-number="3" border="1pt solid black">
								<fo:block font-style="normal">
									<xsl:variable name="date" select="date:date-time()" />
									<xsl:value-of select="format-number(date:day-in-month($date),'00')" />
									<xsl:text>/</xsl:text>
									<xsl:value-of select="format-number(date:month-in-year($date),'00')" />
									<xsl:text>/</xsl:text>
									<xsl:value-of select="format-number(date:year($date),'0000')" />
								</fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
		</fo:block>
	</xsl:template>
	
	<xsl:template match="article" >
		<fo:block padding-left="30pt" padding-right="30pt">
			<xsl:apply-templates select="./articleinfo" />
			<xsl:apply-templates select="." mode="summary" />
			<xsl:apply-templates select=".//section" />
			<xsl:apply-templates select="./bibliography" />
		</fo:block>
	</xsl:template>
	
	<xsl:template match="article" mode="summary">
		<fo:block color="blue" padding-left="30pt" padding-right="30pt">
		<fo:inline font-style="normal" font-size="12pt" space-after="12pt">
			<xsl:text>sommaire: </xsl:text>
		</fo:inline>
			<xsl:apply-templates select=".//section" mode="summary"/>
		</fo:block>
		
	</xsl:template>
	
	<xsl:template match="articleinfo" >
		<fo:block text-align="center" font-size="25pt" 
   			font-weight="bold" space-before="14pt" space-after="25pt">
   			<!-- Titre -->
    		<fo:inline font-style="normal" text-transform="uppercase">
    			<xsl:value-of select="./title"/>
    		</fo:inline>	
		</fo:block>
		<fo:block text-align="center" font-size="12pt" font-weight="bold" space-before="14pt" space-after="12pt">
			<fo:inline font-style="normal">
				<xsl:text>Auteurs: </xsl:text>
				<xsl:value-of select="./author[2]/firstname"/>
				<xsl:text>-</xsl:text>
				<xsl:value-of select="./author[2]/surname"/>
				<xsl:text>/</xsl:text>
				<xsl:value-of select="./author[1]/firstname"/>
				<xsl:text>-</xsl:text>
				<xsl:value-of select="./author[1]/surname"/>
			</fo:inline>
		</fo:block>
	</xsl:template>
	
	<xsl:template match="section" >
		<fo:block text-align="left" font-size="15pt" 
   			font-weight="bold" space-after="15pt">
   			<!-- Titre -->
    		<fo:inline font-style="normal">
    			<xsl:value-of select="./@label"/>
    			<xsl:text>-</xsl:text>
    			<xsl:value-of select="./title"/>
    		</fo:inline>	
		</fo:block>
		<fo:block text-align="justify">
			<xsl:apply-templates select="./para|./mediaobject"/>
		</fo:block>
	</xsl:template>
	
	<xsl:template match="section" mode="summary">
		<fo:block text-align="justify" font-style="normal" font-size="12pt" space-after="12pt">
   			<!-- Titre -->
    		<fo:inline font-style="normal" color="blue">
    			<xsl:value-of select="./@label"/>
    			<xsl:text>-</xsl:text>
    			<xsl:value-of select="./title"/>
    		</fo:inline>	
		</fo:block>
	</xsl:template>


	<xsl:template match="text()|para|mediaobject|footnote|link">
		<xsl:choose>
			<xsl:when test="name(.) = 'para'">
				<fo:block font-style="normal"
					font-size="12pt" space-after="14pt">
					<xsl:apply-templates select="./text()|./para|./mediaobject|./footnote|./link"/>
				</fo:block>
			</xsl:when>
			<xsl:when test="name(.) = 'mediaobject'">
				<fo:block text-align="center" font-style="normal"
					font-size="10pt" space-after="14pt">
					<fo:inline font-style="normal" color="blue">
						<fo:external-graphic>
							<xsl:attribute name="src">
    							<xsl:value-of select="./imageobject/imagedata/@fileref" />
  							</xsl:attribute>
						</fo:external-graphic>
					</fo:inline>
				</fo:block>
				<fo:block text-align="center" font-style="normal"
					font-size="10pt" space-after="14pt">
					<fo:inline font-style="normal" color="blue">
						<xsl:apply-templates select="./textobject/para" />
					</fo:inline>
				</fo:block>
			</xsl:when>
			<xsl:when test="name(.) = 'footnote'">
				<fo:footnote>
					<fo:inline baseline-shift="super" color="red" font-size="5pt">
						<xsl:value-of select="./@label"/>
					</fo:inline>
					<fo:footnote-body>
						<fo:block text-align="center" font-style="normal" font-size="8pt" color="red">
							<xsl:value-of select="./@label"/>
							<xsl:text>.</xsl:text> 
							<xsl:value-of select="./para/text()"/>
						</fo:block>
					</fo:footnote-body>
				</fo:footnote>
			</xsl:when>
			<xsl:when test="name(.) = 'link'">
				<fo:basic-link internal-destination="" color="blue">
					<xsl:attribute name="internal-destination">
    				<xsl:value-of select="./@linkend" />
  					</xsl:attribute>
 					<xsl:value-of select="."/>
				</fo:basic-link>			
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="." />
			</xsl:otherwise>				
		</xsl:choose>
	</xsl:template>

	<xsl:template match="bibliography" >
		<fo:block text-align="center" font-size="12pt" space-after="30pt" keep-together="always" break-before="page">
			<fo:inline text-align="left" font-size="15pt" 
   			           font-weight="bold" space-after="15pt" color="blue">
				<xsl:value-of select="./title"/>
			</fo:inline>
			<fo:inline>
				<xsl:apply-templates select="./para"/>
			</fo:inline>
			<fo:table text-align="center" table-layout="fixed" width="100%"
				border="1pt solid black" space-after="10pt" space-before="10pt">
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-column column-width="proportional-column-width(1)" />
				<fo:table-header>
					<fo:table-cell border="1pt solid black">
						<fo:block font-weight="bold">Auteur</fo:block>
					</fo:table-cell>
					<fo:table-cell border="1pt solid black">
						<fo:block font-weight="bold">Titre</fo:block>
					</fo:table-cell>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates select=".//biblioentry" />
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:template match="biblioentry">
		
			<fo:table-row>
				<fo:table-cell column-number="1" border="1pt solid black">
					<fo:block>
						<xsl:attribute name="id">
    						<xsl:value-of select="./@id" />
  						</xsl:attribute>
						<fo:inline font-style="normal">
							<xsl:text></xsl:text>
							<xsl:value-of select="./author/firstname" />
							<xsl:text>-</xsl:text>
							<xsl:value-of select="./author/surname" />
						</fo:inline>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell column-number="2" border="1pt solid black">
					<fo:block font-style="normal" font-weight="bold">
						<xsl:value-of select="./title" />
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
	</xsl:template>
		
</xsl:stylesheet>