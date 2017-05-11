package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hashing_EqualRevisited {

	public static void main(String[] args) {
		Hashing_EqualRevisited o = new Hashing_EqualRevisited();
		Integer[] ina = {3, 4, 7, 1, 2, 9, 8};
		Integer[] ina2 = {9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(ina2));
		System.out.println(o.getEqual(input));


	}
	public ArrayList<Integer> getEqual(ArrayList<Integer> input){
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<input.size()-3;i++){
			int a = input.get(i);
			for(int j=i+1;j<input.size()-2;j++){
				int b = input.get(j);
				int sum = a+b;
				for(int k=j+1;k<input.size();k++){
					int kk = input.get(k);
					if(map.containsKey(kk)){
						result.add(i);
						result.add(j);
						result.add(map.get(kk));
						result.add(k);
						return result;
					}else{
						map.put(sum-kk, k);
					}
				}
			}	
		}
		return result;
	}

}
