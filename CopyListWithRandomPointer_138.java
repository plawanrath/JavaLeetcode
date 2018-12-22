import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class Solution {
    Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        if(nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        }

        RandomListNode node = new RandomListNode(head.label);
        nodeMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}