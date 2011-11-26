<result>
{	
	let
	$maFourniture1 := doc( "maFourniture.xml" )
	for $providerP1orP4 in $maFourniture1/listeFourniture/fourniture[P = "p2"]/F,
		$providerP4 in $maFourniture1/listeFourniture/fourniture[P = "p4"]/F
	return 
		$providerP1orP4[$providerP1orP4 = $providerP4]
}
</result>