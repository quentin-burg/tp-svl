package exception;

public class FrequenceNegativeException extends Exception {
	private static final long serialVersionUID = 1L;

	public FrequenceNegativeException(){
		System.out.println("La frequence est négative");
	}
}
