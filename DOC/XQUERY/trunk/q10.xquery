declare namespace
local = "http://www.irisa.fr/bekkers";
declare function local:fournisseurParProduit ($produit as xs:string) as element()*{
			let
				$fournisseurs := doc("fournisseur.xml")/listeFournisseur/fournisseur,
				$maFournitures := doc("maFourniture.xml")/listeFourniture/fourniture
			for $fournisseur in $fournisseurs, $maFourniture in $maFournitures
				return $fournisseur[ F = ( $maFourniture[ contains(P,$produit) ] )/F ]/Nom
		};		
<result>
{	codepoints-to-string(10),
	(: OK auto generate indentation and end line :)
	let
	$products := doc("produit.xml")/listeProduit/produit
	for $produitOrg in distinct-values($products/Origine)
	return (codepoints-to-string(9),<origine ville="{$produitOrg}">{
		codepoints-to-string(10),
		for $produit in $products[contains(Origine,$produitOrg)]
		return (codepoints-to-string(9),codepoints-to-string(9),<produit nom="{$produit/Nom_p}">{
			codepoints-to-string(10),
			for $result in local:fournisseurParProduit($produit/P/text())
			return (codepoints-to-string(9),codepoints-to-string(9),codepoints-to-string(9),
					<Nom>{$result/text()}</Nom>,codepoints-to-string(10)),
		codepoints-to-string(9),
		codepoints-to-string(9)
		}</produit>,codepoints-to-string(10)),
		codepoints-to-string(9)
	}</origine>,codepoints-to-string(10))
}
</result>