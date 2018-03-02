package log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exception.VirguleManquanteDansMessageLog;

public class TestLire {

	@Test
	public void testLireFichierVide() throws Exception{
		String input_data = "";
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		MessageFactory factory = new MessageFactory();
		Lire lire = new Lire(factory);
		assertEquals(new ArrayList<Message>(), lire.lire(input));
	}
	
	@Test
	public void testLireFichierUneLigne() throws Exception{
		String input_data = "2010-02-25, 5, error in database";
		Message message = new Message(input_data);
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		ArrayList<Message> liste = new ArrayList<Message>();
		MessageFactory factory = new MessageFactory();
		Lire lire = new Lire(factory);
		liste.add(message);
		assertTrue(message.equals(lire.lire(input).get(0)));
	}
	
	@Test
	public void testLireFichierPlusieursLignes() throws Exception{
		String ligne1 = "2010-02-25, 5, error in database";
		String ligne2 = "2010-02-25, 10, system crash";
		Message message1 = new Message(ligne1);
		Message message2 = new Message(ligne2);
		String input_data = ligne1 + "\n" + ligne2;
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		ArrayList<Message> liste = new ArrayList<Message>();
		MessageFactory factory = new MessageFactory();
		Lire lire = new Lire(factory);
		liste.add(message1);
		liste.add(message2);
		List<Message> resLire = lire.lire(input);
		assertTrue(message1.equals(resLire.get(0)));
		assertTrue(message2.equals(resLire.get(1)));
	}
	
	@Test (expected=VirguleManquanteDansMessageLog.class)
	public void testErreurDansLeFichier() throws Exception{
		String input_data = "2010-02-25, 5 error in database";
		Message message = new Message(input_data);
		ByteArrayInputStream input = new ByteArrayInputStream(input_data.getBytes());
		ArrayList<Message> liste = new ArrayList<Message>();
		MessageFactory factory = new MessageFactory();
		Lire lire = new Lire(factory);
		liste.add(message);
		lire.lire(input);
	}

}
