package com.practice.algo.and.ds.interviewbit;

public class Strings_ZigzagString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_ZigzagString o = new Strings_ZigzagString();
		System.out.println(o.convert("NX9AROO79WZSd", 24));
	}
	/*
	 * AKBJLCIDHEGF
	PAHNAPLSIIGYIR
	PAHNAPLSIIGYIR
	P.......A........H.......N
	..A....P...L....S....I...I....G
	....Y.........I........R*/
	
	public String convert(String a, int b) {
		if(b>a.length() || b==1){
			return a;
		}
		StringBuilder res = new StringBuilder();
		for(int i =0;i<b;i++){
			res.append(a.charAt(i));
			
			int topDownGap = (i-0)*2;
			int bottomUpGap = ((b-1)-i)*2;
			int j=i+bottomUpGap;
			boolean topD = false;
			if(i==b-1){
				j=i+topDownGap;
			}
			if(j>0)
			while(true){
				if(j>=a.length()){
					break;
				}
				if(topD){
					res.append(a.charAt(j)); 
					topD = false;
					if(bottomUpGap!=0)
						j+=bottomUpGap;
					else
						j+=topDownGap;
				}else{
					res.append(a.charAt(j));
					topD = true;
					if(topDownGap!=0)
						j+=topDownGap;
					else
						j+=bottomUpGap;
				}
				
			}
		}
		return res.toString();
	}
}
