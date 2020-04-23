package me.suren.leetcodearena.util;

public final class NumberUtil {

    private NumberUtil() {}

    public static int getSignedInteger(long z, int sign) {
        if(z > (int) Integer.MAX_VALUE) {
            if(sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        else {
            return (int) z;
        }
    }

    public static int isDigit(char ch) {

        if(ch >= 48 && ch <= 57) {
            return ch - 48;
        }
        else {
            return -1;
        }
    }
}
