package com.practice.algo.and.ds.String;

import java.math.BigInteger;

public class Strings_Powerof2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_Powerof2 o = new Strings_Powerof2();
		System.out.println(o.power2("512"));
	}
	public int power(String a) {
		if(a.equals("1")){
			return 0;
		}
		BigInteger b = new BigInteger(a);
		while((b.and(BigInteger.ONE).compareTo(BigInteger.ZERO)==0 && b.compareTo(BigInteger.ONE)>0)){
			b=b.shiftRight(1);
		}
		if(b.compareTo(BigInteger.ONE)==0){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
public int power2(String A) {
	    String dividend = A;
	    StringBuilder str;
	    if (A == null || A.length() == 0)
	        return 0;
	    if (A.length() == 1 && A.charAt(0) == '0')
	        return 0;
	    while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
	        str = new StringBuilder();
	        int carry = 0;
	        int n = dividend.length();
	        if (n > 0) {
    	        int num = dividend.charAt(n - 1) - '0';
    	        if (num % 2 == 1)
    	            return 0;
	        }
	        for (int i = 0; i < n; i++) {
	            char c = dividend.charAt(i);
	            int res = c-'0' + 10 * carry;
	            c = (char) (res / 2 + '0');
	            carry = res % 2;
	            str.append(c);
	        }
	        if (str.charAt(0) == '0')
	            str.deleteCharAt(0);
	        dividend = str.toString();
	    }
	    return 1;
	    
	}
}
