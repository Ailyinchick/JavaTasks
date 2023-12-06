package entities;

import org.junit.Test;

import main.Template;

public class MergeSortTest {

    @Test
    public void sortAsc1000() {
        Template.testAsc(1000, new MergeSort<Entity>());
    }

    @Test
    public void sortDesc1000() {
        Template.testDesc(1000, new MergeSort<Entity>());
    }
}