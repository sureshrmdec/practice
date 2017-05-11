package com.practice.algo.and.ds.interview.questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Atul_PS4_Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getShortestDis() throws IOException{
		BufferedReader br = null;
		FileReader fr = null;
		String one = "fast";
		String two = "car";
		try {

			fr = new FileReader("");
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(""));
			int indexOne = -1;
			int indexTwo = -1;
			int res = Integer.MIN_VALUE;
			while ((sCurrentLine = br.readLine()) != null) {
				List<String> split = Arrays.asList(sCurrentLine.split(" "));
				if(split.contains(one) && split.contains(two)){
					int a = split.indexOf(one);
					int b = split.indexOf(two);
				}else if(split.contains(one)){
					
				}else if(split.contains(two)){
					
				}
			}

		}finally{

		}
		return 0;
	}
}
