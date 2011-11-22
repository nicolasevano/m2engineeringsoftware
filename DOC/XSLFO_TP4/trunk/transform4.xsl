<?xml version="1.0" encoding="ISO-8859-1"?> 
<!-- transform1.xsl -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
<xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>

<xsl:template match="/">
  <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <!-- Modèle de mise en page -->
    <fo:layout-master-set>
  		<fo:simple-page-master master-name="pair-impairOdd">
    		<fo:region-body margin-top="15mm" margin-bottom="15mm" />
    		<fo:region-before region-name="oddHead" extent="20mm" /> 
			<fo:region-after extent="10mm"/>
  		</fo:simple-page-master>
  		<fo:simple-page-master master-name="pair-impairEven">
    		<fo:region-body margin-top="15mm" margin-bottom="15mm" />
    		<fo:region-before region-name="evenHead" extent="20mm" /> 
			<fo:region-after extent="10mm"/>
  		</fo:simple-page-master>
  		<fo:page-sequence-master master-name="pair-impair">
    		<fo:repeatable-page-master-alternatives maximum-repeats="no-limit">
    			<fo:conditional-page-master-reference odd-or-even="odd" master-reference="pair-impairOdd" />
    			<fo:conditional-page-master-reference odd-or-even="even" master-reference="pair-impairEven" />
    		</fo:repeatable-page-master-alternatives>
  		</fo:page-sequence-master>
    </fo:layout-master-set>
	    
    <!-- Séquence de pages -->
    <fo:page-sequence master-reference="pair-impair">
    	<!--fo:static-content flow-name='xsl-region-before' font-size="12pt"-->
    	<fo:static-content flow-name='oddHead' font-size="12pt">
			<xsl:apply-templates select="mondial" mode="pair"/>
		</fo:static-content>
		<fo:static-content flow-name='evenHead' font-size="12pt">
			<xsl:apply-templates select="mondial" mode="impair"/>
		</fo:static-content>
		<!--fo:static-content flow-name='xsl-region-after' font-size="12pt">
			<fo:block text-align="center">page <fo:page-number/> </fo:block>	
		</fo:static-content-->
		<fo:flow flow-name='xsl-region-body' font-size="20pt">
			<xsl:apply-templates select="mondial" />
      	</fo:flow>
    </fo:page-sequence>
    
  </fo:root>
  
</xsl:template>


<xsl:template match="mondial" mode="impair">
	<fo:block text-align="center" font-size="12pt" space-after="30pt">
		<fo:table table-layout="fixed" width="100%">
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-body>
          <fo:table-row>
          	<fo:table-cell column-number="1">
              <fo:block> <fo:page-number/> </fo:block>
            </fo:table-cell>
            <fo:table-cell column-number="2">
            	<fo:block></fo:block>
            </fo:table-cell>
            <fo:table-cell column-number="3">
              <fo:block font-style="italic" ><xsl:text>uni-goettingen.de</xsl:text></fo:block>
            </fo:table-cell>
          </fo:table-row>
        </fo:table-body>
      </fo:table>
	</fo:block>
</xsl:template>

<xsl:template match="mondial" mode="pair">
	<fo:block text-align="center" font-size="12pt" space-after="30pt">
	<fo:table table-layout="fixed" width="100%">
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-column column-width="proportional-column-width(1)"/>
        <fo:table-body>
          <fo:table-row>
          	<fo:table-cell column-number="1">
              <fo:block font-style="italic" ><xsl:value-of select="name(.)" />
              </fo:block>
            </fo:table-cell>
            <fo:table-cell column-number="2">
            	<fo:block></fo:block>
            </fo:table-cell>
            <fo:table-cell column-number="3">
              <fo:block><fo:page-number/></fo:block>
            </fo:table-cell>
          </fo:table-row>
        </fo:table-body>
      </fo:table>
	</fo:block>
</xsl:template>


