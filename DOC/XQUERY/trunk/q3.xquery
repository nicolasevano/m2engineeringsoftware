declare namespace
local = "http://www.irisa.fr/bekkers";
declare function local:produitParCouleur
		($couleur as xs:string) as element()*{
			doc("produit.xml")/listeProduit/produit[Couleur = $couleur]
		};
		
<result>
	{local:produitParCouleur('vert')/Nom_p}
</result>