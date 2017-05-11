package com.practice.algo.and.ds.interview.questions;

import java.io.UnsupportedEncodingException;


public class SpotifyUTFConversion {

	public static void main(String[] args) {
		int[] input = {226 ,130 ,172};//11100010 10000010 10101100
		SpotifyUTFConversion o = new SpotifyUTFConversion();
		System.out.println(o.convert(input));
	}

	
	
	/**
	 * @param input. Using input as int[] because Java does not support unsigned byte
	 * @return Octal Code Point as String
	 * @throws UnsupportedEncodingException 
	 */
	public String convert(int[] input){
		String octalCodePoint = "" ;  //can use StringBuilder for better performance
		int[] masks = {128,64,32,16,8,4,2,1};
		int first = input[0];
		int resultOne = first;
		
		for(int i=0;i<masks.length;i++){
			if((first&masks[i])==0){
				octalCodePoint+=makeOctalNumber(resultOne);
				break;
			}
			resultOne = resultOne ^ masks[i];
		}
		int mask = 128;
		for(int i=1;i<input.length;i++){
			int b = input[i];
			b = (b ^ mask);
			octalCodePoint+=makeOctalNumber(b);
			
		}

		return octalCodePoint;
	}

	private String makeOctalNumber(int b) {
		String builder="";
		int maskOctal = 7;
		for(int o=0;o<2;o++){
			int c = b & maskOctal;
			builder =(Integer.toString(c))+builder;
			b = b >> 3;
		}
		return builder;
	}
}
