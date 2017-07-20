package leetcode;

public class LongestPalindrome {
	

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2 || (n == 2 && s.charAt(0) == s.charAt(1))) return s;
        String ans = "";
        
        for (int i = 0; i+1 < n; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                ans = palinOut(s, i, 1, ans);
            }
            if (i+2 < n && s.charAt(i) == s.charAt(i+2)) {
                ans = palinOut(s, i, 2, ans);
            }
        }
        return ans.length() == 0 ? s.substring(0, 1) : ans;
    }
    
    private static String palinOut (String s, int i, int offset, String answer) {
        int j = 0;
        while (i-j >= 0 && i+offset+j < s.length() && s.charAt(i-j) == s.charAt(i+offset+j)) {
            j++;
        }
        j--;
        if (offset+j*2+1 > answer.length()) {
        	answer = s.substring(i-j, i+offset+j+1);
        }
        
        return answer;
    }

}
