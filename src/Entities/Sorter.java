package Entities;

import Interfaces.InsertionSort;
import Interfaces.SelectionSort;

public class Sorter<T extends ComparableEntity<T>> implements InsertionSort<T>, SelectionSort<T> {

	@Override
	public boolean greaterThan(T t1, T t2) {
		return t1.isGreater(t2);
	}

	
}
