package me.suren.facebook.arrays;

class ReverseToEqual {

    // Add any helper functions you may need here


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        if(array_a == null || array_b == null) {
            return false;
        }

        int len_a = array_a.length;
        int len_b = array_b.length;

        if(len_a != len_b) {
            return false;
        }

        int c_a=0, c_b=0;
        for( ; c_a < len_a; c_a++, c_b++) {
            if(array_a[c_a] != array_b[c_b]) {
                break;
            }
        }

        // Both arrays are same.
        if(c_a == len_a) {
            return true;
        }

        // We have reached to a point where both arrays don't match
        int len = len_a - 1;
        for(; c_a < len_a; c_a++, len--) {
            if(array_a[c_a] != array_b[len]) {
                return false;
            }
        }

        return true;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseToEqual().run();
    }
}