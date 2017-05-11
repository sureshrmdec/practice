package com.practice.algo.and.ds.String;

import java.math.BigInteger;

public class Strings_Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE %10;
		Strings_Atoi o = new Strings_Atoi();
		System.out.println(o.myAtoi(" +745 455"));
	}

	//I will using this one as this uses total as int.
	//https://discuss.leetcode.com/topic/12473/java-solution-with-4-steps-explanations/2

	/*Overflow explanation: Integer.MAX_VALUE = 2147483647 and Integer.MIN_VALUE = -2147483648 is the largest/smallest value that an int primitive can contain.
	Let's simplify this problem. Suppose str1 = " -a649b ", st2 = " a652b ", max = 647, min = -648. So if atoi(str) > 647 || atoi(str) < -648 
	atoi will overflow. In other words, when we've parsed num == 64 and the next char is also digit, max / min 
	can directly be returned if the next digit >= 8; or we've parsed num > 64, directly return too.
	 */			
	public int myAtoi(String str) {
		int index = 0, sign = 1, total = 0;
		//1. Empty string
		if(str.length() == 0) return 0;

		//2. Remove Spaces
		while(str.charAt(index) == ' ' && index < str.length())
			index ++;

		//3. Handle signs
		if(str.charAt(index) == '+' || str.charAt(index) == '-'){
			sign = str.charAt(index) == '+' ? 1 : -1;
			index ++;
		}

		//4. Convert number and avoid overflow
		while(index < str.length()){
			int digit = str.charAt(index) - '0';
			if(digit < 0 || digit > 9) break;

			//check if total will be overflow after 10 times and add digit
			if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			index ++;
		}
		return total * sign;
	}

	public static int myAtoiLong(String str) {
		if (str == null || str.length() == 0)
			return 0;//
		str = str.trim();
		char firstChar = str.charAt(0);
		int sign = 1, start = 0, len = str.length();
		long sum = 0;
		if (firstChar == '+') {
			sign = 1;
			start++;
		} else if (firstChar == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < len; i++) {
			if (!Character.isDigit(str.charAt(i)))
				return (int) sum * sign;
			sum = sum * 10 + str.charAt(i) - '0';
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}
}
