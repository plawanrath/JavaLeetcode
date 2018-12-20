import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()) {
            String str = queue.poll();

            if(str != null) {
                for(int i=0;i<str.length();i++) {
                    char[] chars = str.toCharArray();

                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String wrd = new String(chars);
                        if(wrd.equals(endWord) && wordDict.contains(wrd))
                            return level + 1;
                        if(wordDict.contains(wrd) && !visited.contains(wrd)) {
                            queue.add(wrd);
                            visited.add(wrd);
                        }
                    }
                }
            } else {
                level++;
                if(!queue.isEmpty()) {
                    queue.add(null);
                }                
            }
        }
        return 0;
    }
}