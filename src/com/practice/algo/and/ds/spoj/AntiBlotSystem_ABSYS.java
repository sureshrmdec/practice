package com.practice.algo.and.ds.spoj;

import java.io.BufferedReader;

public class AntiBlotSystem_ABSYS {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		String line = r.readLine();
		int t = Integer.parseInt(line);

		for(int i =0;i<t*2;i++){
			line = r.readLine();
			if(!line.isEmpty()){
				String[] arr = line.split(" ");
				if(arr[0].contains("machula")){
					System.out.println((Integer.parseInt(arr[4]) - Integer.parseInt(arr[2])) + " + " +Integer.parseInt(arr[2]) +" = " + (Integer.parseInt(arr[4])));
				}

				if(arr[2].contains("machula")){
					System.out.println((Integer.parseInt(arr[0])) + " + " +(Integer.parseInt(arr[4]) - Integer.parseInt(arr[0])) +" = " + (Integer.parseInt(arr[4])));
				}
				if(arr[4].contains("machula")){
					System.out.println((Integer.parseInt(arr[0])) + " + " +Integer.parseInt(arr[2]) +" = " + (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2])));
				}




			}

		}
	}
}