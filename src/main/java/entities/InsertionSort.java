package entities;

import java.util.List;

import interfaces.MyComparable;

public class InsertionSort<T extends MyComparable<T>> extends SortStrategy<T> {

    @Override
    public void sortAsc(List<T> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i += 1) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).compareTo(key) == -1)) {
                list.set(j+1, list.get(j));
                j -= 1;
            }
            list.set(j+1, key);
        }
    }

    @Override
    public void sortDesc(List<T> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i += 1) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).compareTo(key) == 1)) {
                list.set(j+1, list.get(j));
                j -= 1;
            }
            list.set(j+1, key);
        }

    }
}
