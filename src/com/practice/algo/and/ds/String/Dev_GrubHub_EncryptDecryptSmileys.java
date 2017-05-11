package com.practice.algo.and.ds.String;

import java.util.HashMap;
import java.util.Map;

public class Dev_GrubHub_EncryptDecryptSmileys {

	public static void main(String[] args) {
		buildMapASCII();
		Dev_GrubHub_EncryptDecryptSmileys o = new Dev_GrubHub_EncryptDecryptSmileys();
		
		o.decryptUsingASCII(o.encryptUsingASCII("hello"));

	}

	//1 2 4 8 16 32 64 128
	//Total 128 ASCII values (0 to 127) so we need 8 bits
	private static Map<Integer,String> mapKVASCII = new HashMap<Integer,String>();
	private static Map<String,Integer> mapVKASCII = new HashMap<String,Integer>();
	private static void buildMapASCII(){
		for(int i=0;i<=127;i++){
			int ii = i;
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<8;j++){
				if((ii&1)==0){ //checking here if left most digit is 1 or 0
					sb.append("0");
				}else{
					sb.append("1");
				}
				ii = ii>>1;					
			}
			String s = sb.reverse().toString();
			mapKVASCII.put(i, s);
			mapVKASCII.put(s, i);
		}
	}
	public String encryptUsingASCII(String input){
		StringBuilder result  = new StringBuilder();
		char[] cA = input.toCharArray();
		for(char c:cA){
			int a = c;
			result.append(mapKVASCII.get(a));
		}
		System.out.println(result.toString());
		return result.toString();
	}
	public void decryptUsingASCII(String input){
		String result = "";
		for(int i=0;i<input.length();i=i+8){
			int a =mapVKASCII.get(input.substring(i, i+8));
			Character c = (char)(a);
			result+=c;
		}
		System.out.println(result);
		
	}

}
