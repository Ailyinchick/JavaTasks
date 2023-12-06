package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;

import entities.Data;
import entities.Entity;
import entities.SortStrategy;
import entities.Sorter;

public class SortTemplate {

    private static List<Entity> generateListOfEntities(int size) {
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

    public static void testAsc(int size, final SortStrategy<Entity> strategy) {
        Sorter<Entity> sorter = new Sorter<Entity>(strategy);
        List<Entity> list = generateListOfEntities(1000);

        sorter.getSortStrategy().sortAsc(list);
        boolean correct = true;
        for (int i = 0; i < list.size() - 1 && correct; i += 1) {
            correct = list.get(i).compareTo(list.get(i + 1)) >= 0;
        }
        Assert.assertTrue(correct);
    }

    public static void testDesc(int size, final SortStrategy<Entity> strategy) {
        Sorter<Entity> sorter = new Sorter<Entity>(strategy);
        List<Entity> list = generateListOfEntities(1000);

        sorter.getSortStrategy().sortDesc(list);
        boolean correct = true;
        for (int i = 0; i < list.size() - 1 && correct; i += 1) {
            correct = list.get(i).compareTo(list.get(i + 1)) <= 0;
        }
        Assert.assertTrue(correct);
    }

}
