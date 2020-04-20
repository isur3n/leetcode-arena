package me.suren.leetcodearena.recursion;

import me.suren.leetcodearena.recursion.model.TreeNode;
import me.suren.leetcodearena.util.BstUtil;

import java.util.LinkedList;
import java.util.List;

public class UniqueBstList {

    public static void main(String[] args) {
        UniqueBstList u = new UniqueBstList();
        List<TreeNode> treeList = u.generateTrees(3);
        for (TreeNode tree : treeList) {
            BstUtil.print(tree);
            System.out.println("<end>");
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            LinkedList<TreeNode> ans = new LinkedList<>();
            return ans;
        }
        return generateTrees(1,n);
    }

    public LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        if(start > end) {
            ans.add(null);
            return ans;
        }
        for(int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftAns = generateTrees(start,i-1);
            LinkedList<TreeNode> rightAns = generateTrees(i+1,end);
            save(i,leftAns,rightAns,ans);
        }
        return ans;
    }

    public void save(int root, LinkedList<TreeNode> left, LinkedList<TreeNode> right, LinkedList<TreeNode> ans) {
        for(int i = 0; i < left.size(); i++) {
            for(int j = 0; j < right.size(); j++) {
                TreeNode root_node = new TreeNode(root);
                root_node.left = left.get(i);
                root_node.right = right.get(j);
                ans.add(root_node);
            }
        }
    }

/*    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        HashMap<String, List<TreeNode>> mp = new HashMap();
        return findUniquePairs(1, n, mp);
    }

    public List<TreeNode> findUniquePairs(int start, int end, HashMap<String, List<TreeNode>> mp) {
        List l = new ArrayList<>();
        if (start > end) {
            l.add(null);
            return l;
        }

        String key = start + "_" + end;
        if (mp.containsKey(key)) return mp.get(key);
        if (start == end) {
            TreeNode t = new TreeNode(start);
            l.add(t);
            return l;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNode = findUniquePairs(start, i - 1, mp);
            List<TreeNode> rightNode = findUniquePairs(i + 1, end, mp);

            for (TreeNode ls : leftNode) {
                for (TreeNode rs : rightNode) {
                    TreeNode t = new TreeNode(i);
                    t.left = ls;
                    t.right = rs;
                    l.add(t);
                }
            }
        }
        mp.put(key, l);
        return l;
    }*/
}