package lexical;

public class UniteLexIdent implements IUniteLex {
	
	public UniteLexIdent(int codelex, String ch){
		typelex = codelex ;
		valeurlex = ch;
	}
	
	public String unitelex_to_String(){
		return("("+ constlex.constlex_to_String(typelex)+
				","+
				valeurlex+")");

	}
	
	private int typelex ;
	private String valeurlex;
}
