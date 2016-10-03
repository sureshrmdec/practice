package com.practice.algo.and.ds.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArmyStrength_ARMY {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for(int i=0;i<t;i++){
			in.readLine();
			in.readLine();
			
			int gMax = Integer.MIN_VALUE;
			int mMax = Integer.MIN_VALUE;;
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) {
				gMax = Math.max(gMax, Integer.parseInt(st.nextToken()));
			}
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) {
				mMax = Math.max(mMax, Integer.parseInt(st.nextToken()));
			}
			System.out.println(gMax>=mMax?"Godzilla":"MechaGodzilla");

		}
	}
}
