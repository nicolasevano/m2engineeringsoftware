declare namespace
local = "http://www.irisa.fr/bekkers";
declare function local:produitParCouleur ($couleur as xs:string) as element()*{
			doc("produit.xml")/listeProduit/produit[Couleur = $couleur]
		};
		
<result>
	{(:
		let
		$fournisseur := doc( "fournisseur.xml" ),
		$maFourniture := doc( "maFourniture.xml" ),
		$vertProd in ( local:produitParCouleur( 'vert' ) ),
		$maFourVert in $maFourniture/listeFourniture/fourniture[P = $vertProd/P],
		$fourn in $maFourniture/listeFourniture/fourniture[F = $maFourVert/F]
		return ( doc( "fournisseur.xml" )/listeFournisseur/fournisseur[F = $fourn/F] )/F
	:)
	let
		$fournisseur := doc( "fournisseur.xml" ),
		$allProductGreen := local:produitParCouleur( 'vert' ),
		$maFourniture := doc( "maFourniture.xml" ),
	    $greenFourDouble := (for $four in $fournisseur/listeFournisseur/fournisseur, 
			$maFour in $maFourniture/listeFourniture/fourniture, 
			$greenProduct in $allProductGreen
				return $four[ F = ( $maFour[ P = $greenProduct/P ] )/F ]/F)
		for $greenFour in distinct-values($greenFourDouble)
		return <F>{$greenFour}</F>
	}
</result>