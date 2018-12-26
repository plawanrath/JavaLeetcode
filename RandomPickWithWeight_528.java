import java.util.*;

class Solution {

    List<Integer> psum = new ArrayList<>();
    int ceiling = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        for(int x : w) {
            ceiling += x;
            psum.add(ceiling);
        }
    }
    
    public int pickIndex() {
        int target = rand.nextInt(ceiling);

        int lo = 0;
        int high = psum.size() - 1;
        while(low != high) {
            int mid = (lo + high)/2;
            if(target >= psum.get(mid))
                lo = mid + 1;
            else
                high = mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */