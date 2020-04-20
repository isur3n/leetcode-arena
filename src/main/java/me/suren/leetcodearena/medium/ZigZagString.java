package me.suren.leetcodearena.medium;

/**
 * Description at - https://leetcode.com/problems/zigzag-conversion/
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
