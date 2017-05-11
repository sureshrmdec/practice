package com.practice.algo.and.ds.String;

import java.math.BigInteger;

public class Strings_CompareVersionNumbers {

	public static void main(String[] args) {
		Strings_CompareVersionNumbers o = new Strings_CompareVersionNumbers();
		System.out.println(o.compareVersion2("12.02","1.2"));

	}
	public int compareVersion(String a, String b) {
		String[] aa = a.split("\\.");
		String[] ba = b.split("\\.");
		
		int l = (aa.length>ba.length)?ba.length:aa.length;
		int i=0;
		for(i=0;i<l;i++){
			BigInteger ai = new BigInteger(aa[i]);
			BigInteger bi = new BigInteger(ba[i]);
			if(ai.compareTo(bi)>0){
				return 1;
			}else if(bi.compareTo(ai)>0){
				return -1;
			}
		}
		if(aa.length!=ba.length){
			if(aa.length>ba.length){
				for(int j=i-1;j<aa.length-1;j++){
					BigInteger ai = new BigInteger(aa[j+1]);
					if(ai.equals(BigInteger.ZERO)){
						continue;
					}else{
						return 1;
					}
					
				}
			}else{
				for(int j=i-1;j<ba.length-1;j++){
					BigInteger ai = new BigInteger(ba[j+1]);
					if(ai.equals(BigInteger.ZERO)){
						continue;
					}else{
						return -1;
					}
					
				}
			}
			
			
		}
		return 0;
	}
	public int compareVersion2(String A, String B) {
		
	    int l1 = A.length();
        int l2 = B.length();
        int l = l2;
        if (l2 > l1) {
            l = l1;
        }
        for (int i = 0; i < l; i++) {
            if (A.charAt(i) == '.' && B.charAt(i) == '.') {
                continue;
            }
            if (A.charAt(i) == '.' && B.charAt(i) != '.') {
                return -1;
            }
            if (A.charAt(i) != '.' && B.charAt(i) == '.') {
                return 1;
            }
            if (A.charAt(i) > B.charAt(i)) {
                return 1;
            }
            if (B.charAt(i) > A.charAt(i)) {
                return -1;
            }
        }
        if (l1 > l2) {
            return 1;
        }
        if (l2 > l1) {
            return -1;
        }
        return 0;
	}
}
