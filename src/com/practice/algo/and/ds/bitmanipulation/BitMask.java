package com.practice.algo.and.ds.bitmanipulation;

public class BitMask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{0,0,0,1},{0,0,1,1},{0,0,1,1},{0,1,1,1}};
		int n = 1;
		for(int i =0;i<3;i++){
			n |=(n<<1);
		}
		int count = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			String str = "";
			for(int j=0;j<arr.length;j++){
			str+=arr[i][j];
			}
			int c= Integer.bitCount(Integer.parseInt(str, 2) & n);
			if(c > count){
				count = c;
			}
			
		}
		System.out.println(count);
	}

}