<xsl:template match="mondial" >	
	<fo:block text-align="center" font-size="20pt" 
   		font-weight="bold" space-after="20pt">	
		
		<xsl:text>Listes des lacs</xsl:text>
		
	</fo:block>
	<fo:list-block break-after="page">
		<xsl:apply-templates select=".//lake">
			<xsl:sort select="name()" />
		</xsl:apply-templates>
	</fo:list-block>
	<fo:block text-align="center" font-size="20pt" 
   		font-weight="bold" space-after="20pt">
   		<!-- Titre -->	
		<xsl:text>Listes des pays</xsl:text>
	</fo:block>  
	<fo:list-block break-after="page">
		<xsl:apply-templates select=".//country">
			<xsl:sort select="name()" />
		</xsl:apply-templates>
	</fo:list-block>
	<fo:block text-align="center" font-size="20pt" 
   		font-weight="bold" space-after="20pt">
   		<!-- Titre -->
    	<fo:inline font-style="normal" text-transform="uppercase">
    		<xsl:value-of select="name()"/>
    	</fo:inline> :	
		<xsl:text>Listes des îles</xsl:text>
	</fo:block>  
	<fo:list-block break-after="page">
		<xsl:apply-templates select=".//island">
			<xsl:sort select="name()" />
		</xsl:apply-templates>
	</fo:list-block>
	<fo:block text-align="center" font-size="20pt" 
   		font-weight="bold" space-after="20pt">
   		<!-- Titre -->
    	<fo:inline font-style="normal" text-transform="uppercase">
    		<xsl:value-of select="name()"/>
    	</fo:inline> :	
		<xsl:text>Listes des montagnes</xsl:text>
	</fo:block>  
	<fo:list-block>
		<xsl:apply-templates select=".//mountain">
			<xsl:sort select="name()" />
		</xsl:apply-templates>
	</fo:list-block>
</xsl:template>

<xsl:template match="city">
  <!-- applique les règles sur les attributs de city -->
  <fo:block space-before="14pt" font-size="10pt"> 
    <xsl:apply-templates select="longitude|latitude|name|population" />    
  </fo:block>
</xsl:template>

<xsl:template match="country">
	<fo:list-item keep-together="always">
	<fo:list-item-label>
		<fo:block margin-left="25mm" space-before="14pt" font-size="15pt">
			<fo:inline>
				<xsl:text>*</xsl:text><xsl:value-of select="name" />
			</fo:inline>
		</fo:block>
	</fo:list-item-label>
	<fo:list-item-body>
		<fo:block margin-left="25mm" space-before="30pt" font-size="10pt">
			<fo:inline>
    		</fo:inline>
    		<fo:inline space-before="14pt">
    			<xsl:apply-templates select="@car_code|area|government|population|encompassed/@continent" />
    		</fo:inline>
  		</fo:block>
  	</fo:list-item-body>
  	</fo:list-item>
</xsl:template>

<xsl:template match="lake">
<!--id : island-Ometepe
country : NIC
lake : lake-Nicaragua_See
longitude : -85.6
latitude : 11.5! -->
	<fo:list-item keep-together="always">
	<fo:list-item-label>
		<fo:block margin-left="25mm" space-before="14pt" font-size="15pt">
			<fo:inline>
				<xsl:text>*</xsl:text><xsl:value-of select="name" />
			</fo:inline>
		</fo:block>
	</fo:list-item-label>
	<fo:list-item-body>
		<fo:block margin-left="25mm" space-before="30pt" font-size="10pt">
			<fo:inline>
			</fo:inline>
    		<fo:inline space-before="14pt">
    			<xsl:apply-templates select="@id|located/@country|name|longitude|latitude" />
    		</fo:inline>
  		</fo:block>
  	</fo:list-item-body>
  	</fo:list-item>
</xsl:template>

