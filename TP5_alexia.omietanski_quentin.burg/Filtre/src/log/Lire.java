package log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lire {
	
	public Lire() {
	}

	/**
	 * Permet de lire un fichier et de stocker les lignes dans une liste
	 * @param fis flux de données
	 * @return 
	 */
	public List<String> lire(InputStream fis){
		List<String> contenuFichier = new ArrayList<String>();
		try {
			InputStreamReader ipsr = new InputStreamReader(fis);
			BufferedReader buf = new BufferedReader(ipsr);
			String ligne;
			while((ligne = buf.readLine()) != null){
				contenuFichier.add(ligne);
			}
			return contenuFichier;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
