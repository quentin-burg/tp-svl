package exception;

public class NbofInferiorTo0Exception extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NbofInferiorTo0Exception(){
		System.out.println("Nbof doit être supérieur à 0");
	}
}
