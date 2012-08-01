(: 
transform cd to article
:)
declare namespace con = "http://conditional.mule.esb.stage.sodifrance.com/";
declare namespace ns2 = "http://referential_cd.sodifrance.com/";
declare variable $document external;
for $id in $document/con:getArticleConditional/id
      			return $id