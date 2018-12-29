import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    private void traverse(TreeNode curr, List<List<Integer>> solution, int level) {
        if(curr == null)
            return;
        
        if(solution.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            solution.add(newLevel);
        }

        List<Integer> collection = solution.get(level);
        if(level % 2  == 0)
            collection.add(curr.val);
        else 
            collection.add(0, curr.val);
        
        traverse(curr.left, solution, level + 1);
        traverse(curr.right, solution, level + 1);
    }
}