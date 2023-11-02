package main;

import pack01.Message;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from Main");
		for (int i = 0; i < 12; i++) {
			System.out.println(Message.getNext());
		}
		// Theese lines was added in local branch to
	}

}
