package com.practice.algo.and.ds.String;

import java.util.ArrayList;
import java.util.List;

public class Strings_LeetCode_TextJustification {

	public static void main(String[] args) {
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		//String[] words = {""};
		Strings_LeetCode_TextJustification o = new Strings_LeetCode_TextJustification();
		System.out.println(o.fullJustify(words, 6));
	}
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		
		int noOfWordstaken = 0;
		int L = 0;
		List<String> temp = new ArrayList<>();
		for(String word:words){

			int wordL = word.length();
			int LL = noOfWordstaken>=1?L+wordL + 1:L+wordL;;

			if(LL <= maxWidth){
				L = LL;
				noOfWordstaken++;
				temp.add(word);
			}else{
				int r = maxWidth - L + (noOfWordstaken-1);
				int k = 0;
				for(int i=0;i<r;i++){
					temp.set(k,temp.get(k)+" ");
					if(k==noOfWordstaken-1)
						k=0;
					else
						k++;
				}
				String s = "";
				for(String w:temp){
					s+=w;
				}
				result.add(s);
				L = wordL;
				noOfWordstaken = 1;
				temp.clear();
				temp.add(word);
			}
		}
		String s = "";
		for(String w:temp){
			int spacesInsert = Math.abs(w.length() - maxWidth);
			int i =0;
			while(i<spacesInsert){
				w+=" ";
				i++;
			}
			result.add(w);	
		}
		
		return result;
	}
}
