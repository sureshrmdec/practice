package com.practice.algo.and.ds.String;

public class Strings_LongestPalindromicSubString {

	public static void main(String[] args) {
		Strings_LongestPalindromicSubString i = new Strings_LongestPalindromicSubString();
		System.out.println(i.longestPalindrome("AABCDCBA"));

	}
	public String longestPalindrome(String a) {
		if(a.trim().length()==0){
			return "";
		}
		int iL=0;
		int iR=0;
		String res = a.substring(0,1);
		int resL = 1;
		for(int i=1;i<a.length();i++){
				
			int length1 = 0;
			String tempRes="";
			//middle 2 elements are same eg aaaa
			int right1 = 0;
			int left1 = 0;
				if(a.charAt(i)==a.charAt(i-1)){
					right1 = i+1;
					left1 = i-2;
					//tempRes = Character.toString(a.charAt(i-1)).concat(Character.toString(a.charAt(i)));
				
					while(right1<a.length() && left1>=0 && a.charAt(right1)==a.charAt(left1)){
						//tempRes = Character.toString(a.charAt(left1)).concat(tempRes).concat(Character.toString(a.charAt(right1)));
						right1++;
						left1--;

					}
					length1 = (right1-1)-(left1+1)+1;
					
				}
				int right2 = i+1;
				int left2 = i-1;
				//String tempRes2 = Character.toString(a.charAt(i));
				while(right2<a.length() && left2>=0 && a.charAt(right2)==a.charAt(left2)){
					//tempRes2 = Character.toString(a.charAt(left2)).concat(tempRes2).concat(Character.toString(a.charAt(right2)));
					right2++;
					left2--;
				}
				int length2 = (right2-1)-(left2+1)+1;
				if(length1>length2 && length1>resL){
					iL=left1+1;
					iR=right1-1;
					resL = length1;
				}else if(length2>length1 && length2>resL){
					iL=left2+1;
					iR=right2-1;
					resL = length2;
				}
			
		}
		
		return a.substring(iL,iR+1);
	}
	
	
	public String longestPalindrome2(String a) {
		if(a.trim().length()==0){
			return "";
		}
		String res = a.substring(0,1);
		for(int i=0;i<a.length();i++){
			int left = i;
			for(int j=i+1;j<a.length();j++){
				int right = j;
				while(left<=right){
					if(a.charAt(left)==a.charAt(right)){
						
					}
				}
				
			}	
			
		}
		
		return res;
	}
}
