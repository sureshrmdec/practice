package com.practice.algo.and.ds.backtracking;

import java.util.HashMap;
import java.util.Map;

public class BackTracking_LeetCode_CanIWin {

	public static void main(String[] args) {
		BackTracking_LeetCode_CanIWin o = new BackTracking_LeetCode_CanIWin();
		System.out.println(o.canIWin2(10, 14));

	}
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
		if(sum < desiredTotal) return false;
		if(desiredTotal <= 0) return true;

		boolean[] nums = new boolean[maxChoosableInteger];
		return canIWinHelper(nums,desiredTotal); 
	}
	private boolean canIWinHelper(boolean[] nums,int currentSum) {
		if(currentSum<=0)
			return false;
		for(int i=0;i<nums.length;i++){
			if(!nums[i]){
				nums[i]= true;

				if(!canIWinHelper(nums, currentSum-(i+1))){
					nums[i] = false;
					return true;
				}
				nums[i] = false;
			}
		}
		return false;

	}








	Map<Integer, Boolean> map;
	boolean[] used;
	public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
		int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
		if(sum < desiredTotal) return false;
		if(desiredTotal <= 0) return true;

		map = new HashMap();
		used = new boolean[maxChoosableInteger+1];
		return helper(desiredTotal);
	}

	public boolean helper(int desiredTotal){
		if(desiredTotal <= 0) 
			return false;
		int key = format(used);
		System.out.println(key);
		if(!map.containsKey(key)){
			// try every unchosen number as next step
			for(int i=1; i<used.length; i++){
				if(!used[i]){
					used[i] = true;
					// check whether this lead to a win (i.e. the other player lose)
					if(!helper(desiredTotal-i)){
						map.put(key, true);
						used[i] = false;
						return true;
					}
					used[i] = false;
				}
			}
			map.put(key, false);
		}
		System.out.println(key +" " +map.get(key));
		return map.get(key);

	}

	// transfer boolean[] to an Integer 
	public int format(boolean[] used){
		int num = 0;
		for(boolean b: used){
			num <<= 1;
			if(b) num |= 1;
		}
		return num;
	}






}
