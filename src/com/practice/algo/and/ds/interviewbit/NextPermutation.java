package com.practice.algo.and.ds.interviewbit;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new  NextPermutation();
		
		np.printPermutation("115","");
		
	}

	
	private void printPermutation(String s,String prefix){
		int n = s.length();
		if(s.length()==0){
			 System.out.println(prefix);
		}
		for(int i=0;i<n;i++){
			printPermutation(s.substring(0,i)+s.substring(i+1),prefix+s.substring(i,i+1));
			
		}
		
	}
}
