
public class testFormation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Test composite pattern implmentation: \"Formation\"." );
		
		System.out.println( "Initiate formation \"master 2 GL\"." );
		
		Master2 master2GL = new Master2( "master2GL" );
		
		System.out.println( "Initiate semestre 1" );
		Semestre semestre1 = new Semestre( "semestre 1" );
		Module module = new Module( "AOC" );
		module.setNote( 14 );
		semestre1.ajouteFormation( module );
		module = new Module( "GLI" );
		module.setNote( 12 );
		semestre1.ajouteFormation( module );
		module = new Module( "DOC" );
		module.setNote( 14 );
		semestre1.ajouteFormation( module );
		module = new Module( "CAO" );
		module.setNote( 12 );
		semestre1.ajouteFormation( module );
		module = new Module( "V&V" );
		module.setNote( 14 );
		semestre1.ajouteFormation( module );
		module = new Module( "TAA" );
		module.setNote( 12 );
		semestre1.ajouteFormation( module );
		System.out.println( "Semestre 1 score is: " + semestre1.getNote() );
		
		master2GL.ajouteFormation(semestre1);
		
		System.out.println( "Initiate semestre 2" );
		Semestre semestre2 = new Semestre("semestre 2");
		module = new Module( "VIS" );
		module.setNote( 14 );
		semestre2.ajouteFormation( module );
		module = new Module( "PTR" );
		module.setNote( 12 );
		semestre2.ajouteFormation( module );
		module = new Module( "TAO" );
		module.setNote( 14 );
		semestre2.ajouteFormation( module );
		module = new Module( "MNCO" );
		module.setNote( 12 );
		semestre2.ajouteFormation( module );
		System.out.println( "Semestre 2 score is: " + semestre2.getNote() );
		
		master2GL.ajouteFormation(semestre2);
		System.out.println( "Master 2 GL score is: " + master2GL.getNote() );
		
		
		
	}

}
