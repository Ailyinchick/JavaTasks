package entities;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class FindMaximumSubArrayTest {

    public void testTempate(int times, int size) {
        boolean flag = true;
        int counter = 0;
        while (flag == true && counter < times) {
            FindMaximumSubArray finder = new FindMaximumSubArray(size);
            List<Integer> list1 = finder.findMaxSubArrayBruteForce();
            List<Integer> list2 = finder.findMaxSubArrayDivideThem();
            int sum1 = list1.stream().mapToInt(Integer::valueOf).sum();
            int sum2 = list2.stream().mapToInt(Integer::valueOf).sum();
            flag = (sum1 == sum2);
            counter += 1;
        }
        assertTrue(flag);
    }

    @Test
    public void testsize10times10() {
        testTempate(10, 10);
    }

    @Test
    public void testsize100times100() {
        testTempate(100, 100);
    }

    @Test
    public void testsize1000times1000() {
        testTempate(1000, 1000);
    }
}
