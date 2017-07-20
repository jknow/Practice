

public class FriendCircles {

	String[] extraTestfriends = new String[] {
			"YYNNY", 
			"YYNNN",
			"NNYNN",
			"NNNYY",
			"YNNYY"
	};
	
	static int friendCircles(String[] friends) {
        int n = friends.length;
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
        for (int jDFS = 0; jDFS < n; jDFS++) {						//Had this at j in a failed attempt at optimization
                if (friends[i].charAt(jDFS) == 'Y') {
                    friends[i] = switchChar(friends[i], jDFS);		//Lines 25 and 26 were swapped and caused a stackoverflow error
                    friendDFS(friends, n, jDFS, jDFS);
                }
         }
    }

    static String switchChar(String friendsAtI, int j) {
        return friendsAtI.substring(0, j) + "V" + friendsAtI.substring(j+1);
    }
}
