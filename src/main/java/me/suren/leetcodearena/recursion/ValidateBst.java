package me.suren.leetcodearena.recursion;

import me.suren.leetcodearena.recursion.model.TreeNode;

public class ValidateBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBst v = new ValidateBst();
        System.out.println(v.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        if( isValidBST(root.left) && isValidBST(root.right)) {
            return isValidLeftBst(root.left, root.val)
                    && isValidRightBst(root.right, root.val);
        }
        else {
            return false;
        }
    }

    public boolean isValidLeftBst(TreeNode root, int val) {
        if(root == null) return true;

        if(root.val >= val) return false;
        if(isValidLeftBst(root.left, val) && isValidLeftBst(root.right, val))
            return true;
        else
            return false;
    }

    public boolean isValidRightBst(TreeNode root, int val) {
        if(root == null) return true;

        if(root.val <= val) return false;
        if(isValidRightBst(root.left, val) && isValidRightBst(root.right, val))
            return true;
        else
            return false;
    }
}
