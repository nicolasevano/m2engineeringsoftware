<result>
	{for $prod in doc("produit.xml")
		/listeProduit/produit[Couleur = "vert"]
	return $prod/Nom_p}
</result>