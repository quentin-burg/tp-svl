package log;

public class Filtre {
	
	private Ecrire ecrire;
	private Lire lire;
	private Condition condition;
	
	public Filtre(Condition condition, Ecrire ecrire, Lire lire) {
		this.ecrire = ecrire;
		this.lire = lire;
		this.condition = condition;
	}
	
	public void filtrer(Message message) {
		if (this.condition.estValide(message)){
			ecrire.ecrireDansFichier(message);
		}		
		return;
	}
}
