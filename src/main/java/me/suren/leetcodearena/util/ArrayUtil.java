package me.suren.leetcodearena.util;

public class ArrayUtil {

    private ArrayUtil() {}

    public static void print(int[] arr) {
        if(arr == null) return;

        for(int i : arr) {
            System.out.print(i + " -> ");
        }
        System.out.println("end");
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        if(arr1 == null && arr2 == null) return new int[0];
        if(arr1 == null) arr1 = new int[0];
        if(arr2 == null) arr2 = new int[0];

        int arr1len = arr1.length;
        int arr2len = arr2.length;
        int mergedlen = arr1len + arr2len;
        int[] merged = new int[mergedlen];

        int i=0, j=0, k=0;
        while(i < arr1len && j < arr2len) {
            if(arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            }
            else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1len) merged[k++] = arr1[i++];
        while(j < arr2len) merged[k++] = arr2[j++];

        return merged;
    }
}
