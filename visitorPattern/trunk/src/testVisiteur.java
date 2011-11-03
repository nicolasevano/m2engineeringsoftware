
public class testVisiteur {
	public static void main( String ... args ){
		ElementInteger intValue = null;
		ElementFloat floatValue = null;
		Visiteur sum = new VisiteurComputeSum();
		Visiteur time = new VisiteurComputeProduct();
		System.out.println("Initiate element integer in range of 1 to 10 then do same thing with float.");
		for( int i = 1; i <= 10; i++ ){
			intValue = new ElementInteger( i );
			floatValue = new ElementFloat( i );
		}
		//check sum visitor
		intValue.acceptVisiteur( sum );
		System.out.println( "sum of integer in range of 1 to 10 = " + VisiteurComputeSum.getSumInteger() );
		floatValue.acceptVisiteur( sum );
		System.out.println( "sum of float in range of 1 to 10 = " + VisiteurComputeSum.getSumFloat() );
		
		//check product visitor
		intValue.acceptVisiteur( time );
		System.out.println( "times of integer in range of 1 to 10 = " + VisiteurComputeProduct.getTimeInteger() );
		floatValue.acceptVisiteur( time );
		System.out.println( "times of float in range of 1 to 10 = " + VisiteurComputeProduct.getTimeFloat() );
	}
}
