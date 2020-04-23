package me.suren.leetcodearena.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.print.attribute.standard.PresentationDirection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        Map<Integer, Boolean> testcases = prepareTests();

        PalindromeNumber p = new PalindromeNumber();
        testcases.forEach((k, v) -> {
            if(v != p.isPalindrome(k)) {
                System.out.println(k + " test failed. Expecting " + v + " Received " + !v);
            }
        });
    }

    public boolean isPalindrome(int x) {

        if(x < 0) {
            return false;
        }

        int y = x, z = 0;
        while(y > 0) {
            z = z * 10 + (y % 10);
            y /= 10;
        }

        if(x == z) {
            return true;
        }
        else {
            return false;
        }
    }

    private static Map<Integer, Boolean> prepareTests() {
        Map<Integer, Boolean> testcases = new LinkedHashMap<>();
        testcases.put(0, true);
        testcases.put(121, true);
        testcases.put(-121, false);
        return testcases;
    }
}
