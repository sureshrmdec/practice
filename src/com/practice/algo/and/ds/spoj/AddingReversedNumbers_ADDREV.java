package com.practice.algo.and.ds.spoj;

import java.io.BufferedReader;
import java.io.IOException;

public class AddingReversedNumbers_ADDREV {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		
		int n = Integer.parseInt(r.readLine());
		for(int i=0;i<n;i++){
			String[] sa = r.readLine().split(" ");
			String rev1 = "";
			for ( int j = sa[0].length() - 1 ; j >= 0 ; j-- )
				rev1 = rev1 + sa[0].charAt(j);
			String rev2 = "";
			for ( int j = sa[1].length() - 1 ; j >= 0 ; j-- )
				rev2 = rev2 + sa[1].charAt(j);
			
			int a = Integer.parseInt(rev1);
			int b = Integer.parseInt(rev2);
			String res = Integer.toString(a+b);
			String o = new String();
			boolean tz = true;
			for ( int j = res.length() - 1 ; j >= 0 ; j-- ){
				if(tz && (res.charAt(j)=='0')){
					continue;
				}else{
					tz = false;
					o = o + res.charAt(j);
				}
			}
			System.out.println(o);
		}
	}

}
