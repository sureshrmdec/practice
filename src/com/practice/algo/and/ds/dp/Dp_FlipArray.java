package com.practice.algo.and.ds.dp;

public class Dp_FlipArray {

	public static void main(String[] args) {
		int[] array = {8, 4, 5, 7, 6, 2 };
		Dp_FlipArray o = new Dp_FlipArray();
		System.out.println(o.flip(array));

	}
	public int flip(int[] array){
		int sum = 0;
		for(int i=0;i<array.length;i++)
			sum+=array[i];

		State[][] dp = new State[sum/2+1][array.length+1];
		for(int i=0;i<=array.length;i++){
			State state = new State(0,true,0);
			dp[0][i] = state;
		}
		for(int i=1;i<=sum/2;i++){
			State state = new State(0,false,i);
			dp[i][0] = state;
		}
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				State state = dp[i][j-1];
				if(i-array[j-1]>=0 && dp[i-array[j-1]][j-1].sum){
					//if(state.flips>dp[i-array[j-1]][j-1].flips+1)
						dp[i][j] = new State(dp[i-array[j-1]][j-1].flips+1,true,i);
						System.out.println(i);
				}else{
					dp[i][j] = state;
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1].flips;
	}
	class State{
		int flips;
		boolean sum;
		int actualSum;
		public State(int flips, boolean sum,int actualSum) {
			super();
			this.flips = flips;
			this.sum = sum;
			this.actualSum = actualSum;
		}
		
	}
}
