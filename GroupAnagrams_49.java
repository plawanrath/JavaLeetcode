import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = String.valueOf(carr);
            if(!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<String>());
            }
            List<String> valList = anagramMap.get(key);
            valList.add(str);
            anagramMap.put(key, valList);
        }
        Iterator it = anagramMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, List<String>> pair = (Map.Entry<String, List<String>>)it.next();
            res.add(pair.getValue());
        }
        return res;
    }  
    
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
}