package lexical;

public class constlex {
	
	public static final int lexerreur = 0;
	public static final int lexident = 10 ;
	public static final int lexres = 11;
	public static final int lexduree = 12;
	
	static public String constlex_to_String(int i){
		switch(i){
			case 0 : return new String( "lexerreur" ) ;
			case 10 : return new String( "ident" ) ;
			case 11 : return new String( "res" );
			case 12 : return new String( "duree" );
			default : return new String( "rien" ); 
		}
	}
}