package com.practice.algo.and.ds.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavavsC_JAVAC {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		String line = r.readLine();
		/*		for(BigInteger i=BigInteger.ZERO;i.compareTo(BigInteger.valueOf(11))<=0;i=i.add(BigInteger.ONE)){
			map.put(i, i);
		}*/
		 String patternString = "_";
		 Pattern pattern = Pattern.compile(patternString);
	     Matcher matcher;
	     int delta = 0;
	     int start = 0;
	     String identifier = "";
		while(line != null){
			
			if(line.contains("_")){
				
			}else{
				
			}
		
			line = r.readLine();
		}
		
	}

}
