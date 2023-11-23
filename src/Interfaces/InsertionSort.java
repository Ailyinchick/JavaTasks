package Interfaces;

import Entities.ComparableEntity;

public interface InsertionSort<T extends ComparableEntity<T>> extends Sortable<T> {
	
	// Ascending insertion sort
	public default void insertionSortAsc(T[] arr) {
		if (arr.length < 2) {
		  return;
		}
		for (int i = 1; i < arr.length; i++) {
	      T key = arr[i];
	      int j = i - 1;
	      while (j >= 0 && this.greaterThan(arr[j], key)) {
	    	  arr[j+1] = arr[j];
	    	  j--;
	      }
		  arr[j+1] = key;
		}
	}
	
	// Descending insertion sort
	public default void insertionSortDesc(T[] arr) {
		if (arr.length < 2) {
		  return;
		}
		for (int i = 1; i < arr.length; i++) {
	      T key = arr[i];
	      int j = i - 1;
	      while (j >= 0 && this.greaterThan(key, arr[j])) {
	    	  arr[j+1] = arr[j];
	    	  j--;
	      }
		  arr[j+1] = key;
		}
	}
}

