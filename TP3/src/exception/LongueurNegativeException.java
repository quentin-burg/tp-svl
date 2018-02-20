package exception;

public class LongueurNegativeException extends Exception {

	private static final long serialVersionUID = 1L;

	public LongueurNegativeException(){
		System.out.println("Une longueur négative est interdite");
	}
}
