package exception;

public class ConditionNulleException extends Exception{
	
	public ConditionNulleException(){
		System.out.println("La condition ne doit pas être nulle");
	}
}
