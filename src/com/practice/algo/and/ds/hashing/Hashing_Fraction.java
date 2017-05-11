package com.practice.algo.and.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class Hashing_Fraction {

	public static void main(String[] args) {
		Hashing_Fraction o = new Hashing_Fraction();
		//System.out.println(o.fractionToDecimal(2147483647,37));
		//System.out.println(o.fractionToDecimal(-1,-2147483648));
		//System.out.println(o.fractionToDecimal(-50,-8));
		//System.out.println(o.fractionToDecimal(-50,8));
	//	System.out.println(o.fractionToDecimal(2,4));
	//	System.out.println(o.fractionToDecimal(1,6));
	//	System.out.println(o.fractionToDecimal(4,333));
	//	System.out.println(o.fractionToDecimal(4,8888));
		System.out.println(o.fractionToDecimal(4,999));

	}

	public String fractionToDecimal(int num, int den) {

		StringBuilder resB = new StringBuilder();
		if(num==0)
			return "0";

		// is result is negative
		if ((num < 0) ^ (den < 0)) {
			resB.append("-");
		}

		long numerator = num;
		long denominator = den;
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		// quotient 
		long res = numerator / denominator;
		resB.append(String.valueOf(res));

		// if remainder is 0, return result
		long remainder = (numerator % denominator) * 10;
		if (remainder == 0)
			return resB.toString();



		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		resB.append(".");
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String str = resB.toString();
				String part1 = str.substring(0, beg).concat("(").concat(str.substring(beg,resB.length())).concat(")");
				//String part2 = result.substring(beg, result.length());
				//result = part1 + "(" + part2 + ")";
				return part1;
			}
	 
			// continue
			map.put(remainder, resB.length());
			res = remainder / denominator;
			resB.append(String.valueOf(res));
			remainder = (remainder % denominator) * 10;
		}

		return resB.toString();
		
		

	}

}
