package login;

import exception.LoginDejaPrisException;

public class Authentification {
	
	private Database db;
	
	public Authentification(Database db){
		this.db = db;
	}
	
	public void createUserWithLogin(User user) throws LoginDejaPrisException {
		if (db.estDejaPris(user)){
			throw new LoginDejaPrisException();
		}
		db.addUser(user);
	}
	
	public void createUserWithoutLogin(User user) {
		user.calculeLoginRegle1();
		if (db.estDejaPris(user)) {
			user.calculeLoginRegle2();
		}
		if (db.estDejaPris(user)) {
			user.calculeLoginRegle3();
		}
		db.addUser(user);
	}

}
