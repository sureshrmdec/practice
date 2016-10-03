package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arrays_WaveArray {

	public static void main(String[] args) {
		
		Integer[] aa = { 5 ,1, 3 ,2 ,4};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(aa));
		Arrays_WaveArray o = new Arrays_WaveArray();
		System.out.println(o.wave(in));
		
	}
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		ArrayList<Integer> res = new ArrayList<>();
		Collections.sort(a);
		for(int i=1;i<a.size();i=i+2){
			int t = a.get(i-1);
			a.set(i-1, a.get(i));
			a.set(i, t);
		}
		return a;
	}

}
