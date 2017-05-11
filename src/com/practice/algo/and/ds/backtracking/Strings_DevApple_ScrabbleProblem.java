package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Strings_DevApple_ScrabbleProblem {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ab");
		list.add("abc");
		list.add("abcc");
		list.add("bbcc");
		Strings_DevApple_ScrabbleProblem o = new Strings_DevApple_ScrabbleProblem();
		o.getLongestWord(list);
		System.out.println(list);

	}
	public String getLongestWord(List<String> list){

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()>=o2.length())
					return -1;
				else
					return 1;
			}
		});

		for(String word:list){
			if(possible(word,list)){
				return word;
			}
		}


		return null;
	}
	private boolean possible(String word,List<String> list) {
		if(word.length()==2){
			if(list.contains(word))
				return true;

			return false;
		}
		String possibleOne = word.substring(0,word.length()-1);
		String possibleTwo = word.substring(1);
		boolean one = false;
		boolean two = false;
		if(list.contains(possibleOne)){
			one = possible(possibleOne, list);
		}
		if(one)
			return true;
		if(list.contains(possibleOne)){
			two = possible(possibleTwo, list);
		}
		if(two)
			return true;
		
		return false;
	}

}
