package com.practice.algo.and.ds.maths;

public class ReverseaNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	public int reverse(int a) {

		int reversedNum = 0;
		while (a != 0) {
			if (reversedNum != 0 && Integer.MAX_VALUE / reversedNum < 10
					&& Integer.MAX_VALUE / reversedNum > -10)
				return 0;
			reversedNum = reversedNum * 10 + a % 10;
			a = a / 10;   
		}
		return reversedNum;
	}
}
