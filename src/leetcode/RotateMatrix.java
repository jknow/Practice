package leetcode;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
       if (matrix.length == 0 || matrix.length == 1) return ;
        int size = matrix.length;
        
        for (int i = 0; i < size/2; i++) {
            int first = i;
            int last = size - 1 - i;
            for (int j = i; j < last; j++) {
                int offset = j - first;
                int temp 					= matrix[first][j];
                matrix[first][j]            = matrix[last-offset][first];
                matrix[last-offset][first]  = matrix[last][last-offset];
                matrix[last][last-offset]   = matrix[j][last];
                matrix[j][last]             = temp;
            }
        }
    }

}
