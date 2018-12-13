import java.util.*;

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for(String[] pair : tickets) {
            targets.computeIfAbsent(pair[0], k -> new PriorityQueue<String>()).add(pair[1]);
        }
        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String src = stack.peek();
            while(targets.containsKey(src) && !targets.get(src).isEmpty()) {
                stack.push(targets.get(src).poll());
                src = stack.peek();
            }
            route.add(0, stack.pop());
        }
        return route;
    }
}