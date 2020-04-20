package me.suren.leetcodearena.recursion;

public class NQueens {

    //public int total = 0;

    public static void main(String[] args) {
        NQueens n = new NQueens();
        int total = n.totalNQueens(4);
        System.out.println(total);
    }

    public int totalNQueens(int n) {
        if(n == 1) return 1;
        else if(n == 2 || n == 3) return 0;
        int[] queens = new int[n];
        return placeQueenAndCheck(queens, 0, 0);
    }

    private int placeQueenAndCheck(int[] queens, int rowNum, int total) {

        int n = queens.length;
        if(rowNum == n) {
            total++;
            return total;
        }

        for(int cols=0; cols < n; cols++) {
            boolean valid = true;
            for(int rows=0; rows < rowNum; rows++) {
                if(queens[rows] == cols || queens[rows] == cols-rowNum+rows
                        || queens[rows] == cols+rowNum-rows) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                queens[rowNum] = cols;
                total = placeQueenAndCheck(queens, rowNum+1, total);
            }
        }

        return total;
    }
}
