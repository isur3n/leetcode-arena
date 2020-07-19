package me.suren.leetcodearena.medium;

import me.suren.leetcodearena.hard.RegExp;
import me.suren.leetcodearena.util.ArrayUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem - https://leetcode.com/problems/container-with-most-water/
 */
public class MaxWater {

    public static void main(String[] args) {
        Map<Integer[], Integer> td = new LinkedHashMap<>();
        td.put(new Integer[] {1,8,6,2,5,4,8,3,7}, 49);

        MaxWater m = new MaxWater();
        for(Map.Entry<Integer[], Integer> tc : td.entrySet()) {
            if(m.maxArea(tc.getKey()) == tc.getValue()) {
                System.out.println(tc.getKey()[0] + ", " + tc.getKey()[1] + " passed.");
            }
            else {
                System.out.println(tc.getKey()[0] + ", " + tc.getKey()[1] + " failed.");
            }
        }
    }

    public int maxArea(Integer[] height) {
        int[] arr = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            arr[i] = height[i];
        }
        return maxArea(arr);
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if(area > maxArea) {
                maxArea = area;
            }

            if(height[start] > height[end]) {
                end--;
            }
            else {
                start++;
            }
        }
        return maxArea;
    }
}
