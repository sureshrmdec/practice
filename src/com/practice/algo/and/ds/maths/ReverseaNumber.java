package com.practice.algo.and.ds.maths;

public class ReverseaNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 54321;
		int reversedNum = 0;
		while (input != 0) {
		    reversedNum = reversedNum * 10 + input % 10;
		    input = input / 10;   
		}
		
		System.out.println(reversedNum);
	}

}
