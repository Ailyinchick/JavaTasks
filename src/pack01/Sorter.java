package pack01;

public class Sorter {

	public static void insertionSort(int[] arr) {
		if (arr.length < 2) {
		  return;
		}
		for (int i = 1; i < arr.length; i++) {
	      int key = arr[i];
	      int j = i - 1;
	      while (j >= 0 && arr[j] > key) {
	    	  arr[j+1] = arr[j];
	    	  j--;
	      }
    	  arr[j+1] = key;
		}
	}
	
}
