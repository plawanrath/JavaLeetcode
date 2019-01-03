/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightMostValAndDepth = new HashMap<>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if(node != null) {
                max_depth = Math.max(depth, max_depth);
                if(!rightMostValAndDepth.containsKey(depth)) {
                    rightMostValAndDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for(int depth = 0;depth<max_depth;depth++)
            rightView.add(rightMostValAndDepth.get(depth));
        return rightView;        
    }
}