package main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.BinarySearch;
import entities.Data;
import entities.Entity;
import entities.MergeSort;
import entities.Searcher;
import entities.Sorter;

public class Tasks {

    @Test
    public void test_2_3_7() {
        List<Entity> list = new ArrayList<>();
        
        list.add(new Entity(Data.getNextName(), 50));
        list.add(new Entity(Data.getNextName(), 48));
        list.add(new Entity(Data.getNextName(), 47));
        list.add(new Entity(Data.getNextName(), 46));
        list.add(new Entity(Data.getNextName(), 45));
        list.add(new Entity(Data.getNextName(), 40));
        list.add(new Entity(Data.getNextName(), 25));
        list.add(new Entity(Data.getNextName(), 22));
        list.add(new Entity(Data.getNextName(), 21));
        list.add(new Entity(Data.getNextName(), 18));
        
        Entity entity = new Entity(Data.getNextName(), 96);
        
        test2_3_7(list, entity, 6, 9);
        
    }

    /*
     * Задача 2.3.7 Разработайте алгоритм со вмеренем работы n*lg(n) (где lg это
     * логарифм по основанию 2) который для заданного множества S из n целых чисел и
     * другогоо числа x определяет, имеются ли в множестве S два элемента, сумма
     * которых равна х. В качестве примера в задаче будет использоваться массив
     * Entity и значение age
     */
    public static void test2_3_7(List<Entity> list, Entity entity, int first, int second) {
        if (list == null || entity == null) {
            return;
        }
        Sorter<Entity> sorter = new Sorter<>(new MergeSort<Entity>());
        // use merge sort = n*lg(2)
        sorter.getSortStrategy().sortAsc(list);
        // add all elements, which is less or equal to object,
        // to ArrayList to reduce total number of elements
        ArrayList<Entity> reducedList = new ArrayList<Entity>();
        for (int i = 0; i < list.size(); i += 1) {
            if (list.get(i).compareTo(entity) == -1) {
                break;
            }
            reducedList.add(list.get(i));
        }
        // use binary search to sum all elements that can be checked = n*lg(n)
        Searcher<Entity> searcher = new Searcher<>(new BinarySearch<Entity>());
        Entity elementToSearch = new Entity(Data.getNextName(), 0);
        int index1 = 0;
        int index2 = -1;
        while (index1 < reducedList.size()) {
            elementToSearch.setAge(entity.getAge() - reducedList.get(index1).getAge());
            if (elementToSearch.getAge() < 0) {
                elementToSearch.setAge(elementToSearch.getAge() * -1);
            }
            index2 = searcher.getSearchStrategy().find(elementToSearch, reducedList, 0, reducedList.size());
            if (index2 != -1) {
                break;
            }
            index1 += 1;
        }
        System.out.println(index1 + " - " + index2);
        Assert.assertTrue(index1 == first);
        Assert.assertTrue(index2 == second);
    }

}
