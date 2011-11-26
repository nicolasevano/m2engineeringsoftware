<result>
{
let $prod := doc("produit.xml")/listeProduit/produit[Couleur = 'vert']
return
	count($prod)
}
</result>