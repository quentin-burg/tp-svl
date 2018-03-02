package login;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testUserEstDejaPris() {
		Database db = new Database();
		assertTrue(db.estDejaPris(null));
	}
	
	@Test
	public void testAddUser() {
		Database db = new Database();
		db.addUser(null);
	}

}
