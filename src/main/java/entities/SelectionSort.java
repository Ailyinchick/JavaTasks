package entities;

import java.util.List;

import interfaces.MyComparable;

public class SelectionSort<T extends MyComparable<T>> extends SortStrategy<T> {

    @Override
    public void sortAsc(List<T> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i += 1) {
            int minIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(minIndex).compareTo(list.get(j)) == -1) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }

    @Override
    public void sortDesc(List<T> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i += 1) {
            int minIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(minIndex).compareTo(list.get(j)) == 1) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }

    private void swap(List<T> list, int first, int second) {
        if (first < 0 || first >= list.size() || second < 0 && second >= list.size() || list.size() == 1) {
            return;
        }
        T obj = list.get(first);
        list.set(first, list.get(second));
        list.set(second, obj);
        return;
    }

}
