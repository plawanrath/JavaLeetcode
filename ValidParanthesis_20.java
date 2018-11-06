import java.util.*;

class ValudParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char popped = stack.pop();
                switch(c) {
                    case ')': 
                    if(popped != '(') {
                        return false;
                    }
                    break;
                    case '}':
                    if(popped != '{') {
                        return false;
                    }
                    break;
                    case ']':
                    if(popped != '[') {
                        return false;
                    }
                    break;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }    
}