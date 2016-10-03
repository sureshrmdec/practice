package com.practice.algo.and.ds.spoj;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CanyouanswerthesequeriesI_GSS1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		String sn = r.readLine();
		int n = Integer.parseInt(sn);
		String[] na = r.readLine().split(" ");
		String sm = r.readLine();
		int m = Integer.parseInt(sm);
		for(int i=0;i<m;i++){
			String[] qxy = r.readLine().split(" ");
			int x = Integer.parseInt(qxy[0]);
			int y = Integer.parseInt(qxy[1]);
			int maxTillNow = Integer.parseInt(na[x-1]);
			int continousSum = Integer.parseInt(na[x-1]);
			for(int xx=x;xx<=y-1;xx++){
				int currentNum = Integer.parseInt(na[xx]);
				continousSum+=Integer.parseInt(na[xx]);
				if(continousSum>maxTillNow){
					maxTillNow = continousSum;
					if(currentNum > maxTillNow){
						maxTillNow = currentNum;
						continousSum = maxTillNow;
					}
				}
				/*if(currentNum > maxTillNow && currentNum > continousSum){
					maxTillNow = currentNum;
					continousSum = maxTillNow;
				}*/
				
				
			}
			out.println(maxTillNow);
		}
		out.flush();
	}

}
