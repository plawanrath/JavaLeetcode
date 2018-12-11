import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resList = new HashSet<>();
        for(int item : nums1)
            set.add(item);
        for(int item : nums2) {
            if(set.contains(item))
                resList.add(item);
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}