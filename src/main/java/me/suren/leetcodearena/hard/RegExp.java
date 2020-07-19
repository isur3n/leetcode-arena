package me.suren.leetcodearena.hard;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem - https://leetcode.com/problems/regular-expression-matching/
 */
public class RegExp {

    public static void main(String[] args) {
        Map<String[], Boolean> td = new LinkedHashMap<>();
        td.put(new String[] {"aa", "a"}, false);
        td.put(new String[] {"aa", "a*"}, true);
        td.put(new String[] {"ab", ".*"}, true);
        td.put(new String[] {"aab", "c*a*b"}, true);
        td.put(new String[] {"mississippi", "mis*is*p*."}, false);
        td.put(new String[] {"ab", ".*c"}, false);

        RegExp r = new RegExp();
        for(Map.Entry<String[], Boolean> tc : td.entrySet()) {
            if(r.isMatch(tc.getKey()[0], tc.getKey()[1]) == tc.getValue()) {
                System.out.println(tc.getKey()[0] + ", " + tc.getKey()[1] + " passed.");
            }
            else {
                System.out.println(tc.getKey()[0] + ", " + tc.getKey()[1] + " failed.");
            }
        }
    }

    public boolean isMatch(String s, String p) {

        boolean isStar, result = true;
        int c1=0, c2=0;
        while(c1 < p.length() && c2 < s.length()) {
            char chp = p.charAt(c1), chs = s.charAt(c2);
            isStar = (c1+1 < p.length() && p.charAt(c1+1) == '*') ? true : false;

            if(isStar) {
                if(p.charAt(c1) == '.') {
                    while(c2 < s.length()) {
                        c2++;
                    }
                    c1+=2;
                    continue;
                }
                else if(s.charAt(c2) == p.charAt(c1)) {
                    while(c2 < s.length() && s.charAt(c2) == p.charAt(c1)) {
                        c2++;
                    }
                    c1+=2;
                    continue;
                }
                else if(c2 == 0) {
                    c1+=2;
                    continue;
                }
                else {
                    result = false;
                    break;
                }
            }

            if(p.charAt(c1) == '.') {
                c1++;
                c2++;
            }
            else if(p.charAt(c1) == s.charAt(c2)) {
                c1++;
                c2++;
            }
            else {
                result = false;
                break;
            }
        }

        if(c1 >= p.length() && c2 < s.length()) {
            result = false;
        }

        return result;
    }
}
