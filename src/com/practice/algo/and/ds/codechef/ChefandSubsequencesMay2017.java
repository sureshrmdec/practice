package com.practice.algo.and.ds.codechef;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//123
//1 12 123 2 23 3
class ChefandSubsequencesMay2017 {

	public static void main(String[] args) {
		new ChefandSubsequencesMay2017().subSets();
		new ChefandSubsequencesMay2017().subSetsMap();
	}

	public void subSetsMap(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long[] nums = new long[n];
		for(int i = 0;i<n;i++){
			nums[i] = sc.nextLong();
		}
		Map<Long,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			Set<Long> set = map.keySet();
			Iterator<Long> it = set.iterator();
			while(it.hasNext()){
				long key = it.next();
				long newKey = nums[i]*key;
				if(newKey<k){
					if(map.containsKey(newKey)){
						map.put(newKey, map.get(newKey)+1);
					}else{
						map.put(newKey, 1);
					}
				}
			}
			if(nums[i]<k){
				if(map.containsKey(nums[i])){
					map.put(nums[i], map.get(nums[i])+1);
				}else{
					map.put(nums[i], 1);
				}
			}
		}
		int result = 0;
		for(int i =1;i<=k;i++){
			result+=map.get(i);
		}
		System.out.println(result);
	}


	public void subSets(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long[] nums = new long[n];
		for(int i = 0;i<n;i++){
			nums[i] = sc.nextLong();
		}

		int max = (1 << (n)) - 1;

		int result = 0;
		for(int i=1;i<=max;i++){
			int ii = i;
			long mul = 1;
			int index = n-1;
			while(ii>0){
				if((ii&1)>0){
					mul = mul*nums[index];
				}
				if(mul>k){
					break;
				}
				ii = ii >> 1;
				index--;
			}
			if(mul<=k){
				result++;
			}

		}
		System.out.println(result);
	}
}
