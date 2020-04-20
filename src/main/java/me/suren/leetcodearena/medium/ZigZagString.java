package me.suren.leetcodearena.medium;

/**
 * Description at - https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagString {

    public static void main(String[] args) {

        ZigZagString z = new ZigZagString();
        String s = "AB";
        System.out.println("String ==> " + s);
        System.out.println("ZigZag ==> " + z.convert(s, 1));
    }

    public String convert(String s, int numRows) {

        if(s == null || "".equals(s) || numRows < 0) return "";
        if(numRows == 1) return s;

        StringBuilder[] sba = new StringBuilder[numRows];

        int c = 0;
        boolean increasingOrder = true;
        for(char ch : s.toCharArray()) {
            if(sba[c] == null)  sba[c] = new StringBuilder();
            sba[c].append(ch);
            if(increasingOrder) {
                if(c+1 >= numRows) {
                    increasingOrder = false;
                    c--;
                }
                else {
                    c++;
                }
            }
            else {
                if(c-1 < 0) {
                    increasingOrder = true;
                    c++;
                }
                else {
                    c--;
                }
            }
        }

        for(int i = 1; i<numRows; i++) {
            if(sba[i] == null) continue;
            sba[0].append(sba[i]);
        }

        return sba[0].toString();
    }
}
