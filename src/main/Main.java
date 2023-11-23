package main;

import java.util.Random;

import Entities.*;
import Enums.Names;

public class Main {

	public static void main(String[] args) {
		Entity[] arr = new Entity[10];
		Random rand = new Random();
		Sorter<Entity> sorter = new Sorter<>();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Entity(rand.nextInt(10, 40), Names.getNext());
		}

		printAsList(arr);
		sorter.selectionSortAsc(arr);
		System.out.println("*\nAfter sorting:\n*");
		printAsList(arr);
	}
	
	
	public static void fillIntArr(int[] arr) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
	}
	
	public static<T> void printAsLine(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static<T> void printAsList(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
