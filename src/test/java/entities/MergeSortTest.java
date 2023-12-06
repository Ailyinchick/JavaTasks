package entities;

import org.junit.Test;

import main.SortTemplate;

public class MergeSortTest {

    @Test
    public void sortAsc1000() {
        SortTemplate.testAsc(1000, new MergeSort<Entity>());
    }

    @Test
    public void sortDesc1000() {
        SortTemplate.testDesc(1000, new MergeSort<Entity>());
    }

    @Test
    public void sortAsc1m() {
        SortTemplate.testAsc(1000000, new MergeSort<Entity>());
    }

    @Test
    public void sortDesc1m() {
        SortTemplate.testDesc(1000000, new MergeSort<Entity>());
    }
    
    @Test
    public void sortAsc1000m() {
        SortTemplate.testAsc(1000000000, new MergeSort<Entity>());
    }

    @Test
    public void sortDesc1000m() {
        SortTemplate.testDesc(1000000000, new MergeSort<Entity>());
    }
}
