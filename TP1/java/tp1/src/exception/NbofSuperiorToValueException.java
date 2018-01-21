package exception;

public class NbofSuperiorToValueException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NbofSuperiorToValueException(){
		System.out.println("Nbof est supérieur à la valeur associée à la référence");
	}
}
