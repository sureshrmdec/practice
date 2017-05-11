package com.practice.algo.and.ds.interviewbit;

public class DP_ArrangeIIRevisited {

	public static void main(String[] args) {
		DP_ArrangeIIRevisited p = new DP_ArrangeIIRevisited();
		//8323071	
		System.out.println(p.arrange("BBWBBBWW", 3));
		   System.out.println(p.arrange("BBWBBBWW", 3));
			System.out.println(p.arrange("WWWBWWBB", 3));
			System.out.println(p.arrange("WWWBWWBB", 3));

	}
	public int arrange(String A, int B) {
		int sizeA = A.length();
		int[][] dp = new int[B+1][sizeA+1];
		
        for(int i = 1; i <= A.length(); i++){
            dp[1][i] = product(A, 0, i - 1);
        }
		for(int i=2;i<=B;i++){ // i is stable
			for(int j=i;j<=sizeA-(B-i);j++){
				int min = Integer.MAX_VALUE;
				int k = i-1;
				for(int kk=k;kk<j;kk++){
					dp[i][j] = Math.min(dp[k][kk]+product(A, kk, j-1),min);
					min = dp[i][j];
				}
			}	
		}
		return dp[dp.length-1][dp[0].length-1];
	}
    public int product(String A, int start, int end){
        int W = 0, B = 0;
        for(int i = start; i <= end; i++){
            if(A.charAt(i) == 'W') W++;
            else if(A.charAt(i) == 'B') B++;
        }
        return W * B;
    }
}
