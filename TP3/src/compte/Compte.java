package compte;

import exception.SoldeInsuffisantException;

public class Compte {
	
	protected int solde;

	public Compte(){
		this.solde = 0;
	}
	
	public int getSolde() {
		return solde;
	}
	
	public void crediter(int somme){
		this.solde += somme;
	}
	
	public void debiter(int somme) throws SoldeInsuffisantException {
		int nouveauSolde = this.solde - somme;
		if (nouveauSolde < 0)
			throw new SoldeInsuffisantException();
		this.solde -= somme;
	}
}
