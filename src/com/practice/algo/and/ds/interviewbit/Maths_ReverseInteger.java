package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Maths_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_ReverseInteger m = new Maths_ReverseInteger();
		System.out.println(m.reverse(-1146467285));//-1146467285
	}
	
	//https://discuss.leetcode.com/topic/6104/my-accepted-15-lines-of-code-for-java
	public int reverse(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}