<xsl:template match="mountain">
<!--id : mount-Adams
country : USA
type : volcano
longitude : -121.5
latitude : 46.2 
 -->
 	<fo:list-item keep-together="always">
 	<fo:list-item-label>
 		<fo:block margin-left="25mm" space-before="14pt" font-size="15pt">
    		<fo:inline>
      			<xsl:text>*</xsl:text><xsl:value-of select="name" />
    		</fo:inline>
		</fo:block>
	</fo:list-item-label>
	<fo:list-item-body>		
    	<fo:block margin-left="25mm" space-before="30pt" font-size="10pt">
    		<fo:inline>
    		</fo:inline>
    		<fo:inline>
    		<xsl:apply-templates select="./@id|./@country|./@type|longitude|latitude" />
    		</fo:inline>
  		</fo:block>
  	</fo:list-item-body>
  	</fo:list-item>
</xsl:template>

<xsl:template match="island">
	<!-- id|country|sea|longitude|latitude -->
	<fo:list-item keep-together="always">
	<fo:list-item-label>
		<fo:block margin-left="25mm" space-before="14pt" font-size="30pt">
			<fo:inline>
      			<xsl:text>*</xsl:text><xsl:value-of select="name" />
    		</fo:inline>
		</fo:block>
	</fo:list-item-label>
	<fo:list-item-body>
		<fo:block margin-left="25mm" space-before="30pt" font-size="10pt">
			<fo:inline>
    		</fo:inline>
    		<fo:inline>
    			<xsl:apply-templates select="./@id|./@country|sea|longitude|latitude" />
    		</fo:inline>
  		</fo:block>
  	</fo:list-item-body>
  	</fo:list-item>
</xsl:template>

<!-- Traitement des éléments de city :
 copier le nom de l'élément et donner sa valeur -->
<xsl:template match="longitude|latitude|name|population" >
  <fo:block> 
    <fo:inline font-style="italic">
        <fo:inline font-weight="bold">
      		<xsl:text>*</xsl:text><xsl:value-of select="." />
    	</fo:inline> 
    </fo:inline> : 
    <fo:inline font-weight="bold" font-size="20pt"> 
      <xsl:value-of select="." />
    </fo:inline> 
  </fo:block>
</xsl:template>

<xsl:template match="name|@car_code|area|government|population|encompassed/@continent" >
  <fo:block>
  	<xsl:choose>
  		<xsl:when test="name(.)='government'">
    		<fo:inline font-weight="bold" color="red"> 
      			<xsl:value-of select="." />
    		</fo:inline>
  		</xsl:when>
  		<xsl:otherwise>
     		<fo:inline font-style="italic">
      			<xsl:value-of select="name(.)" /> 
    		</fo:inline> :
    		<fo:inline font-weight="bold" font-size="15pt"> 
      			<xsl:value-of select="." />
    		</fo:inline>
  		</xsl:otherwise>
	</xsl:choose>
  </fo:block>
  
</xsl:template> 

<xsl:template match="@id|located/@country|name|longitude|latitude" >
  <fo:block keep-together="always"> 
    <fo:inline font-style="italic">
      <xsl:value-of select="name(.)" /> 
    </fo:inline> : 
    <fo:inline font-weight="bold" font-size="15pt"> 
      <xsl:value-of select="." />
    </fo:inline> 
  </fo:block>

</xsl:template>

<xsl:template match="@id|@country|@type|longitude|latitude" >
  <fo:block> 
    <fo:inline font-style="italic">
      <xsl:value-of select="name(.)" /> 
    </fo:inline> : 
    <fo:inline font-weight="bold" font-size="15pt"> 
      <xsl:value-of select="." />
    </fo:inline> 
  </fo:block>
</xsl:template>

<xsl:template match="@id|@country|sea|longitude|latitude" >
  <fo:block> 
    <fo:inline font-style="italic">
      <xsl:value-of select="name(.)" /> 
    </fo:inline> : 
    <fo:inline font-weight="bold" font-size="15pt"> 
      <xsl:value-of select="." />
    </fo:inline> 
  </fo:block>
</xsl:template>

</xsl:stylesheet>



