package compte;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.SoldeInsuffisantException;

public class TestDebiterCompte {

	@Test
	public void testDebiterCompteAvecSoldeSuffisant() throws Exception {
		Compte compte = new Compte();
		compte.crediter(500);
		compte.debiter(50);
		assertEquals(450, compte.getSolde());
	}
	
	@Test(expected=SoldeInsuffisantException.class)
	public void testDebiterAvecSoldeZero() throws Exception {
		Compte compte = new Compte();
		compte.debiter(30);
	}
	
	@Test(expected=SoldeInsuffisantException.class)
	public void testDebiterAvecSoldeInsuffisant() throws Exception {
		Compte compte = new Compte();
		compte.crediter(30);
		compte.debiter(50);
	}

}
