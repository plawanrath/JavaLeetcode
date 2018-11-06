import java.util.*;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String curr, int open, int close, int max) {
        if(curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        if(open < max) {
            backtrack(res, curr.concat("("), open + 1, close, max);
        }
        if(close < open) {
            backtrack(res, curr.concat(")"), open, close + 1, max);
        }
    }
}