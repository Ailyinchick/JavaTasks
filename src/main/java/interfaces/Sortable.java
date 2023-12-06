package interfaces;

import java.util.List;

public interface Sortable<T extends MyComparable<T>> {

    public void sortAsc(List<T> list);
    
    public void sortDesc(List<T> list);
}
