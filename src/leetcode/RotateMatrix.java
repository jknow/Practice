package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
        List<Integer> ans = new ArrayList<Integer>(matrix.length*matrix[0].length);
        
        int iTop = 0;
        int iBottom = matrix.length-1;
        int jLeft = 0;
        int jRight = matrix[0].length-1;
        while (iTop <= iBottom && jLeft <= jRight) {
            
            for (int j = jLeft; j <= jRight; j++) ans.add(matrix[iTop][j]);
            
            iTop++;
            
            for (int i = iTop; i <= iBottom; i++) ans.add(matrix[i][jRight]);
            
            if (iTop > iBottom) break;
            jRight--;
            
            for (int j = jRight; j >= jLeft; j--) {
                ans.add(matrix[iBottom][j]);
            }
            
            if (jLeft > jRight) break;
            iBottom--;
            
            for (int i = iBottom; i >= iTop; i--) {
                ans.add(matrix[i][jLeft]);
            }
            
            jLeft++;
        }
        
        return ans;
    }

    public static void rotateCTCI(int[][] matrix) {
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
