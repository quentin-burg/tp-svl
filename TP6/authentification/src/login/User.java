package login;

public class User {
	
	

	private String login;
	private String nom;
	private String prenom;
	
	public User(String login, String prenom, String nom) {
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getLogin() {
		return this.login;
	}
	
	public void calculeLoginRegle1() {
		if (this.nom.length() > 9)
			this.login = this.nom.substring(0, 8);
		else 
			this.login = this.nom;
	}
	
	public void calculeLoginRegle2() {
		if (this.nom.length() > 8)
			this.login = this.nom.substring(0, 7) + this.prenom.charAt(0);
		else
			this.login = this.nom + this.prenom.charAt(0);
	}

	public void calculeLoginRegle3() {
		String resultat = "";
		int i;
		for (i = 0; i < Integer.min(this.nom.length(), this.prenom.length()) * 2; i++) {
			if (i % 2 == 0)
				resultat += this.nom.charAt(i/2);
			else
				resultat += this.prenom.charAt(i/2);
		}
		resultat += this.nom.substring(i/2) + this.prenom.substring(i/2);
		this.login = resultat;
	}


}
