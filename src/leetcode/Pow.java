package leetcode;

public class Pow {
	
    public static double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans = ans * x;
            }
            absN = absN >> 1;
            x = x * x;
        }
        
        return n < 0 ? 1/ans : ans;
    }

	public static void main(String[] args) {
		myPow(7, 5);
	}

}
