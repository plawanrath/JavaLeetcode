class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        int l = left, r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        String s = "babad";
        String res = lps.longestPalindrome(s);
        System.out.println(res);    
    }
}