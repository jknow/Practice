import java.util.PriorityQueue;

public class SegmentSort {
	
	public static String sortSegment(String seg) {
		
		char[] segArr = seg.toCharArray();
		
		boolean isCurrDigit = Character.isDigit(segArr[0]);
		PriorityQueue<Character> q = new PriorityQueue<>(); 
		
		for (int i = 0; i < segArr.length; i++) {
			if (Character.isDigit(segArr[i]) != isCurrDigit) {
				while (!q.isEmpty()) {
					segArr[i-q.size()] = q.poll();
				}
				isCurrDigit = Character.isDigit(segArr[i]);
			}
			q.add(segArr[i]);
		}
		while (!q.isEmpty()) {
			segArr[segArr.length-q.size()] = q.poll();
		}
		
		return new String(segArr);
	}

	public static void main(String[] args) {
		String in = "AZQF013452BAB";
		String out = sortSegment(in);
		System.out.println(out);
	}

}
