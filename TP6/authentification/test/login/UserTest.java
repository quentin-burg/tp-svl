package login;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testCalculeLoginCourtRegle1() {
		User user = new User("", "Pierre", "Dupont");
		user.calculeLoginRegle1();
		assertEquals("Dupont", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginLongRegle1() {
		User user = new User("", "Pierre", "DupontEtDurant");
		user.calculeLoginRegle1();
		assertEquals("DupontEt", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginEgal8Regle1() {
		User user = new User("", "Pierre", "Dupontoi");
		user.calculeLoginRegle1();
		assertEquals("Dupontoi", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginCourtRegle2() {
		User user = new User("", "Pierre", "Dupont");
		user.calculeLoginRegle2();
		assertEquals("DupontP", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginLongRegle2() {
		User user = new User("", "Pierre", "DupontEtDurant");
		user.calculeLoginRegle2();
		assertEquals("DupontEP", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginNomEgal7Regle2() {
		User user = new User("", "Pierre", "Duponta");
		user.calculeLoginRegle2();
		assertEquals("DupontaP", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginRegle3LongueursEgales () {
		User user = new User("", "Pierre", "Dupont");
		user.calculeLoginRegle3();
		assertEquals("DPuipeornrte", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginRegle3NomPlusCourt () {
		User user = new User("", "Pierre", "Dup");
		user.calculeLoginRegle3();
		assertEquals("DPuiperre", user.getLogin());
	}
	
	@Test
	public void testCalculeLoginRegle3PreNomPlusCourt () {
		User user = new User("", "Joe", "Dupont");
		user.calculeLoginRegle3();
		assertEquals("DJuopeont", user.getLogin());
	}

}
