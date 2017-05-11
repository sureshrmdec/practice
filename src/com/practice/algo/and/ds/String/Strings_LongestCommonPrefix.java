package com.practice.algo.and.ds.String;

import java.util.ArrayList;
import java.util.Arrays;

public class Strings_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] aa = {

				"abcd"
	};
		ArrayList<String> in = new ArrayList<>(Arrays.asList(aa));
		Strings_LongestCommonPrefix o = new Strings_LongestCommonPrefix();
		System.out.println(o.longestCommonPrefix(in));
	}

	public String longestCommonPrefix(ArrayList<String> a) {

		int i = 0;
		outer:
		for (i = 0; i < a.get(0).length();) {
			
			char c = a.get(0).charAt(i);
			for (int j = 0; j < a.size(); j++) {
				if (i>=a.get(j).length() ||a.get(j).charAt(i) != c) {
					break outer;
				}
			}
			i++;
		}
		return a.get(0).substring(0, i);
	}
}
