package entities;

import java.util.List;

import interfaces.MyComparable;

public class BinarySearch<T extends MyComparable<T>> extends SearchStrategy<T> {

    @Override
    public int find(final T t, final List<T> list, int from, int to) {
        if (t == null || list == null || to <= from) {
            return -1;
        }
        int index = from + (to - from) / 2;
        if (t.compareTo(list.get(index)) == 0) {
            return index;
        }
        if (t.compareTo(list.get(index)) == 1) {
            to = index - 1;
        } else {
            from = index + 1;
        }
        return find(t, list, from, to);
    }

}
