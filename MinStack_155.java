class Node {
    int val;
    Node next;
    int min;

    public Node(int _val, int _min) { 
        val = _val; 
        min = _min;
        next = null;
    }
}

class MinStack {
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        Node n = new Node(x, Math.min(x, head.min));
        n.next = head;
        head = n;
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}