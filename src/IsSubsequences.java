import java.io.*;

public class IsSubsequences {
	  public static void main(String[] args) throws IOException {
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    String s;
		    while ((s = in.readLine()) != null) {
		      String[] input = s.split(",");
		      System.out.println(subsequenceCount(input[0], input[1]));
		    }
		  }
		  
		  public static int subsequenceCount(String seq, String sub) {
		      int seqLen = seq.length();
		      int subLen = sub.length();
		      int[][] matrix = new int[subLen+1][seqLen+1];
		      
		      for (int i = 0; i <= seqLen; i++) {
		          matrix[0][i] = 1;
		      }
		      
		      for (int i = 0; i < subLen; i++) {
		          for (int j = 0; j < seqLen; j++) {
		              if (seq.charAt(j) == sub.charAt(i)) {
		                  matrix[i+1][j+1] = matrix[i][j] + matrix[i+1][j];
		              } else {
		                  matrix[i+1][j+1] = matrix[i+1][j];
		              }
		          }
		      }
		      return matrix[subLen][seqLen];
		  }

}
