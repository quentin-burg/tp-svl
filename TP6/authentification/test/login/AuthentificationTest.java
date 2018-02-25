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
		auth.createUserWithLogin(user);
		verify(db).addUser(user);
	}
	
	@Test(expected=LoginDejaPrisException.class)
	public void testAjoutUtilisateurAvecNomPrenomLoginFournisException() throws Exception {
		when(db.estDejaPris(user)).thenReturn(true);
		auth.createUserWithLogin(user);
	}

	@Test
	public void testAjouterUtilisateurAvecNomPrenomEtLoginCalculeRegle1() {
		auth.createUserWithoutLogin(user);
		verify(user).calculeLoginRegle1();
		verify(db).addUser(user);
	}
	
	@Test
	public void testAjouterUtilisateurAvecNomPrenomEtLoginCalculeRegle2() {
		when(db.estDejaPris(user)).thenReturn(true);
		auth.createUserWithoutLogin(user);
		verify(user).calculeLoginRegle2();
		verify(db).addUser(user);
	}
	
	@Test
	public void testAjouterUtilisateurAvecNomPrenomEtLoginCalculeRegle3() {
		when(db.estDejaPris(user)).thenReturn(true);
		auth.createUserWithoutLogin(user);
		verify(user).calculeLoginRegle3();
		verify(db).addUser(user);
	}
	
	
	
	
}
