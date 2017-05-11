package com.practice.also.and.ds.implementation;

public class JPMorganChase_Dev {

	public static void main(String[] args) {
		JPMorganChase_Dev o = new JPMorganChase_Dev();
		System.out.println(o.getLongestCommonSubstring("cornfield", "outfield"));

	}


	
	public static String getLongestCommonSubstring(String a, String b){
		int m = a.length()-1;
		int n = b.length()-1;
	 
		StringBuffer result = new StringBuffer();
		while(m>=0 && n>=0){
			
			if(a.charAt(m)==b.charAt(n)){
				result.append(a.charAt(m));
				m--;
				n--;
			}else{
				break;
			}
			
		}

	 
		return result!=null?result.reverse().toString():null;
	}
}
