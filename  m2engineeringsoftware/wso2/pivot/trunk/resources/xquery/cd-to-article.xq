<![CDATA[
declare namespace ns2="http://referential_cd.sodifrance.com/";
declare namespace soap="http://schemas.xmlsoap.org/soap/envelope/";
declare namespace soapenv="http://www.w3.org/2003/05/soap-envelope";
declare variable $payload as document-node() external;
<getAllArticleResponse>{for $cd in $payload/soap:Envelope/soap:Body/ns2:getAllCDResponse/return
      			return 
					<return>
						<author>{$cd/artist/text()}</author>
						<kind>cd</kind>
						<editor>{$cd/editor/text()}</editor>
						<meta>number of track: {$cd/numberOfTrack/text()}</meta>
						<title>{$cd/title/text()}</title>
						<publishDate>{$cd/publishDate/text()}</publishDate>
						<releaseDate>{$cd/releaseDate/text()}</releaseDate>
					</return>
}</getAllArticleResponse>
]]>