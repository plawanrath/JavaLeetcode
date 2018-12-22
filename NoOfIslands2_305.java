import java.util.*;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> landid = new HashMap<>();
        int num_islands = 0;
        int island_id = 0;
        for(int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            Set<Integer> overlap = new HashSet<>();
            if(r-1 >= 0 && landid.containsKey((r-1) * n + c)) {
                overlap.add(landid.get((r-1) * n + c));
            }
            if(r+1 < m && landid.containsKey((r+1) * n + c)) {
                overlap.add(landid.get((r+1) * n + c));
            }
            if(c-1 >= 0 && landid.containsKey(r * n + (c-1))) {
                overlap.add(landid.get(r * n + (c - 1)));
            }
            if(c+1 < n && landid.containsKey(r * n + c + 1)) {
                overlap.add(landid.get(r * n + c + 1));
            }

            if(overlap.isEmpty()) {
                num_islands++;
                landid.put(r * n + c, island_id++);
            } else if(overlap.size() == 1) {
                landid.put(r * n + c, overlap.iterator().next());
            } else {
                int root_id = overlap.iterator().next();
                for(Map.Entry<Integer, Integer> entry : landid.entrySet()) {
                    int k = entry.getKey();
                    int id = entry.getValue();
                    if(overlap.contains(id)) {
                        landid.put(k, root_id);
                    }
                }
                landid.put(r * n + c, root_id);
                num_islands -= (overlap.size() - 1);
            }
            res.add(num_islands);
        }
        return res;
    }
}