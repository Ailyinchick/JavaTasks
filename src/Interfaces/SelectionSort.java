package Interfaces;

import Entities.ComparableEntity;

public interface SelectionSort<T extends ComparableEntity<T>> extends Sortable<T> {

	    // Ascending selection sort
		public default void selectionSortAsc(T[] arr) {
			if (arr.length <= 1) {
				return;
			}
			for (int i = 0; i < arr.length - 1; i++) {
				int minIndex = i;
				for (int j = i; j < arr.length; j++) {
					if (arr[minIndex].isGreater(arr[j])) {
						minIndex = j;
					}
				}
				swap(arr, i, minIndex);
			}
		}
		
		default void swap(T[] arr, int first, int second) {
			if (first < 0 || first >= arr.length || second < 0 && second >= arr.length || arr.length == 1) {
				return;
			}
			T obj = arr[first];
			arr[first] = arr[second];
			arr[second] = obj;
			return;
		}
		
}
