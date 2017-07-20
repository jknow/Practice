package leetcode;

import java.util.Arrays;

public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length-1;
        System.out.println(Arrays.toString(nums));
        while (lo < hi) {
            int p = pivoter(nums, lo, hi);
            if (p > k) hi = p-1;
            else if (p < k) lo = p+1;
            else return nums[k];
        }
        return nums[k];
    }
    
    private static int pivoter(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int iLo = lo;
        int iHi = hi+1;
        
        while (true) {
            while (nums[++iLo] < pivot) if (iLo == hi) break;
            while (nums[--iHi] > pivot) if (iHi == lo) break;
            if (iLo >= iHi) break;
            int temp = nums[iLo];
            nums[iLo] = nums[iHi];
            nums[iHi] = temp;
            System.out.println(Arrays.toString(nums));
        }
        
        int temp = nums[lo];
        nums[lo] = nums[iHi];
        nums[iHi] = temp;
            System.out.println(Arrays.toString(nums));
        
        return iHi;
    }

}
