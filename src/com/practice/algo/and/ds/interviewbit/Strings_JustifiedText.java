package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Strings_JustifiedText {

	public static void main(String[] args) {
		String[] words = {"What", "must", "be", "shall", "be." };
		ArrayList<String> a = new ArrayList<>(Arrays.asList(words));
		int b = 12;
		Strings_JustifiedText o = new Strings_JustifiedText();
		System.out.println(o.fullJustify(a, b));
	}
	public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
		ArrayList<String> res = new ArrayList<>();
		
		int i=0;
		for(i=0;i<a.size();i++){
			int j=i;
			int currentLine = 0;
			while(true){
				if(i>=a.size()){
					i--;
					break;
				}
				String word = a.get(i);
				if(currentLine+word.length()<=b){
					currentLine+=word.length()+1;
					i++;
				}
				else{
					i--;
					break;
				}
			}
			//delete last space
			currentLine--;
			int remaining = b-currentLine;
			StringBuilder newLine = new StringBuilder();
			if(i-j!=0){
			int equal = remaining/(i-j);
			remaining = remaining - (equal*(i-j));
			
			for(int l=j;l<=i-1;l++){
				newLine.append(a.get(l)).append(" ");
				for(int e=0;e<equal;e++){
					newLine.append(" ");
				}
				if(remaining>0){
					newLine.append(" ");
					remaining--;
				}
			}
			}
			newLine.append(a.get(i));
			res.add(newLine.toString());
		}
	
	return res;
	}
}
