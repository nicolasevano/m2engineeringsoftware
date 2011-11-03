package lexical;

public class UniteLexRes implements IUniteLex {

	public UniteLexRes(int codelex, String ch){
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
