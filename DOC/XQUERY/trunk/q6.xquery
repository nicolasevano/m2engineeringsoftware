<result>
{
let
		$fournisseur := doc( "fournisseur.xml" ),
		$maFourniture := doc( "maFourniture.xml" ),
		$produit := doc( "produit.xml" )
		for $barnibusProduct in $maFourniture/listeFourniture/fourniture[F="f1"]/P
			return
				for $barnibusGreenProduct in $produit/listeProduit/produit[P = $barnibusProduct][Couleur='vert']/Nom_p
				return $barnibusGreenProduct
}
</result>