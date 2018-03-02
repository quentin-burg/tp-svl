package log;

public class MessageFactory {
	
	private Message message;
	
	//Constructeur
	public MessageFactory() {
	}
	
	/**
	 * Permet de créer un message à partir de la ligne en paramètre
	 * @param ligne la ligne que l'on veut transformer en message
	 */
	public void creerMessage(String ligne) throws Exception{
		this.message = new Message(ligne);
	}
	
	/**
	 * Permet de récupérer le message créé pour pouvoir le
	 * manipuler
	 * @return le message que l'on vient de créer
	 */
	public Message getMessage() {
		return this.message;
	}

}
