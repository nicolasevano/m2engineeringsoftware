declare namespace
local = "http://www.irisa.fr/bekkers";
declare function local:fournisseurParProduit ($produit as xs:string) as element()*{
			let
				$fournisseurs := doc("fournisseur.xml")/listeFournisseur/fournisseur,
				$maFournitures := doc("maFourniture.xml")/listeFourniture/fourniture
			for $fournisseur in $fournisseurs, $maFourniture in $maFournitures
				return $fournisseur[ F = ( $maFourniture[ P = $produit ] )/F ]
		};
		
<result>
{
 	codepoints-to-string(10),
	for $result in local:fournisseurParProduit('p4')/Nom
	return (<Nom>{$result/text()}</Nom>,codepoints-to-string(10))
}
</result>