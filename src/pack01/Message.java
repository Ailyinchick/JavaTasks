package pack01;

public enum Message {
	WARNING,
	ERROR,
	EXCEPTION,
	NOTOFICATION,
	DEFAULT;
	
	private static int pointer = 0;
	
	public static String getNext() {
		if (pointer >= Message.values().length) {
			pointer = 0;
		}
		return Message.values()[pointer].name();
	}
	
}
