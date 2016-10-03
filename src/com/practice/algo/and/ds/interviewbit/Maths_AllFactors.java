package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Maths_AllFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_AllFactors o = new Maths_AllFactors();
		o.allFactors(48);
	}
	public ArrayList<Integer> allFactors(int a) {
		Set<Integer> s = new TreeSet<>();
	
		for(int i=1;i<=a;i++){
			if(a%i==0){
				if(!s.add(i))
					break;
				s.add(i);
				s.add(a/i);
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		al.addAll(s);
		return al;
		
	}
}
