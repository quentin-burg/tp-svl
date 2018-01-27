package jeu;

public class JeuFermeException extends Exception {
    private static final long serialVersionUID = 1L;

    public JeuFermeException() {
        System.out.println("Le jeu est fermé.");
    }
}