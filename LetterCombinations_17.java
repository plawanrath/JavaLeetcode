import java.util.*;

class LetterCombination {
    private static final HashMap<Character, Character[]> keypad;
    static 
    {
        keypad = new HashMap<>();
        keypad.put('2', new Character[]{'a', 'b', 'c'});
        keypad.put('3', new Character[]{'d', 'e', 'f'});
        keypad.put('4', new Character[]{'g', 'h', 'i'});
        keypad.put('5', new Character[]{'j', 'k', 'l'});
        keypad.put('6', new Character[]{'m', 'n', 'o'});
        keypad.put('7', new Character[]{'p', 'q', 'r', 's'});
        keypad.put('8', new Character[]{'t', 'u', 'v'});
        keypad.put('9', new Character[]{'w', 'x', 'y', 'z'});
    };
    public List<String> letterCombinations(String digits) {
        Queue<String> resQ = new LinkedList<String>();
        for(int i=0;i<digits.length();i++) {
            char c = digits.charAt(i);
            Character[] vals = keypad.get(c);
            if(resQ.isEmpty()) {
                for(int j=0;j<vals.length;j++) 
                    resQ.add(Character.toString(vals[j]));
            } else {
                while(resQ.peek().length() <= i) {
                    String s = resQ.poll();
                    for(int j=0;j<vals.length;j++) {
                        String temp = s + vals[j];
                        resQ.add(temp);                        
                    }
                }
            }
        }
        return (List<String>) resQ;
    }

    public static void main(String[] args) {
        LetterCombination lc = new LetterCombination();
        String test = "23";
        List<String> res = lc.letterCombinations(test);
        for(int i=0;i<res.size();i++)
            System.out.println(res.get(i));
    }
}