package leetcode;

public class RegexMatching {

	public static void main(String[] args) {
		boolean result = true;
		result &= isMatch("aa","a") == false;
		System.out.println(result);
		result &= isMatch("aa","aa") == true;
		System.out.println(result);
		result &= isMatch("aaa","aa") == false;
		System.out.println(result);
		result &= isMatch("aa", "a*") == true;
		System.out.println(result);
		result &= isMatch("aa", ".*") == true;
		System.out.println(result);
		result &= isMatch("ab", ".*") == true;
		System.out.println(result);
		result &= isMatch("aab", "c*a*b") == true;
		System.out.println(result);
		result &= isMatch("aab", "c*.*a*b.*") == true;
		System.out.println(result);
		result &= isMatch("aab", "c*.*a*bc") == false;
		System.out.println(result);
		result &= isMatch("ab", ".*c") == false;
		System.out.println(result);
		result &= isMatch("aaa", "a*a") == true;
		System.out.println(result);
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
    
    public boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

}
