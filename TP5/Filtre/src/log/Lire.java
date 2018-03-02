package log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lire {
	
	private MessageFactory factory;
	
	// Constructeur
	public Lire(MessageFactory factory) {
		this.factory = factory;
	}

	/**
	 * Permet de lire un fichier et de stocker les lignes dans une liste
	 * @param fis flux de donnees
	 * @return Retourne une liste de chaînes de caractères correspondant à 
	 * chaque ligne du fichier
	 */
	public List<Message> lire(InputStream fis) throws Exception{
		List<Message> contenuFichier = new ArrayList<Message>();
		try {
			InputStreamReader ipsr = new InputStreamReader(fis);
			BufferedReader buf = new BufferedReader(ipsr);
			String ligne;
			while((ligne = buf.readLine()) != null){
				this.factory.creerMessage(ligne);
				contenuFichier.add(this.factory.getMessage());
			}
			return contenuFichier;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
