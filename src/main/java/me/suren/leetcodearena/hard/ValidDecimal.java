package me.suren.leetcodearena.hard;

import me.suren.leetcodearena.util.NumberUtil;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * PARTIALLY CORRECT.
 *
 * https://leetcode.com/problems/valid-number/
 *
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 *
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */
public class ValidDecimal {

    public static void main(String[] args) {
        ValidDecimal d = new ValidDecimal();
        String[] arr = {"12.5e5", "0", " 0.1 ", "abc", "1 a", "2e10", " -90e3   ", " 1e", "e3", " 6e-1", " 99e2.5 ",
                "53.5e93", " --6 ", "-+3", "95a54e53", "3.", "..", "6+1", ".-4", ".1", "3.0+e1", " .-", " -.",
                "3.", "2e0", "0e", "+", "3e-", "46.e3"};

        for(String n : arr) {
            System.out.println("String " + n + " can be interpreted as a decimal - " + d.isNumber(n));
        }

    }

    public boolean isNumber(String s) {

        if(s == null) {
            return false;
        }

        s = s.trim();

        if("".equals(s)) {
            return false;
        }

        LinkedHashMap<String, Integer> statemc = new LinkedHashMap<>();
        statemc.put("START", 0);
        statemc.put("SIGN_B4_DIGIT", 0);
        statemc.put("DIGIT_B4_DOT", 0);
        statemc.put("DOT", 0);
        statemc.put("DIGIT_AF_DOT", 0);
        statemc.put("E", 0);
        statemc.put("SIGN_AF_E", 0);
        statemc.put("DIGIT_AF_E_OR_SIGN", 0);

        Iterator<Map.Entry<String, Integer>> itr = statemc.entrySet().iterator();
        Map.Entry<String, Integer> currentEntry = nextEntry(itr);
        boolean digitFound = false;

        for(char ch : s.toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                    if("START".equals(currentEntry.getKey()) || "E".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    else {
                        return false;
                    }
                    break;
                case 'e':
                    if("DIGIT_B4_DOT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else if("DIGIT_AF_DOT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    else if("DOT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else {
                        return false;
                    }
                    break;
                case '.':
                    if("START".equals(currentEntry.getKey()) ) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else if("SIGN_B4_DIGIT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else if("DIGIT_B4_DOT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    else {
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    digitFound = true;
                    if("START".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else if("SIGN_B4_DIGIT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    else if("DIGIT_B4_DOT".equals(currentEntry.getKey()) ||
                            "DIGIT_AF_DOT".equals(currentEntry.getKey()) ||
                            "DIGIT_AF_E_OR_SIGN".equals(currentEntry.getKey())) {
                        // Can have multiple digits; do nothing
                    }
                    else if("DOT".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    else if("E".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                        currentEntry = nextEntry(itr);
                    }
                    else if("SIGN_AF_E".equals(currentEntry.getKey())) {
                        currentEntry = nextEntry(itr);
                    }
                    break;
                case ' ':
                default:
                    return false;
            }
        }

        if("E".equals(currentEntry.getKey()) ||
            "SIGN_B4_DIGIT".equals(currentEntry.getKey()) ||
            "SIGN_AF_E".equals(currentEntry.getKey())) {
            return false;
        }

        return digitFound;
    }

    public Map.Entry<String, Integer> nextEntry(Iterator<Map.Entry<String, Integer>> itr) {
        return itr.next();
    }

    public boolean isNumber2(String s) {

        if(s == null) {
            return false;
        }

        s = s.trim();

        if("".equals(s)) {
            return false;
        }

        if(s.charAt(0) == 'e' || s.charAt(s.length()-1) == 'e') {
            return false;
        }

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-') {
            return false;
        }

        if(".".equals(s) || NumberUtil.isDigit(s.charAt(s.length()-1)) == -1) {
            return false;
        }

        boolean signBeforeDigit = false;
        boolean digitBeforeDot = false;
        boolean dot = false;
        boolean e = false;
        boolean signAfterE = false;

        for(char ch : s.toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                    if(!signBeforeDigit && !digitBeforeDot && !dot) {
                        signBeforeDigit = true;
                    }
                    else if(e && !signAfterE) {
                        signAfterE = true;
                    }
                    else {
                        return false;
                    }
                    break;
                case 'e':
                    if(!e && digitBeforeDot) {
                        e = true;
                    }
                    else {
                        return false;
                    }
                    break;
                case '.':
                    if(!e && !dot) {
                        dot = true;
                    }
                    else {
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if(!digitBeforeDot && !dot) {
                        digitBeforeDot = true;
                    }
                    break;
                case ' ':
                default:
                    return false;
            }
        }

        return true;
    }

    public int isDigit(char ch) {

        if(ch >= 48 && ch <= 57) {
            return ch - 48;
        }
        else {
            return -1;
        }
    }

    public boolean isNumber1(String s) {

        if(s == null) {
            return false;
        }

        s = s.trim();

        if("".equals(s)) {
            return false;
        }

        if(s.charAt(0) == 'e' || s.charAt(s.length()-1) == 'e') {
            return false;
        }

        if (".".equals(s)) {
            return false;
        }

        if(s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-') {
            return false;
        }

        boolean digitFound = false;
        boolean digitAfterDotFound = false;
        boolean eFound = false;
        boolean signFound = false;
        boolean eSignFound = false;
        boolean dotFound = false;

        for(char ch : s.toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                    if (signFound && eSignFound) {
                        return false;
                    } else if (digitFound && !eFound) {
                        return false;
                    } else if (signFound && eFound) {
                        eSignFound = true;
                    } else if (signFound) {
                        return false;
                    } else {
                        signFound = true;
                    }
                    break;
                case 'e':
                    if(digitFound) {
                        if(eFound) {
                            return false;
                        }
                        else {
                            eFound = true;
                        }
                    }
                    else {
                        return false;
                    }
                    break;
                case '.':
                    if(dotFound && digitAfterDotFound) {
                        return false;
                    }
                    else if(eFound) {
                        return false;
                    }
                    else if(!dotFound) {
                        dotFound = true;
                    }
                    else {
                        digitAfterDotFound = true;
                    }
                    break;
                case ' ':
                    if(!signFound || !digitFound) {
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    digitFound = true;
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}
