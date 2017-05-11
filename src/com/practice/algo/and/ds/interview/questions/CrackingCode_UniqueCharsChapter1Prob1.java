package com.practice.algo.and.ds.interview.questions;

public class CrackingCode_UniqueCharsChapter1Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrackingCode_UniqueCharsChapter1Prob1 o = new CrackingCode_UniqueCharsChapter1Prob1();
		System.out.println(o.isUnique("abca"));
	}
//Without using extra memory
	public boolean isUnique(String a){
		int bitMask = 0;
		
		for(Character c:a.toCharArray()){
			int ac = c-'a';
			int current = 1 << ac;
			if((bitMask & current) >0){
				return false;
			}else{
				bitMask = bitMask | current;
			}
		}
		return true;
	}
}
