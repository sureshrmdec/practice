package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Hashing_Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing_Equal o = new Hashing_Equal();
		Integer[] ina = {3, 4, 7, 1, 2, 9, 8};
		Integer[] ina2 = {9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(ina2));
		System.out.println(o.getEqual(input));

	}
	public ArrayList<Integer> getEqual(ArrayList<Integer> input){
		ArrayList<Integer> result = null;
		HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();


		for(int i=0;i<input.size();i++){
			for(int j=i+1;j<input.size();j++){
				int sum = input.get(i)+input.get(j);
				if(map.containsKey(sum)){
					ArrayList<ArrayList<Integer>> l = map.get(sum);
					for(ArrayList<Integer> ll: l){
						if(ll.contains(i) || ll.contains(j)){
							continue;
						}
						ArrayList<Integer>copy = new ArrayList<>(ll);
						copy.add(i);copy.add(j);
						if(result==null)
							result = copy;
						else{
							if(hasSmallerIndexes(result, copy)){
								result = copy;
							}
						}
					}
					
				}else{
					ArrayList<ArrayList<Integer>> l = new ArrayList<>();
					ArrayList<Integer> ll = new ArrayList<>();
					ll.add(i);ll.add(j);
					l.add(ll);
					map.put(sum, l);

				}
			}

		}
		
		return result;
	}

	public boolean hasSmallerIndexes(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) < l2.get(i)) {
                return false;
            }
            
            if (l2.get(i) < l1.get(i)) {
                return true;
            }
        }

        return false;
    }
}
