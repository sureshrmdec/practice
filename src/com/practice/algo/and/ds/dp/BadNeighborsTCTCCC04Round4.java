package com.practice.algo.and.ds.dp;

public class BadNeighborsTCTCCC04Round4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BadNeighborsTCTCCC04Round4 bad = new BadNeighborsTCTCCC04Round4();
		int[] neighbours =  	
		{11, 15};
		System.out.println(bad.maxDonations(neighbours));
	}

	private int maxDonations(int[] neighbours) {
		int[] dp1 = new int[neighbours.length-1];
		int[] dp2 = new int[neighbours.length-1];
		
		for(int i =0;i<neighbours.length-1;i++){
			dp1[i] = neighbours[i];
		}
		for(int i =1,j=0;i<neighbours.length;i++,j++){
			dp2[j] = neighbours[i];
		}
		int[] seq1 = new int[dp1.length];
		int[] seq2 = new int[dp2.length];
		for(int i=0;i<seq1.length;i++){
				seq1[i] = Math.max(dp1[i] + ((i-2>=0)?seq1[i-2]:0),((i-1>=0)?seq1[i-1]:0));
		}
		for(int i=0;i<seq2.length;i++){
				seq2[i] = Math.max(dp2[i] + ((i-2>=0)?seq2[i-2]:0),((i-1>=0)?seq2[i-1]:0));
	}
		return Math.max(seq1[seq1.length-1], seq2[seq2.length-1]);
	}

}
