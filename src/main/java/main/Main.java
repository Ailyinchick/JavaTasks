package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;

public class Main {

    public static void main(String[] args) {
        
        int[] failed1 = {3, -1, -8, 3, -5, 5, -4, -6, 9, -9};
        int[] failed2 = {-2, -5, -1, -5, -10, -10, 9, -7, -2, -3};
        int[] failed3 = {2, -7, -6, -8, -6, -7, 9, -10, 8, -1}; 
        
        FindMaximumSubArray finder = new FindMaximumSubArray(10);
        
        finder.setList(failed3);
        
        printAsLine(finder.getList());
        printAsLine(finder.findMaxSubArrayBruteForce());
        printAsLine(finder.findMaxSubArrayDivideThem());
    }

    public static <T> void printAsLine(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <T> void printAsList(List<T> list) {
        for (T t : list) {
            System.out.println(t + " ");
        }
    }

    public static List<Entity> generateListOfEntities(int size) {
        if (size <= 0) {
            return new ArrayList<Entity>(0);
        }
        List<Entity> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i += 1) {
            list.add(new Entity(Data.getNextName(), rand.nextInt(10, 50)));
        }
        return list;
    }

}
