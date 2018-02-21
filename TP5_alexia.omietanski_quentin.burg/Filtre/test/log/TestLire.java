package log;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestLire {

	@Test
	public void testLireFichierVide() {
		Lire lire = new Lire("testFichierVide.txt");
		assertEquals(new ArrayList<String>(), lire.lire());

	}

}
