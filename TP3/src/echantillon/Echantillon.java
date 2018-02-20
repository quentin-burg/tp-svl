package echantillon;

import java.util.ArrayList;
import java.util.List;

import exception.FrequenceNegativeException;
import exception.ListeVideException;
import exception.LongueurNegativeException;
import exception.LongueurSuperieureAFrequence;

public class Echantillon {
	public Echantillon() {}
	
	public List<Integer> sous_echantillonne(List<Integer> l, int longueur, int frequence) throws Exception{
		int i;
		
		if (longueur < 0) 
			throw new LongueurNegativeException();  
		else if (frequence < 0 )
			throw new FrequenceNegativeException();
		else if ( longueur > frequence)
			throw new LongueurSuperieureAFrequence();
		else if (l.isEmpty())
			throw new ListeVideException();
		
		List<Integer> res = new ArrayList<Integer>();
		
		for (i=0; i<l.size()-frequence; i += frequence){
			res.addAll(l.subList(i, i+longueur));
		}
		res.addAll(l.subList(i, l.size()));
		
		return res;
	}
}
