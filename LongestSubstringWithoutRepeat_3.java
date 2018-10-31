import java.util.HashSet;

//Given a string, find the length of the longest substring without repeating characters.
class LongestSubstringWithoutRepeat_3 {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, maxlen = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length() && i < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxlen = Math.max(maxlen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat_3 l = new LongestSubstringWithoutRepeat_3();
        String s = "dvdf";
        int res = l.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}