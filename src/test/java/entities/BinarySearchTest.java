package entities;

import org.junit.Test;

import main.SearchTemplate;

public class BinarySearchTest {

    @Test
    public void testBinary() {
        SearchTemplate.searchTest(new BinarySearch<Entity>());
    }
    
}
