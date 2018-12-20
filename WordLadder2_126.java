import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordDict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>(); //neighbors of every node
        HashMap<String, Integer> distance = new HashMap<>(); //distance of every node from start

        ArrayList<String> resItem = new ArrayList<>();
        wordDict.add(beginWord);
        bfs(beginWord, endWord, wordDict, nodeNeighbors, distance);
        dfs(beginWord, endWord, wordDict, nodeNeighbors, distance, resItem , res);
        return res;
    }

    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for(String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distance.put(start, 0);

        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for(int i=0;i<count;i++) {
                String curr = queue.poll();
                int curDist = distance.get(curr);
                ArrayList<String> neighbors = getNeighbors(curr, dict);
                for(String neighbor : neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDist + 1);
                        if(end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if(foundEnd)
                break;
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i=0;i<chs.length;i++) {
                if(chs[i] == c) continue;
                char old_ch = chs[i];
                chs[i] = c;
                if(dict.contains(String.valueOf(chs)))
                    res.add(String.valueOf(chs));
                chs[i] = old_ch;
            }
        }
        return res;
    }

    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if(end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for(String next : nodeNeighbors.get(cur)) {
                if(distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}