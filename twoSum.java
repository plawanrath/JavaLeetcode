import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> indexMap = new HashMap<>();
       for(int i=0;i<nums.length;i++) {
           int complement = target - nums[i];
           if(indexMap.containsKey(complement)) {
               return new int[]{indexMap.get(complement), i};
           }
           indexMap.put(nums[i], i);
       }
       return new int[2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 3, 4};
        int sum = 6;
        int[] res = s.twoSum(arr, sum);
        for(int i=0;i<2;i++) {
            System.out.print(res[i] + " ");
        }
    }
}