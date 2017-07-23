package leetcode;

public class RegexMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
	}

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        char[] in = s.toCharArray();
        int inLen = in.length;
        char[] re = p.toCharArray();
        int reLen = re.length;
        boolean ans = false;
        
        int g = 0;
        for (int i = 0; i < reLen; i++) {
            if (in[i] == re[g] || re[g] == '.') {
                if (g+1 < reLen && re[g] == '*') {
                    while (in[i] == re[g] || re[g] == '.') {
                        
                    }
                }
            }
            if (in[i] != re[g]) {
                if (g+1 < reLen && re[g] == '*') {
                    g++;
                }
            }
        }
        
        return ans;
    }

}
