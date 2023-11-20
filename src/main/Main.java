package main;

import java.util.Random;

import pack01.Sorter;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[20];
		
		fillIntArr(arr);
		System.out.println("Before sorting: ");;
		printIntArr(arr);
		
		Sorter.insertionSort(arr);
		System.out.println("After sorting: ");
		printIntArr(arr);
	}
	
	public static void printIntArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void fillIntArr(int[] arr) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
	}

}
