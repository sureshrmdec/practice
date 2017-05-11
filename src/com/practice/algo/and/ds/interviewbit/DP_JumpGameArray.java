package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DP_JumpGameArray {
	public static void main(String[] args) {
		DP_JumpGameArray o = new DP_JumpGameArray();
		Integer[] aa = {3,3,0,2,1,2,2};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(aa));
		System.out.println(o.canJumpF(a));
	}

	public int canJump(ArrayList<Integer> A) {
		int n;
		int dp[];

		n = A.size();
		dp = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = A.get(0);

		for (int i = 1; i < n; i++) {
			if (dp[i - 1] >= i)
				dp[i] = Math.max(dp[i - 1], i + A.get(i));
		}

		for (int i = 0; i < n; i++) {
			if (dp[i] >= n - 1)
				return 1;
		}

		return 0;

	}

	//copied from programcreek.com
	//http://www.programcreek.com/2014/06/leetcode-jump-game-ii-java/
	public int canJumpF(ArrayList<Integer> a) {
		if (a == null || a.size() == 0)
			return 0;

		int lastReach = 0;
		int reach = 0;
		int step = 0;

		for (int i = 0; i <= reach && i < a.size(); i++) {
			//when last jump can not read current i, increase the step by 1
			if (i > lastReach) {
				step++;
				lastReach = reach;
			}
			//update the maximal jump 
			reach = Math.max(reach, a.get(i) + i);
		}

		//if can not reach
		if (reach < a.size() - 1)
			return 0;

		return step;
		
	}

	//Array Version
	public int jump(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int maxReach = a[0];
		int maxLastReach = a[0];
		int jumps = 1;
		for(int i=0;i<a.length;i++){
			if(i>maxLastReach){
				maxLastReach = maxReach;
				jumps++;
			}
			if(maxReach<i+a[i]){
				maxReach = i+a[i];
			}
			
		}
		return jumps;
	}
	//ArrayList version
	public int jump(ArrayList<Integer> a) {
		if (a == null || a.size() == 0 || (a.get(0)==0 && a.size()>1))
		    return -1;
		if(a.size() == 1)
			return 0;
		int maxReach = a.get(0);
		int maxLastReach = a.get(0);
		int jumps = 1;
		for(int i=0;i<a.size();i++){
			if(i>maxLastReach){
				if(maxReach<i)
					return -1;
				maxLastReach = maxReach;
				jumps++;
			}
			if(maxReach<i+a.get(i)){
				maxReach = i+a.get(i);
			}
			
		}
		return jumps;
	}
}
