package compte;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCreationCompte {

	@Test
	public void testCreationCompteObjetCree() {
		Compte compte = new Compte();
		assertNotNull(compte);
	}
	
	@Test
	public void testCreationCompteSolde0(){
		Compte compte = new Compte();
		assertEquals(0,compte.getSolde());
	}

}
