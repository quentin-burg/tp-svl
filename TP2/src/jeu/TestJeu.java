package jeu;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestJeu {

	Banque banque;
    Jeu jeu;
    Joueur joueur;
    De de1;
    De de2;

    @Before
    public void init() {
        this.banque = mock(Banque.class, "banque");
        this.jeu = new Jeu(banque);
        this.joueur = mock(Joueur.class, "joueur");
        this.de1 = mock(De.class, "de1");
        this.de2 = mock(De.class, "de2");
    }


    @Test(expected=JeuFermeException.class)
    public void testJeuFerme() throws Exception {
    	this.jeu.fermer();
        this.jeu.jouer(this.joueur, this.de1, this.de2);
    }

    @Test(expected=DebitImpossibleException.class)
    public void testJoueurInsolvable() throws Exception {
    	doThrow(new DebitImpossibleException()).when(this.joueur).debiter(10);
    	this.joueur.debiter(10);
    }
}