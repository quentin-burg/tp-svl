package login;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import exception.LoginDejaPrisException;



public class AuthentificationTest {

	Database db;
	User user;
	Authentification auth;
	
	@Before
	public void init() {
		this.db = mock(Database.class);
		this.user = mock(User.class);
		this.auth = new Authentification(db);
	}
	
	
	@Test
	public void testAjoutUtilisateurAvecNomPrenomLoginFournis() throws Exception {
		auth.createUser(user);
		verify(db).addUser(user);
	}
	
	@Test(expected=LoginDejaPrisException.class)
	public void testAjoutUtilisateurAvecNomPrenomLoginFournisException() throws Exception {
		doThrow(new LoginDejaPrisException()).when(db).addUser(user);
		auth.createUser(user);
	}

	@Test
	public void testAjouterUtilisateurAvecNomPrenomEtLoginCalcule() throws LoginDejaPrisException {
		//when(db.estDejaPris(user)).thenReturn(false);
		auth.createUser(user);
		verify(db).addUser(user);
	}
}
