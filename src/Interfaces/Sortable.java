package Interfaces;

public interface Sortable<T> {
	
	// Basic sort() method
	// should be realized in specific interface
	public void sort(T[] arr);
	
	// Method to compare two objects
	// returns true if this object greater than t1
	// should be realized in specific class, that implements Sortable
	public boolean greaterThan(T t1, T t2);
}
