(: 
transform cd to article
:)
declare variable $document external;
<getArticleConditionalResponse>{for $cd in $document/list/com.sodifrance.referential__cd.Cd
      			return 
      			<return>
      				<author>{$cd/artist/text()}</author>
      				<kind>cd</kind>
      				<editor>{$cd/editor/text()}</editor>
      				<meta>number of track: {$cd/numberOfTrack/text()}</meta>
      				<title>{$cd/title/text()}</title>
      				<publishDate>{$cd/publishDate/text()}</publishDate> 
      				<releaseDate>{$cd/releaseDate/text()}</releaseDate>
      			</return>}</getArticleConditionalResponse>