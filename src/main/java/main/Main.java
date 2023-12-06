package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;

public class Main {

    public static void main(String[] args) {
        SortStrategy<Entity> strategy = new InsertionSort<>();
        Sorter<Entity> sorter = new Sorter<>(strategy);
        List<Entity> entities = generateListOfEntities(10);
        
        printAsList(entities);
        sorter.getSortStrategy().sortAsc(entities);
        System.out.println("After sorting: ");
        printAsList(entities);

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
