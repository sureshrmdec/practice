package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Arrays_Flip {

	public static void main(String[] args) {
		Arrays_Flip s = new Arrays_Flip();
		String A = "00111000";//0111000100010
		//Integer aa[] = {1,-1,-1,-1,1,1,1,-1,1,1,1,-1,1};
		System.out.println(s.flip(A));

	}
	public ArrayList<Integer> flip(String A) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		String[] AA = A.split("");
		for(int i=0;i<AA.length;i++){
			if(AA[i].equals("1")){
				AA[i]="-1";
			}else{
				AA[i]="1";
			}
		}

		
		int maxSumSoFar = 0;
		int last = 0;
		int max_start_index = 0;
	    int startIndex = 0;
	    int max_end_index = -1;
	    
		for(int i=0;i<AA.length;i++){
			Integer num = Integer.parseInt(AA[i]);
			last+=num;
			if(maxSumSoFar<last){
				maxSumSoFar = last;
		        max_start_index = startIndex;
		        max_end_index = i;
			}
			if(last<0){
		        startIndex = i+1;
				last = 0;
			}
		}

		if(max_end_index==-1){
			return arrayList;
		}
		arrayList.add(max_start_index+1);
		arrayList.add(max_end_index+1);
		System.out.println(maxSumSoFar);
		return arrayList;
	}

}
