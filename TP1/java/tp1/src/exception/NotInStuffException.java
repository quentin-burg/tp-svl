package exception;

public class NotInStuffException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NotInStuffException(){
		System.out.println("La référence est indéfinie");
	}
}
