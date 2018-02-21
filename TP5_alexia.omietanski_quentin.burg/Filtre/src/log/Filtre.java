package log;

import exception.ConditionNulleException;

public class Filtre {
	
	private Ecrire ecrire;
	private Lire lire;
	private Condition condition;
	
	public Filtre(Condition condition, Ecrire ecrire, Lire lire) {
		this.ecrire = ecrire;
		this.lire = lire;
		this.condition = condition;
	}
	
	public void filtrer(Message message) throws ConditionNulleException{
		if (this.condition == null)
			throw new ConditionNulleException();
		if (this.condition.estValide(message))
			ecrire.ecrireDansFichier(message);		
	}
}
