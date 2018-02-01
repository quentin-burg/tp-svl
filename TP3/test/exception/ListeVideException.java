package exception;

public class ListeVideException extends Exception {

	private static final long serialVersionUID = 1L;

	public ListeVideException(){
		System.out.println("La liste est vide");
	}
}
