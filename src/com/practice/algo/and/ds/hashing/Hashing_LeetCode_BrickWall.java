package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashing_LeetCode_BrickWall {

	public static void main(String[] args) {
		Integer[][] walls = {{1,2,2,1},
				{3,1,2},
				{1,3,2},
				{2,4},
				{3,1,2},
				{1,3,1,1}};
		List<List<Integer>> wall = new ArrayList<>();
		for(Integer[] a:walls){
			wall.add(new ArrayList<>(Arrays.asList(a)));
		}
		Hashing_LeetCode_BrickWall o = new Hashing_LeetCode_BrickWall();
		System.out.println(o.leastBricks(wall));

	}
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer,Integer> map = new HashMap<>();
		for(List<Integer> w:wall){
			int sumSoFar = 0;
			for(Integer i:w){
				sumSoFar+=i;
				if(map.containsKey(sumSoFar)){
					map.put(sumSoFar, map.get(sumSoFar)+1);
				}else{
					map.put(sumSoFar, 1);
				}
			}
		}

		ArrayList<Integer> l = new ArrayList<>(map.values());
		Collections.sort(l);
		if(l.size()==1)
			return wall.size();

		return l.get(l.size()-1)-l.get(l.size()-2);
	}
}
