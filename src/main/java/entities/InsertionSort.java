package entities;

import java.util.List;

import interfaces.MyComparable;

public class InsertionSort<T extends MyComparable<T>> extends SortStrategy<T> {

    @Override
    public void sortAsc(List<T> list) {
        sortWithOrder(list, -1);
    }

    @Override
    public void sortDesc(List<T> list) {
        sortWithOrder(list, 1);
    }

    private void sortWithOrder(List<T> list, final int order) {
        if (list == null || list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i += 1) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).compareTo(key) == order)) {
                list.set(j + 1, list.get(j));
                j -= 1;
            }
            list.set(j + 1, key);
        }
    }
}
