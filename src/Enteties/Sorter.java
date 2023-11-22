package Enteties;

import Interfaces.InsertionSort;

public class Sorter<T extends ComparableEntity<T>> implements InsertionSort<T> {

	@Override
	public boolean greaterThan(T t1, T t2) {
		return t1.isGreater(t2);
	}

	
}
