package log;

public class ConditionPriorite implements Condition{

	
	private int priorite;
	
	public ConditionPriorite(int priorite) {
		this.priorite = priorite;
	}
	
	public int getPriorite() {
		return this.priorite;
	}
	
	
	public boolean estValide(Message message) {
		return true;
	}
}
