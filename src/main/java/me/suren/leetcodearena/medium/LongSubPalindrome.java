package me.suren.leetcodearena.medium;

import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongSubPalindrome {

    public static void main(String[] args) {
        LongSubPalindrome p = new LongSubPalindrome();
        System.out.println(Instant.now());
        System.out.println(p.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        System.out.println(Instant.now());
    }

    public String longestPalindrome(String s) {
        //return longestPalindrome_1(s);
        return longestPalindrome_2(s, new HashSet<>());
    }

    /*********************** Solution 1 ***********************/
    public String longestPalindrome_1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /*********************** Solution 2 ***********************/
    public String longestPalindrome_2(String s, Set<String> dp) {
        if(s == null || "".equals(s))   return s;
        if(dp.contains(s)) {
            return s;
        }
        if(isPalindrome(s)) {
            dp.add(s);
            return s;
        }

        int len = s.length();
        String ls = longestPalindrome_2(s.substring(0, len-1), dp);
        String rs = longestPalindrome_2(s.substring(1, len), dp);

        return (ls.length() > rs.length() ? ls : rs);
    }

    private boolean isPalindrome(String s) {
        if(s == null || "".equals(s))   return false;
        int len = s.length();
        for(int i=0; i<len/2; i++) {
            if(s.charAt(i) != s.charAt(len-1-i)) {
                return false;
            }
        }

        return true;
    }
}
