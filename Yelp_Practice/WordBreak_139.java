import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memory = new boolean[s.length()+1];
        memory[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(memory[j] && wordDict.contains(s.substring(j, i))) {
                    memory[i] = true;
                    break;
                }
            }
        }
        return memory[s.length()]; 
    }
}