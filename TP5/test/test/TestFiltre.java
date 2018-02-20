package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import log.ConditionPriorite;
import log.Ecrire;
import log.Filtre;
import log.Lire;
import log.Message;

public class TestFiltre {
	
	private ConditionPriorite cp;
	private Ecrire ecrire;
	private Lire lire;
	private Filtre f;
	
	@Before
	public void init() {
		this.cp = mock(ConditionPriorite.class);
		this.ecrire = mock(Ecrire.class);
		this.lire = mock(Lire.class);
		this.f = new Filtre(this.cp, this.ecrire, this.lire);
	}
	
	@Test
	public void testFiltreNEgalZero() {
		Message message = mock(Message.class);
		when(this.cp.estValide(message)).thenReturn(true);
		this.f.filtrer(message);
		verify(this.ecrire).ecrireDansFichier(message);
	}
	
	@Test
	public void testFiltreNEgal5OK() {
		when(this.cp.getPriorite()).thenReturn(5);
		Message message = mock(Message.class);
		when(message.getPriorite()).thenReturn(7);
		when(this.cp.estValide(message)).thenReturn(true);
		this.f.filtrer(message);
		verify(this.ecrire).ecrireDansFichier(message);
	}
	
	@Test
	public void testFiltreNEgal5Failed(){
		when(this.cp.getPriorite()).thenReturn(5);
		Message message = mock(Message.class);
		when(message.getPriorite()).thenReturn(3);
		this.f.filtrer(message);
		verify(this.ecrire, never()).ecrireDansFichier(message);
	}

}
