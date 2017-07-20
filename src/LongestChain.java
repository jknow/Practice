

public class LongestChain {
    static int longestChain(String[] words) {
        int n = words.length;
        int runningMax = 0;
        int[] chainAtI = new int[n];
        
        //initializes all words as one chain link
/*        for (int i = 0; i < n; i++) {
            chainAtI[i] = 1;
        }*/
        
        for (int i = 0; i < n; i++) {
            int iSize = words[i].length();
            for (int j = 0; j < iSize; j++) {
                String minusOneChar = removeChar(words[i], j);
                for (int k = 0; k < n; k++) {
                    if (minusOneChar.equals(words[k])) {
                        chainAtI[i] = Math.max(chainAtI[i], chainAtI[k] + 1);
                    }
                }
            }
            runningMax = Math.max(runningMax, chainAtI[i]);
        }
        return runningMax+1;
    }

    static String removeChar(String word, int j) {
        return word.substring(0, j) + word.substring(j+1);
    }
}
