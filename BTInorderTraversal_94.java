import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if(root != null) {
            if(root.left != null) {
                inorder(res, root.left);
            }
        }
        res.add(root.val);
        if(root != null) {
            if(root.right != null) {
                inorder(res, root.right);
            }
        }
    }

    private List<Integer> iterativeInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr  = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}