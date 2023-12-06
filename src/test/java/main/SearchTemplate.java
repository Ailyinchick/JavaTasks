package main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import entities.Data;
import entities.Entity;
import entities.MergeSort;
import entities.SearchStrategy;
import entities.Searcher;
import entities.Sorter;

public class SearchTemplate {

    public static void searchTest(SearchStrategy<Entity> strategy) {
        List<Entity> list = new ArrayList<>(10);

        list.add(new Entity(Data.getNextName(), 50));
        list.add(new Entity(Data.getNextName(), 48));
        list.add(new Entity(Data.getNextName(), 45));
        list.add(new Entity(Data.getNextName(), 43));
        list.add(new Entity(Data.getNextName(), 40));
        list.add(new Entity(Data.getNextName(), 35));
        list.add(new Entity(Data.getNextName(), 25));
        list.add(new Entity(Data.getNextName(), 22));
        list.add(new Entity(Data.getNextName(), 18));
        list.add(new Entity(Data.getNextName(), 15));

        Sorter<Entity> sorter = new Sorter<>(new MergeSort<Entity>());
        sorter.getSortStrategy().sortAsc(list);
        Searcher<Entity> searcher = new Searcher<>(strategy);
        int index = searcher.getSearchStrategy().
                find(new Entity(Data.getNextName(), 40), list, 0, 10);
        Assert.assertTrue(index == 5);

    }

}
