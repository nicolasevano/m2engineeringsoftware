(: 
transform book to article
:)

declare variable $document external;
<getArticleConditionalResponse>{for $book in $document/list/com.sodifrance.referential__book.Book
				return 
      			<return>
				<author>{$book/author/text()}</author>
      			<kind>book</kind>
      			<editor>{$book/editor/text()}</editor>
      			<meta>chapitre: {$book/NBChapitre/text()}; nb page: {$book/NBPage/text()}; description: {$book/description/text()}</meta>
      			<title>{$book/title/text()}</title>
      			<publishDate>{$book/publishDate/text()}</publishDate> 
      			<releaseDate>{$book/releaseDate/text()}</releaseDate>
      			</return>}</getArticleConditionalResponse>