package tp1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import exception.AlreadyInStuffException;
import exception.NotInStuffException;
import exception.ValueDifferentFrom0Exception;
import stuff.Stuff;




public class TestStuff {

	@Test
	public void test_creation_map_vide_creation_nouvel_objet() {
		Stuff stuff = new Stuff();
		assertEquals(new HashMap<String,Integer>(),stuff);
	}
	
	@Test
	public void test_ajout_reference_dans_la_map() throws AlreadyInStuffException {
		Stuff stuff = new Stuff();
		stuff.add_ref("tacos");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("tacos", 0);
		assertEquals(map, stuff);
	}
	
	@Test (expected=AlreadyInStuffException.class)
	public void test_on_ne_peut_pas_ajouter_deux_fois_la_meme_reference() throws AlreadyInStuffException{
		Stuff stuff = new Stuff();
		stuff.add_ref("tacos");
		stuff.add_ref("tacos");
	}
	
	@Test
	public void test_suppression_reference_dans_la_map() throws AlreadyInStuffException, NotInStuffException, ValueDifferentFrom0Exception {
		Stuff stuff = new Stuff();
		stuff.add_ref("tacos");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		stuff.del_ref("tacos");
		assertEquals(map,stuff);
	}

	@Test (expected=NotInStuffException.class)
	public void test_on_ne_peut_pas_supprimer_une_reference_qui_n_existe_pas() throws NotInStuffException, ValueDifferentFrom0Exception {
		Stuff stuff = new Stuff();
		stuff.del_ref("tacos");
	}
}
