import java.util.*;

public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    Map<String, Integer> serial = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode node) {
        if(node == null) {
            return "#";
        }
        String item = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        serial.put(item, serial.getOrDefault(item, 0) + 1);
        if(serial.get(item) == 2) {
            res.add(node);
        }
        return item;
    }
}