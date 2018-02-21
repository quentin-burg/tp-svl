package log;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import exception.*;

import org.junit.Before;
import org.junit.Test;

import exception.ConditionNulleException;

public class TestFiltre {

	private ConditionPriorite cp;
	private Ecrire ecrire;
	private Lire lire;
	private Filtre f;
	private Message message;
	
	@Before
	public void init() {
		this.cp = mock(ConditionPriorite.class);
		this.ecrire = mock(Ecrire.class);
		this.lire = mock(Lire.class);
		this.f = new Filtre(this.cp, this.ecrire, this.lire);
		this.message = mock(Message.class);
	}
	
	@Test
	public void testFiltreNEgalZero() throws Exception{
		when(this.cp.estValide(message)).thenReturn(true);
		this.f.filtrer(message);
		verify(this.ecrire).ecrireDansFichier(message);
	}
	
	@Test
	public void testFiltreNEgal5OK() throws Exception{
		when(this.cp.getPriorite()).thenReturn(5);
		when(message.getPriorite()).thenReturn(7);
		when(this.cp.estValide(message)).thenReturn(true);
		this.f.filtrer(message);
		verify(this.ecrire).ecrireDansFichier(message);
	}
	
	@Test
	public void testFiltreNEgal5Failed() throws Exception{
		when(this.cp.getPriorite()).thenReturn(5);
		when(message.getPriorite()).thenReturn(3);
		this.f.filtrer(message);
		verify(this.ecrire, never()).ecrireDansFichier(message);
	}
	
	@Test (expected=ConditionNulleException.class)
	public void testFiltreConditionNulleException() throws Exception{
		Filtre filtre = new Filtre(null,this.ecrire,this.lire);
		filtre.filtrer(message);
	}
}
