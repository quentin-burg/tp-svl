package log;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.Test;

public class TestLire {

	@Test
	public void testLireFichierVide() {
		String input_data = "";
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		Lire lire = new Lire();
		assertEquals(new ArrayList<String>(), lire.lire(input));
	}
	
	@Test
	public void testLireFichierUneLigne() {
		String input_data = "2010-02-25, 5, error in database";
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		ArrayList<String> liste = new ArrayList<String>();
		Lire lire = new Lire();
		liste.add(input_data);
		assertEquals(liste, lire.lire(input));
	}
	
	@Test
	public void testLireFichierPlusieursLignes() {
		String ligne1 = "2010-02-25, 5, error in database";
		String ligne2 = "2010-02-25, 10 , system crash";
		String input_data = ligne1 + "\n" + ligne2;
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		ArrayList<String> liste = new ArrayList<String>();
		Lire lire = new Lire();
		liste.add(ligne1);
		liste.add(ligne2);
		assertEquals(liste, lire.lire(input));
	}

}
