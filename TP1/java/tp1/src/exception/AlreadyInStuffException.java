package exception;

public class AlreadyInStuffException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AlreadyInStuffException(){
		System.out.println("La référence est déjà définie");
	}
}
