package exception;

public class ConditionNulleException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConditionNulleException(){
		System.out.println("La condition ne doit pas être nulle");
	}
}
