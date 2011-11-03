
/**
 * Visitor allow to compute product of all elements
 * @author 28008663
 *
 */
public class VisiteurComputeProduct implements Visiteur{

	@Override
	public void visitElementFloat(ElementFloat element) {
		// TODO Auto-generated method stub
		if( element == element.getTop() ) timeFloat = 1.0;
		timeFloat *= element.getValue();
	}

	@Override
	public void visitElementInteger(ElementInteger element) {
		// TODO Auto-generated method stub
		if( element == element.getTop() ) timeInteger = 1;
		timeInteger *= element.getValue();
	}
	
	public static double getTimeFloat(){
		return VisiteurComputeProduct.timeFloat;
	}
	
	public static long getTimeInteger(){
		return VisiteurComputeProduct.timeInteger;
	}
	
	private static double timeFloat;
	
	private static long timeInteger;

}
