package login;

import exception.LoginDejaPrisException;

public class Authentification {
	
	private Database db;
	
	public Authentification(Database db){
		this.db = db;
	}
	
	public void createUser(User user) throws LoginDejaPrisException {
		db.addUser(user);
		//TODO Gérer le fait que le login soit dans la database ou pas
	}

}
