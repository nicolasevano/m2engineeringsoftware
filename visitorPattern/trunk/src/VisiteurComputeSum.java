/**
 * Visitor allow to compute sum of all elements
 * @author 28008663
 *
 */
public class VisiteurComputeSum implements Visiteur{
	
	@Override
	public void visitElementFloat(ElementFloat element) {
		// TODO Auto-generated method stub
		if( element == element.getTop() ) sumFloat = 0.0;
		sumFloat += element.getValue();
	}

	@Override
	public void visitElementInteger(ElementInteger element) {
		// TODO Auto-generated method stub
		if( element == element.getTop() ) sumInteger = 0;
		sumInteger += element.getValue();
	}
	
	public static double getSumFloat(){
		return sumFloat;
	}
	
	public static long getSumInteger(){
		return sumInteger;
	}
	
	static private double sumFloat;
	static private long sumInteger;
	
}
