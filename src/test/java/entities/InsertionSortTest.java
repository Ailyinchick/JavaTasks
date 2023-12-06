package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    static List<Entity> generateListOfEntities(int size) {
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

    @Test
    public void sortAsc1000() {
        SortStrategy<Entity> strategy = new InsertionSort<>();
        Sorter<Entity> sorter = new Sorter<Entity>(strategy);
        List<Entity> list = generateListOfEntities(1000);

        sorter.getSortStrategy().sortAsc(list);
        for (int i = 0; i < list.size() - 1; i += 1) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i + 1)) >= 0);
        }
    }

    @Test
    public void sortDesc1000() {
        SortStrategy<Entity> strategy = new InsertionSort<>();
        Sorter<Entity> sorter = new Sorter<Entity>(strategy);
        List<Entity> list = generateListOfEntities(1000);

        sorter.getSortStrategy().sortDesc(list);
        for (int i = 0; i < list.size() - 1; i += 1) {
            Assert.assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }
    }

}
