import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(s));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        if(q.isEmpty()) 
            return null;
        if(q.peek().equals("#")) {
            q.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(q.poll()));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}