package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.MyComparable;

public class MergeSort<T extends MyComparable<T>> extends SortStrategy<T> {

    @Override
    public void sortAsc(List<T> list) {
        splitAndMergeAsc(list, 0, list.size() - 1);
    }

    @Override
    public void sortDesc(List<T> list) {
        splitAndMergeDesc(list, 0, list.size() - 1);
    }

    private void splitAndMergeAsc(List<T> list, int first, int last) {
        // return if first and last indexes point at the same element of array
        if (last == first) {
            return;
            // if only two elements - then merge without split
        } else if (last - first == 1) {
            mergeAsc(list, first, first, last, last);
            // if more than two elements between first and last indexes -
            // spit to sub-arrays and then - merge
        } else {
            int middleIndex = first + (last - first) / 2;
            splitAndMergeAsc(list, first, middleIndex);
            splitAndMergeAsc(list, middleIndex + 1, last);
            mergeAsc(list, first, middleIndex, middleIndex + 1, last);
        }
    }
    
    private void splitAndMergeDesc(List<T> list, int first, int last) {
        // return if first and last indexes point at the same element of array
        if (last == first) {
            return;
            // if only two elements - then merge without split
        } else if (last - first == 1) {
            mergeDesc(list, first, first, last, last);
            // if more than two elements between first and last indexes -
            // spit to sub-arrays and then - merge
        } else {
            int middleIndex = first + (last - first) / 2;
            splitAndMergeDesc(list, first, middleIndex);
            splitAndMergeDesc(list, middleIndex + 1, last);
            mergeDesc(list, first, middleIndex, middleIndex + 1, last);
        }
    }

    private void mergeAsc(List<T> list, int from1, int to1, int from2, int to2) {
        // define lengths of sub-arrays
        int len1 = 1 + (to1 - from1), len2 = 1 + (to2 - from2);
        ArrayList<T> sorted = new ArrayList<>(len1 + len2);
        int ind1 = from1, ind2 = from2;
        while (ind1 <= to1 && ind2 <= to2) {
            if (list.get(ind1).compareTo(list.get(ind2)) == -1) {
                sorted.add(list.get(ind2));
                ind2 += 1;
            } else {
                sorted.add(list.get(ind1));
                ind1 += 1;
            }
        }
        while (ind1 <= to1) {
            sorted.add(list.get(ind1));
            ind1 += 1;           
        }
        while (ind2 <= to2) {
            sorted.add(list.get(ind2));
            ind2 += 1;           
        }
        for (int i = 0; i < sorted.size(); i += 1) {
            list.set(from1 + i, sorted.get(i));
        }
    }

    private void mergeDesc(List<T> list, int from1, int to1, int from2, int to2) {
        // define lengths of sub-arrays
        int len1 = 1 + (to1 - from1), len2 = 1 + (to2 - from2);
        ArrayList<T> sorted = new ArrayList<>(len1 + len2);
        int ind1 = from1, ind2 = from2;
        while (ind1 <= to1 && ind2 <= to2) {
            if (list.get(ind1).compareTo(list.get(ind2)) == 1) {
                sorted.add(list.get(ind2));
                ind2 += 1;
            } else {
                sorted.add(list.get(ind1));
                ind1 += 1;
            }
        }
        while (ind1 <= to1) {
            sorted.add(list.get(ind1));
            ind1 += 1;           
        }
        while (ind2 <= to2) {
            sorted.add(list.get(ind2));
            ind2 += 1;           
        }
        for (int i = 0; i < sorted.size(); i += 1) {
            list.set(from1 + i, sorted.get(i));
        }
    }

}
