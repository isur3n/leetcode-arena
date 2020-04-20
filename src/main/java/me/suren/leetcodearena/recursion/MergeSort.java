package me.suren.leetcodearena.recursion;

import me.suren.leetcodearena.util.ArrayUtil;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        ArrayUtil.print(
                m.sortArray(new int[] {8, 4, 6, 3, 7, 9, 1, 0, 2})
        );
    }

    public int[] sortArray(int[] nums) {
        if(nums == null) return new int[0];
        if(nums.length <= 1) return nums;

        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return ArrayUtil.merge(left, right);
    }
}
