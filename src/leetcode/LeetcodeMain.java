package leetcode;

public class LeetcodeMain {

	public static void main(String[] args) {
		
		String[] friends = new String[] {
				"YYNNY", 
				"YYNNN",
				"NNYNN",
				"NNNYY",
				"YNNYY"
		};
		int ans = friendCircles(friends);
		System.out.println(ans);
	}
	
    static int friendCircles(String[] friends) {
        int n = friends.length;
        //Optimization: One friend is a friend to themselves,
        //so we return 1
        if (n == 1) return 1;
        int friendCirclesAns = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (friends[i].charAt(j) == 'Y') {
                    friendCirclesAns++;
                    friendDFS(friends, n, i, j);
                }
            }
        }
        
        return friendCirclesAns;
    }

    static void friendDFS(String[] friends, int n, int i, int j){
        friends[i] = switchChar(friends[i], j);
        for (int jDFS = 0; jDFS < n; jDFS++) {
                if (friends[i].charAt(jDFS) == 'Y') {
                    friends[i] = switchChar(friends[i], jDFS);
                    friendDFS(friends, n, jDFS, jDFS);
                }
         }
    }

    static String switchChar(String friendsAtI, int j) {
        return friendsAtI.substring(0, j) + "V" + friendsAtI.substring(j+1);
    }

}
