package me.suren.leetcodearena.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubstitutePalindrome {

    public static void main(String[] args) {
        SubstitutePalindrome s = new SubstitutePalindrome();
        int[][] arr = {{0,3,1}};
        s.canMakePaliQueries("hunu", arr).forEach(i -> System.out.println(i));
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int sub = queries[i][2];
            HashSet<Character> oddChars = new HashSet<>();
            while(start <= end) {
                if(oddChars.remove(s.charAt(start)) == false) {
                    oddChars.add(s.charAt(start));
                }
                start++;
            }
            int allowed = (end-queries[i][0]+1)%2 == 0 ? sub*2 : sub*2+1;
            if(oddChars.size() <= allowed) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}
