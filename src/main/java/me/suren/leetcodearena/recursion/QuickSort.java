package me.suren.leetcodearena.recursion;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] arr = new int[] {1, 5, 3, 2, 8, 7, 6, 4};
        s.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int s, int e) {
        if(s > e || s < 0 || e < 0) {
            return;
        }

        int partitionIndex = findPivotPlace(arr, s, e);

        sort(arr, s, partitionIndex-1);
        sort(arr, partitionIndex+1, e);
    }

    private int findPivotPlace(int[] arr, int s, int e) {
        int pivot = arr[e];
        int placement = s;

        // Find placement for pivot element.
        for(int counter = s; counter < e; counter++) {
            if(arr[counter] < pivot) {
                int temp = arr[counter];
                arr[counter] = arr[placement];
                arr[placement] = temp;
                placement++;
            }
        }

        // Place pivot in placement.
        arr[e] = arr[placement];
        arr[placement] = pivot;

        return placement;
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = a;
    }
}
