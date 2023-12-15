package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindMaximumSubArray {

    private ArrayList<Integer> list;

    // default size of list is 10
    public FindMaximumSubArray() {
        this.list = new ArrayList<Integer>(10);
        regenerateList(10);
    }

    public FindMaximumSubArray(ArrayList<Integer> list) {
        this.list = list;
    }

    public FindMaximumSubArray(int size) {
        this.list = new ArrayList<Integer>(size);
        regenerateList(size);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public void setList(int[] arr) {
        if (arr == null) {
            this.list.clear();
            this.list.trimToSize();
            return;
        }
        this.list.clear();
        for (int i = 0; i < arr.length; i += 1) {
            this.list.add(arr[i]);
        }
    }

    public void regenerateList(int size) {
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            list.clear();
        }
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(-10, 10));
        }
    }

    public List<Integer> findMaxSubArrayDivideThem() {
        int[] arr = findMaximumSubArray(0, list.size() - 1);
        int size = arr[1] - arr[0];
        ArrayList<Integer> ans = new ArrayList<Integer>(size);
        for (int i = arr[0]; i <= arr[1]; i++) {
            ans.add(list.get(i));
        }
        return ans;

    }

    /*
     * Find max sub array in list and returns it as List<T> Brute Force - O(n^2)
     */
    public List<Integer> findMaxSubArrayBruteForce() {
        if (list == null || list.size() == 0) {
            return new ArrayList<Integer>();
        }

        int from = 0, to = 0, maxSummInLine = list.get(0), maxSumm = list.get(0);

        for (int i = 0; i < list.size(); i += 1) {
            int summ = list.get(i), lineFrom = i, lineTo = i;
            if (summ > maxSummInLine) {
                maxSummInLine = summ;
                lineFrom = i;
                lineTo = i;
            }
            for (int j = i + 1; j < list.size(); j += 1) {
                summ += list.get(j);
                if (summ > maxSummInLine) {
                    lineFrom = i;
                    lineTo = j;
                    maxSummInLine = summ;
                }
            }
            if (maxSummInLine > maxSumm) {
                from = lineFrom;
                to = lineTo;
                maxSumm = maxSummInLine;
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>(to - from);
        for (int i = from; i <= to; i += 1) {
            ans.add(list.get(i));
        }
        return ans;
    }

    /*
     * Пока что как затычка будет использоваться массив из 3х значений вместо
     * кортежа
     */
    private int[] findMaxCrossingSubArray(int low, int mid, int high) {
        int leftSumm, rightSumm, sum, maxLeft, maxRight;
        maxLeft = mid;
        maxRight = mid + 1;

        leftSumm = list.get(mid);
        sum = 0;
        for (int i = mid; i >= low; i -= 1) {
            sum = sum + list.get(i);
            if (sum >= leftSumm) {
                leftSumm = sum;
                maxLeft = i;
            }
        }
        rightSumm = list.get(mid + 1);
        sum = 0;
        for (int i = mid + 1; i <= high; i += 1) {
            sum = sum + list.get(i);
            if (sum >= rightSumm) {
                rightSumm = sum;
                maxRight = i;
            }
        }

        int[] arr = new int[3];
        arr[0] = maxLeft;
        arr[1] = maxRight;
        arr[2] = leftSumm + rightSumm;
        return arr;

    }

    private int[] findMaximumSubArray(int low, int high) {
        if (high == low) {
            int[] arr = new int[3];
            arr[0] = low;
            arr[1] = high;
            arr[2] = list.get(low);
            return arr;
        }
        int mid = (low + high) / 2;

        int[] leftArr = findMaximumSubArray(low, mid);
        int[] rightArr = findMaximumSubArray(mid + 1, high);
        int[] crossingArray = findMaxCrossingSubArray(low, mid, high);

        if (leftArr[2] >= rightArr[2] && leftArr[2] >= crossingArray[2]) {
            return leftArr;
        } else if (rightArr[2] >= leftArr[2] && rightArr[2] >= crossingArray[2]) {
            return rightArr;
        } else {
            return crossingArray;
        }
    }

}
