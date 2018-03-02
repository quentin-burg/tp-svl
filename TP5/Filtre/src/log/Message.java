package log;

import exception.VirguleManquanteDansMessageLog;

public class Message {

	private int priorite;
	private String date;
	private String message;
	
	public Message(String ligne) throws VirguleManquanteDansMessageLog{
		String[] tabMsg = ligne.split(", ");
		
		if (tabMsg.length < 3)
			throw new VirguleManquanteDansMessageLog();
		
		this.date = tabMsg[0];
		this.priorite = Integer.parseInt(tabMsg[1]);
		this.message = tabMsg[2];
	}
	
	public int getPriorite() {
		return this.priorite;
	}

	public String getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}
	
	public boolean equals(Message message) {
		return this.message.equals(message.getMessage()) && this.date.equals(message.getDate()) && this.priorite == message.getPriorite();
	}
}
