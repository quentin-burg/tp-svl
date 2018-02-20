package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import casino.*;
import exception.*;

public class TestJeu {

        @Test(expected=JeuFermeException.class)
    public void testJeuFerme() throws Exception {
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
    	jeu.fermer();
        jeu.jouer(joueur, de1, de2);
    }

    @Test
    public void testJoueurInsolvable() throws Exception {
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
    	doThrow(new DebitImpossibleException()).when(joueur).debiter(10);
    	when(joueur.mise()).thenReturn(10);
    	when(de1.lancer()).thenReturn(1);
    	when(de2.lancer()).thenReturn(1);
    	jeu.jouer(joueur, de1, de2);
    }
    
    @Test
    public void testJoueurInsolvableArretJeu() throws Exception{
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
        doThrow(new DebitImpossibleException()).when(joueur).debiter(10);
    	when(joueur.mise()).thenReturn(10);
    	when(de1.lancer()).thenReturn(1);
    	when(de2.lancer()).thenReturn(1);
    	jeu.jouer(joueur, de1, de2);
    	verify(de1,atLeast(1)).lancer();
    	verify(de2,atLeast(1)).lancer();
    }
    
    @Test (expected=JeuFermeException.class)
    public void testJoueurGagneEtBanqueInsolvableArretJeu() throws Exception{
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
        when(banque.est_solvable()).thenReturn(false);
        jeu.jouer(joueur,de1,de2);
        jeu.jouer(joueur,de1,de2);
    }
    
    @Test
    public void testJoueurGagneEtBanqueSolvableJeuContinue() throws Exception{
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
        when(de1.lancer()).thenReturn(5);
        when(de2.lancer()).thenReturn(2);
        when(banque.est_solvable()).thenReturn(true);
        jeu.jouer(joueur,de1,de2);
        assertTrue(jeu.estOuvert());
    }
    
    @Test
    public void testJoueurPerdArretJeu() throws Exception{
    	Banque banque = mock(Banque.class, "banque");
    	Jeu jeu = new Jeu(banque);
        Joueur joueur = mock(Joueur.class, "joueur");
        De de1 = mock(De.class, "de1");
        De de2 = mock(De.class, "de2");
        when(de1.lancer()).thenReturn(1);
        when(de2.lancer()).thenReturn(3);
        jeu.jouer(joueur,de1,de2);
        assertFalse(jeu.estOuvert());
    }
}
