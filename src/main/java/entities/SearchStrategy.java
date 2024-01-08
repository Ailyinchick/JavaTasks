package entities;

import interfaces.MyComparable;
import interfaces.Searchable;

public abstract class SearchStrategy<T extends MyComparable<T>> implements Searchable<T> {
    
}
