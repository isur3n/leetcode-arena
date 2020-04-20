package me.suren.leetcodearena.util;

import me.suren.leetcodearena.recursion.model.TreeNode;

public class BstUtil {

    private BstUtil() {}

    public static void print(TreeNode node) {
        printInOrder(node);
    }

    public static void printInOrder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.val + " -> ");
        printInOrder(node.left);
        printInOrder(node.right);
    }

    public static void printPreOrder(TreeNode node) {
        if(node == null) return;

        printPreOrder(node.left);
        System.out.print(node.val + " -> ");
        printPreOrder(node.right);
    }

    public static void printPostOrder(TreeNode node) {
        if(node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + " -> ");
    }
}
