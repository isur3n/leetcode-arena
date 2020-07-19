package me.suren.leetcodearena.recursion;

public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(s.searchMatrix(matrix, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return search2D(matrix, target,matrix[0].length-1, matrix.length-1);
    }

    public boolean search2D(int[][] matrix, int target, int ex, int ey) {

        if(matrix[ex][ey] == target) {
            return true;
        }

        if(matrix[ex][ey] > target) {
            return false;
        }

        if(search2D(matrix, target, ex-1, ey-1)) {
            return true;
        }

        if(bst_search_col(matrix, target, ey + 1)) {
            return true;
        }

        return bst_search_row(matrix[ex-1], target);
    }

    private boolean bst_search_col(int[][] matrix, int target, int column) {

        boolean status = false;
        int s = 0, e = matrix[0].length-1;
        int rowc = (s + e) / 2;
        while(s <= e && rowc > 0) {
            if(matrix[rowc][column] == target) {
                status = true;
                break;
            }

            if(matrix[rowc][column] < target) {
                s = rowc + 1;
            }
            else {
                e = rowc - 1;
            }

            rowc = (s + e) / 2;
        }

        return status;
    }

    private boolean bst_search_row(int[] arr, int target) {

        boolean status = false;
        int s = 0, e = arr.length-1;
        int colc = (s + e) / 2;
        while(s <= e && colc > 0) {
            if(arr[colc] == target) {
                status = true;
                break;
            }

            if(arr[colc] < target) {
                s = colc + 1;
            }
            else {
                e = colc - 1;
            }

            colc = (s + e) / 2;
        }

        return status;
    }

    public boolean search2D_1(int[][] matrix, int target, int sx, int sy, int ex, int ey) {

        if(sx > ex || sy > ey) {
            return false;
        }

        if(matrix[sx][sy] == target || matrix[ex][ey] == target) {
            return true;
        }

        if(matrix[sx][sy] > target || matrix[ex][ey] < target) {
            return false;
        }

        if(sx == sy && sy == ex && ex == ey) {
            return false;
        }

        int midX = (sx + ex) / 2;
        int midY = (sy + ey) / 2;

        int pivotX = 0, pivotY = 0;

        // 0, 3, 1, 4
        if(search2D_1(matrix, target, sx, sy, pivotX, sy+pivotY)) {
            return true;
        }

        // 2, 3, 2, 4
        // 0, 3, 1, 4
        if(search2D_1(matrix, target, sx, pivotY+1, pivotX, ey)) {
            return true;
        }

        if(search2D_1(matrix, target, pivotX+1, sy, ex, pivotY)) {
            return true;
        }

        if(search2D_1(matrix, target, pivotX+1, pivotY+1, ex, ey)) {
            return true;
        }

        return false;
    }
}
