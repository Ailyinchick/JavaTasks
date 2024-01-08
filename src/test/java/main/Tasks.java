package main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.Account;
import entities.BinarySearch;
import entities.Data;
import entities.MergeSort;
import entities.Searcher;
import entities.Sorter;

public class Tasks {

    @Test
    public void test_2_3_7() {
        List<Account> list = new ArrayList<>();

        list.add(new Account(Data.getNextName(), 50));
        list.add(new Account(Data.getNextName(), 48));
        list.add(new Account(Data.getNextName(), 47));
        list.add(new Account(Data.getNextName(), 46));
        list.add(new Account(Data.getNextName(), 45));
        list.add(new Account(Data.getNextName(), 22));
        list.add(new Account(Data.getNextName(), 21));
        list.add(new Account(Data.getNextName(), -18));
        list.add(new Account(Data.getNextName(), -25));
        list.add(new Account(Data.getNextName(), -40));

        Account account = new Account(Data.getNextName());

        account.setBalance(96);
        test2_3_7(list, account, 6, 9);

        account.setBalance(3);
        test2_3_7(list, account, 2, 3);

        account.setBalance(-43);
        test2_3_7(list, account, 1, 2);

        account.setBalance(20);
        test2_3_7(list, account, 1, 5);

    }

    /*
     * Задача 2.3.7 Разработайте алгоритм со вмеренем работы n*lg(n) (где lg это
     * логарифм по основанию 2) который для заданного множества S из n целых чисел и
     * другогоо числа x определяет, имеются ли в множестве S два элемента, сумма
     * которых равна х. В качестве примера в задаче будет использоваться массив
     * объектов Account Параметры first и second необходимы для отладки: они
     * указывают соответсвенно на первый и второй элементы, сумма значений которых
     * равна значению переданного entity в уже отсортированном массиве
     */
    public static void test2_3_7(List<Account> list, Account entity, int first, int second) {
        if (list == null || entity == null) {
            return;
        }
        Sorter<Account> sorter = new Sorter<>(new MergeSort<Account>());
        sorter.getSortStrategy().sortAsc(list);

        Searcher<Account> searcher = new Searcher<>(new BinarySearch<Account>());
        Account elementToSearch = new Account(Data.getNextName(), 0);
        int index1 = 0;
        int index2 = -1;
        while (index1 < list.size()) {
            elementToSearch.setBalance(entity.getBalance() - list.get(index1).getBalance());
            index2 = searcher.getSearchStrategy().find(elementToSearch, list, 0, list.size());
            if (index2 != -1) {
                break;
            }
            index1 += 1;
        }

        Assert.assertTrue(index1 == first);
        Assert.assertTrue(index2 == second);
    }

}
