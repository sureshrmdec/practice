package com.practice.algo.and.ds.interviewquestions.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a string pattern of 0s, 1s, and ?s (wildcards), generate all 0-1 strings that match 
this pattern. 
e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]. 
You can generate the strings in any order that suits you.
*/
public class Generate01WildcardStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1?00?101";
		char[] ca = str.toCharArray();
		int c=0;
		List<Integer> indexes = new ArrayList<Integer>();
		int numberOfQuestion = 0;
		for(int i=0;i<ca.length;i++){
			if(ca[i]=='?'){
				numberOfQuestion++;
				indexes.add(i);
				c++;
			}
		}
		//?? -> 00 ,01,10,11
		int max = 1;
		for(int i=0;i<numberOfQuestion;i++){
			max = max << 1;
		}
		
		for(int i=0;i<max;i++){
			System.out.println(Integer.toBinaryString(i));
			char[] cs = Arrays.copyOf(ca, ca.length);
			int x=0;
			for(int n=1;n<=numberOfQuestion;n++){
				if(Integer.toBinaryString(i).length()<numberOfQuestion)
				cs[indexes.get(n-1)] =  Integer.toBinaryString(i).length() < n ? Integer.toBinaryString(i).charAt(x++):'0';
				else
				cs[indexes.get(n-1)] =  Integer.toBinaryString(i).charAt(x++);
					
			}
			System.out.println(Arrays.toString(cs));
		}
	}

}
