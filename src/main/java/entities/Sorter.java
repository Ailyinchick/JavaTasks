package entities;

import interfaces.MyComparable;

public class Sorter<T extends MyComparable<T>> {

    SortStrategy<T> sortStrategy;

    public Sorter(SortStrategy<T> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    
    public SortStrategy<T> getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortStrategy<T> sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

}
