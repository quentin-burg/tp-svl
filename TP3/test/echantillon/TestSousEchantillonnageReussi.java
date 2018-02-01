package echantillon;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import exception.FrequenceNegativeException;
import exception.ListeVideException;
import exception.LongueurNegativeException;
import exception.LongueurSuperieureAFrequence;

public class TestSousEchantillonnageReussi {

	@Test (expected=LongueurNegativeException.class)
	public void testSousEchantillonnageLongueurNegativeException() throws Exception{
		Echantillon echantillon = new Echantillon();
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i<=10; i++){
			l.add(i);
		}
		echantillon.sous_echantillonne(l, -2, 3);
	}
	
	@Test (expected=FrequenceNegativeException.class)
	public void testSousEchantillonnageFrequenceNegativeException() throws Exception{
		Echantillon echantillon = new Echantillon();
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i<=10; i++){
			l.add(i);
		}
		echantillon.sous_echantillonne(l, 2, -3);
	}
	
	@Test (expected=LongueurSuperieureAFrequence.class)
	public void testSousEchantillonnageLongueurSuperieureAFrequenceException() throws Exception{
		Echantillon echantillon = new Echantillon();
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i<=10; i++){
			l.add(i);
		}
		echantillon.sous_echantillonne(l, 3, 2);
	}
	
	@Test (expected=ListeVideException.class)
	public void testSousEchantillonnageListeVideException() throws Exception{
		Echantillon echantillon = new Echantillon();
		List<Integer> l = new ArrayList<Integer>();
		echantillon.sous_echantillonne(l, 2, 3);
	}
	
	@Test
	public void testSousEchantillonnageReussi() throws Exception{
		Echantillon echantillon = new Echantillon();
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i<=10; i++){
			l.add(i);
			if (i != 3 && i != 6 && i != 9)
				res.add(i);
		}
		assertEquals(res, echantillon.sous_echantillonne(l, 2, 3));
	}

}
