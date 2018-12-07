import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++) 
            map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for(int i=0;i<list2.length && i <= min_sum; i++) {
            if(map.containsKey(list2[i])) {
                sum = i + map.get(list2[i]);
                if(sum < min_sum) {
                    res.clear();
                    res.add(list2[i]);
                    min_sum = sum;
                } else if(sum == min_sum) 
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}