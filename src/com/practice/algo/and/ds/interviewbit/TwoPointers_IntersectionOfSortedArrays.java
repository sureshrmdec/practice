package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_IntersectionOfSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ina = {10000000};
		Integer[] inb = {10000000};

		ArrayList<Integer> inA = new ArrayList<>(Arrays.asList(ina));
		ArrayList<Integer> inB = new ArrayList<>(Arrays.asList(inb));
		TwoPointers_IntersectionOfSortedArrays o = new TwoPointers_IntersectionOfSortedArrays();
		System.out.println(o.getIntersection(inA, inB));


	}

	public ArrayList<Integer> getIntersection(ArrayList<Integer> al1,ArrayList<Integer> al2){
		int i=0;
		int j=0;
		ArrayList<Integer> result = new ArrayList<>();
		while(i<al1.size() && j<al2.size()){
			if(al1.get(i).equals(al2.get(j))){
				result.add(al1.get(i));
				i++;
				j++;
				continue;
			}
			if(al1.get(i)<al2.get(j)){
				i++;
			}else if(al1.get(i)>al2.get(j)){
				j++;
			}
		}
		return result;
	}
}
