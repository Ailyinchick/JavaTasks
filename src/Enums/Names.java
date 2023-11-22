package Enums;

public enum Names {
	MIKE,
	KYLE,
	BRAD,
	TREVOR,
	JOHN;
	
	private static int pointer = 0;
	
	public static String getNext() {
		if (pointer >= Names.values().length) {
			pointer = 0;
		}
		return Names.values()[pointer++].name();
	}
	
}
