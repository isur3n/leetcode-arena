package me.suren.leetcodearena.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 *  range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
 *  integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1534236469;
        ReverseInteger r = new ReverseInteger();
        System.out.println("Integer " + x + " Reverse " + r.reverse(x));
    }

    public int reverse(int x) {

        int sign = 1;
        if(x < 0) {
            sign = -1;
        }

        long y = x * sign;
        long z = 0;
        int i = 0;
        while(y>0) {
            z = z * 10 + (y%10);
            y /= 10;
            i++;
        }

        if(z > Integer.MAX_VALUE)
            return 0;

        return (int) z * sign;
    }
}
