package leetcode;

public class RegexMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
	}

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    public static boolean isMatchHelper(char[] in, char[] re, int i, int g) {
    	if (i == in.length && g == re.length) return true;
    	if (g == re.length) return false;
    	
    	if (i < in.length && (in[i] == re[g] || re[g] == '.')) {
    		if (g+1 < re.length && re[g+1] == '*') {
    			return isMatchHelper(in, re, i+1, g) || isMatchHelper(in, re, i+1, g+2) || isMatchHelper(in, re, i, g+2);
    		} else {
    			return isMatchHelper(in, re, i+1, g+1);
    		}
    	} else if (g+1 < re.length && re[g+1] == '*') {
			return isMatchHelper(in, re, i, g+2);
    	} else {
        	return false;
    	}
    	
    }

}
