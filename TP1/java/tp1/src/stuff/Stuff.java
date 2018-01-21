package stuff;

import java.util.HashMap;
import java.util.Set;

import exception.AlreadyInStuffException;
import exception.NbofInferiorTo0Exception;
import exception.NbofSuperiorToValueException;
import exception.NotInStuffException;
import exception.ValueDifferentFrom0Exception;

public class Stuff {
	
	protected HashMap<String, Integer> stuff;
	
	public Stuff(){
		this.stuff = new HashMap<String, Integer>();
	}
	
	public Set<String> refs(){
		return this.stuff.keySet();
	}
	
	public void add_ref(String ref) throws AlreadyInStuffException{
		if (refs().contains(ref))
			throw new AlreadyInStuffException(); 
		else
			System.out.println("La valeur " + ref + " a été ajoutée aux références");
			this.stuff.put(ref, 0);
	}
	
	public void del_ref(String ref) throws NotInStuffException, ValueDifferentFrom0Exception{
		if (!refs().contains(ref))
			throw new NotInStuffException();
		else if (this.stuff.get(ref) != 0)
			throw new ValueDifferentFrom0Exception();
		else
			System.out.println("La valeur " + ref + " a été supprimée des références");
			this.stuff.remove(ref);
	}
	
	public Integer items_ref(String ref) throws NotInStuffException{
		if (!refs().contains(ref))
			throw new NotInStuffException();
		else
			System.out.println("La valeur associée à la référence " + ref + " est " + this.stuff.get(ref));
			return this.stuff.get(ref);
	}
	
	public void add_item_ref(String ref, Integer nbof) throws NbofInferiorTo0Exception, NotInStuffException{
		if (nbof <= 0)
			throw new NbofInferiorTo0Exception();
		else if (!refs().contains(ref))
			throw new NotInStuffException();
		else{
			Integer value = this.stuff.get(ref);
			this.stuff.remove(ref);
			System.out.println("La valeur associée à la référence " + ref + " vaut à présent " + (value + nbof));
			this.stuff.put(ref, value + nbof);
		}
	}
	
	public void cons_item_ref(String ref, Integer nbof) throws NbofInferiorTo0Exception, NotInStuffException, NbofSuperiorToValueException{
		if (!refs().contains(ref))
			throw new NotInStuffException();
		else if (nbof <= 0)
			throw new NbofInferiorTo0Exception();
		else if (nbof > this.stuff.get(ref))
			throw new NbofSuperiorToValueException();
		else{
			Integer value = this.stuff.get(ref);
			this.stuff.remove(ref);
			System.out.println("La valeur associée à la référence " + ref + " vaut à présent " + (value - nbof));
			this.stuff.put(ref, value - nbof);
		}
	}
	
	public static void main (String[] args){
		Stuff s = new Stuff();
		try{
			s.add_ref("poulpe");
			s.add_ref("tacos");
			s.refs();
			s.del_ref("tacos");
			s.refs();
			s.items_ref("poulpe");
			s.add_item_ref("poulpe", 5);
			s.cons_item_ref("poulpe", 3);
		} catch (AlreadyInStuffException e){
			e.printStackTrace();
		} catch (NotInStuffException e){
			e.printStackTrace();
		} catch (ValueDifferentFrom0Exception e){
			e.printStackTrace();
		} catch (NbofInferiorTo0Exception e){
			e.printStackTrace();
		} catch (NbofSuperiorToValueException e){
			e.printStackTrace();
		}
		
	}
}
