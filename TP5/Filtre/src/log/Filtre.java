package log;

import exception.ConditionNulleException;

public class Filtre {
	
	private Ecrire ecrire;
	private Condition condition;
	
	//Constructeur
	public Filtre(Condition condition, Ecrire ecrire, Lire lire) {
		this.ecrire = ecrire;
		this.condition = condition;
	}
	
	/**
	 * Cette fonction permet de filtrer les messages selon une condition
	 * @param message le message que l'on désire filtrer
	 * @throws ConditionNulleException Cette exception est levée si la condition passée en paramètre
	 * du filtre à sa création est nulle
	 */
	public void filtrer(Message message) throws ConditionNulleException{
		if (this.condition == null)
			throw new ConditionNulleException();
		if (this.condition.estValide(message))
			this.ecrire.ecrireDansFichier(message);		
	}
}
