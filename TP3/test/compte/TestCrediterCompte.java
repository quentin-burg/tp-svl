package compte;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCrediterCompte {

	@Test
	public void testCrediterCompteQuandSoldeEst0(){
		Compte compte = new Compte();
		compte.crediter(20);
		assertEquals(20, compte.getSolde());
	}
	
	@Test
	public void testCrediterQuandSoldeSuperieurA0(){
		Compte compte = new Compte();
		compte.crediter(2000);
		compte.crediter(500);
		assertEquals(2500, compte.getSolde());
	}
}
