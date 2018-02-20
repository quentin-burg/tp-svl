package casino;

import java.util.*;
import exception.*;

public class Jeu {

    private Banque laBanque;
    private boolean statutJeu;

    public Jeu (Banque banque) {
        this.laBanque = banque;
        this.statutJeu = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if ( ! this.estOuvert())
            throw new JeuFermeException();
        int mise = joueur.mise();       
        try{
            joueur.debiter(mise);
        } catch (DebitImpossibleException e){
            e.printStackTrace();
            this.fermer();
        }
        this.laBanque.crediter(mise);
        int d1 = de1.lancer();
        int d2 = de2.lancer();
        if (d1+d2 != 7){
            this.fermer();
        } else{
            this.laBanque.debiter(2*mise);
            joueur.crediter(2*mise);
            if (!this.laBanque.est_solvable()){
                this.fermer();
            }
        }
        
    }

    public void fermer() {
        this.statutJeu = false;
    }

    public boolean estOuvert() {
        return this.statutJeu;
    }
}