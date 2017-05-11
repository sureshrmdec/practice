package com.practice.algo.and.ds.dp;

//https://discuss.leetcode.com/topic/18482/accepted-clean-java-dp-solution
//Its like max rectangle in binary matrix...
public class DP_LeetCode_MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char[][] matrix = {{'1', '0' ,'1', '0', '0'},
						   {'1', '0', '1', '1', '1'},
						   {'1', '1', '1', '1', '1'},
						   {'1', '0', '0', '1', '0'}};*/
		DP_LeetCode_MaximalSquare o = new DP_LeetCode_MaximalSquare();

		String[] input = {"101101",
						  "111111",
						  "011011",
						  "111010",
						  "011111",
						  "110111"};
        
        char[][] matrix = new char[input.length][input[0].length()];
        
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input[i].charAt(j);
            }
        }
		
		
		System.out.println(o.maximalSquare(matrix));
	}
	//DP based Solution
	public static int maximalSquareDP(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
	public int maximalSquare(char[][] matrix) {
		int result =0;
		for(int i=0;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][j]=='1'){
					int a = (matrix[i][j-1]-'0')+(1);
					matrix[i][j] = (char)(a+'0');
				}					
			}	 
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				int size =1;
				int ii = i;
				int jj = j;
				int minSize = Integer.MAX_VALUE;
				while(ii>=0){
					if(minSize>=size && matrix[ii][j]-'0'>=size && matrix[i][jj]-'0'>=1){
						result = Math.max(size*size, result);
						size++;
						if(ii>0 && j>=0)
							minSize = Math.min(minSize, matrix[ii-1][j]-'0'); //keep the min size of the above row
						ii--;
						jj--;
					}else{
						break;
					}	
				}
				
			}	
		}
		return result;

	}
}
