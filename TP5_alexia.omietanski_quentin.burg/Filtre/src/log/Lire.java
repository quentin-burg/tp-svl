package log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lire {

	private String fichier;
	
	public Lire(String fichier){
		this.fichier = fichier;
	}
	
	public List<String> lire(){
		InputStream fis;
		List<String> contenuFichier = new ArrayList<String>();
		try {
			fis = new FileInputStream(this.fichier);
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
