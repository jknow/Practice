package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {
	private HashSet<Integer> randSet;
	private ArrayList<Integer> randList;
	Random ran;

	public RandomizedSet() {
		this.randSet = new HashSet<>();
		this.randList = new ArrayList<>();
		this.ran = new Random();
	}
	
	public boolean insert(int val) {
		if (this.randSet.add(val)) {
			this.randList.add(val);
			return true;
		}
		return false;
	}
	
	public boolean remove(int val) {
		if (this.randSet.remove(val)) {
			this.randList.remove((Integer) val);
			return true;
		}
		return false;
	}
	
	public int getRandom() {
		int i = this.ran.nextInt(this.randSet.size());
		return this.randList.get(i);
	}
	
}
