package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 2) return nums;
        int[] ans = new int[nums.length-k+1];
        
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());
        
        int i = 0;
        for (; i < k; i++) {
            q.add(nums[i]);
        }
        ans[0] = q.peek();
        
        for (; i < nums.length; i++) {
        	q.remove(nums[i-k]);
            q.add(nums[i]);
            ans[i-k+1] = q.peek();
        }

        return ans;
    }
}
