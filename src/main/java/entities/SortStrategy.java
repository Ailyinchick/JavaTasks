package entities;

import interfaces.MyComparable;
import interfaces.Sortable;

public abstract class SortStrategy<T extends MyComparable<T>> implements Sortable<T> {
    
}
