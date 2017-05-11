package com.practice.algo.and.ds.bitmanipulation;

public class BitManipulation_NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitManipulation_NumberOf1Bits o = new BitManipulation_NumberOf1Bits();
		System.out.println(o.getBits(8));
		
	}
	public int getBits(long in){
		int result = 0;
		while(in>0){
			if((in & 1) > 0 ){
				result++;
			}
			in = in >> 1;
		}
		return result;
	}

}
