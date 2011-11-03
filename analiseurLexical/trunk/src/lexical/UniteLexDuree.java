package lexical;

public class UniteLexDuree implements IUniteLex {

	public UniteLexDuree(int codelex, int min){
		typelex = codelex ;
		this.min = min;
	}
	
	@Override
	public String unitelex_to_String() {
		return("("+ constlex.constlex_to_String(typelex)+
				","+
				min+")");
	}

	private int typelex ;
	private int min;
	
}
