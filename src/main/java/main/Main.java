package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;

public class Main {

    public static void main(String[] args) {
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
        Searcher<Entity> searcher = new Searcher<>(new BinarySearch<Entity>());
        int index = searcher.getSearchStrategy().
                find(new Entity(Data.getNextName(), 40), list, 0, 10);
        System.out.println(index);

    }
    

    public static <T> void printAsLine(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <T> void printAsList(List<T> list) {
        for (T t : list) {
            System.out.println(t + " ");
        }
    }

    public static List<Entity> generateListOfEntities(int size) {
        if (size <= 0) {
            return new ArrayList<Entity>(0);
        }
        List<Entity> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i += 1) {
            list.add(new Entity(Data.getNextName(), rand.nextInt(10, 50)));
        }
        return list;
    }

}
