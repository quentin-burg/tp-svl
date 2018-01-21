package exception;

public class ValueDifferentFrom0Exception extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ValueDifferentFrom0Exception(){
		System.out.println("La valeur associée à la référence est supérieure à 0");
	}
}
