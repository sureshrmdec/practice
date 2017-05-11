package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BitManipulation_DifferentBitsSumPairwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {65, 79, 94, 5, 65, 73, 15, 20, 20};
		BitManipulation_DifferentBitsSumPairwise o = new BitManipulation_DifferentBitsSumPairwise();
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(a));
		System.out.println(o.getSum(in));
	}

	public int getSum(ArrayList<Integer> in){

		final int MOD = 1000000007; 
		BigInteger result = BigInteger.ZERO;


		for(int i=0; i<31; i++){
			int ones = 0;
			for(int j=0;j<in.size();j++){
				if((in.get(j)&(1<<i)) > 0){
					ones +=1;
				}
				
			}
			int zeroes = in.size() - ones;
			result = result.add(BigInteger.valueOf(ones*zeroes)).mod(BigInteger.valueOf(MOD));
		}


		return result.multiply(BigInteger.valueOf(2)).intValue();

	}
}
