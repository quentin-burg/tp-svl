package exception;
public class DebitImpossibleException extends Exception {
    private static final long serialVersionUID = 1L;

    public DebitImpossibleException() {
        System.out.println("Le débit est impossible.");
    }
}