package login;

import exception.LoginDejaPrisException;

public class Database {

	public void addUser(User user) throws LoginDejaPrisException{
		throw new LoginDejaPrisException();
	}

	public boolean estDejaPris(User user) {
		return true;
	}
}
