package interfaces;

import java.util.List;

public interface Searchable<T extends MyComparable<T>> {

    /*
     * Returns index of first element between bounds 'from' and 'to'
     * or -1 otherwise
     */
    public int find(T t, List<T> list, int from, int to);
}
