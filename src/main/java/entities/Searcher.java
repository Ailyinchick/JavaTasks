package entities;

import interfaces.MyComparable;

public class Searcher<T extends MyComparable<T>> {

    private SearchStrategy<T> searchStrategy;

    public Searcher(SearchStrategy<T> strategy) {
        this.searchStrategy = strategy;
    }

    public SearchStrategy<T> getSearchStrategy() {
        return searchStrategy;
    }

    public void setStrategy(SearchStrategy<T> strategy) {
        this.searchStrategy = strategy;
    }
}
