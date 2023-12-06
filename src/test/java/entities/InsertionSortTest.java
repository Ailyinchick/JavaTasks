package entities;

import org.junit.Test;

import main.Template;

public class InsertionSortTest {

    @Test
    public void sortAsc1000() {
        Template.testAsc(1000, new InsertionSort<Entity>());
    }

    @Test
    public void sortDesc1000() {
        Template.testDesc(1000, new InsertionSort<Entity>());
    }

}
