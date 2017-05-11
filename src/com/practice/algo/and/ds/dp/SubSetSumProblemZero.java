package com.practice.algo.and.ds.dp;

public class SubSetSumProblemZero {

	public static void main(String[] args) {
		SubSetSumProblemZero o = new SubSetSumProblemZero();
		int[] array = {-7,-3,-2,5,8};
		System.out.println(o.isSubSetSumZeroPossible(array));
	}
	
	public boolean isSubSetSumZeroPossible(int[] array){
		
		int neg = 0;
		int pos = 0;
		
		for(int i=0;i<array.length;i++){
			if(array[i]<0){
				neg+=array[i];
			}else{
				pos+=array[i];
			}
		}
		boolean[][] dp = new boolean[array.length+1][Math.abs(neg)+pos+2];
		
		/*for(int i=0;i<array.length;i++){
			if(array[i]<0)
				dp[0][Math.abs(neg)+1+array[i]] = true;
			else
				dp[0][Math.abs(neg)+1+array[i]] = true;
		}*/
		dp[0][Math.abs(neg)+1] = true;
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				
				if(array[i-1]<0){
					int jj = neg+j-1;
					int kk = jj - array[i-1];
					int g=0;
					if(kk<=0)
						g = Math.abs(neg)+1 + (kk);
					else
						g = (kk);
					
					dp[i][j] = dp[i-1][j] || dp[i-1][g];
				}else{
					int jj = neg +1+j;
					dp[i][j] = dp[i-1][j] || dp[i-1][jj + array[i-1]];
				}

			}
			
		}
		
		
		
		
		return 	dp[dp.length-1][Math.abs(neg)+1];
	}
}
