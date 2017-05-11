package com.practice.algo.and.ds.dp;

import java.util.Arrays;

public class DP_LeetCode_PaintHouseII {

	public static void main(String[] args) {
		DP_LeetCode_PaintHouseII o = new DP_LeetCode_PaintHouseII();
		int[][] in = {{8,16,12,18,9},
				{19,18,8,2,8},
				{8,5,5,13,4},
				{15,9,3,19,2},
				{8,7,1,8,17},
				{8,2,8,15,5},
				{8,17,1,15,3},
				{8,8,5,5,16},
				{2,2,18,2,9}};
		System.out.println(o.minCostII(in));

	}


	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;

		int n = costs.length, k = costs[0].length;
		if(k == 1) return (n==1? costs[0][0] : -1);

		int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
				for(int i = 0; i<n; i++) {
					int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
					for(int j = 0; j<k;  j++) {
						int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
						if(minInd< 0) {//when min isn't initialized
							min = val; 
							minInd = j;
						}else if(val < min) {//when val < min, 
							secMin = min;
							min = val;
							minInd = j;
						} else if(val < secMin) { //when min<=val< secMin
							secMin = val;
						}
					}
					prevMin = min;
					prevMinInd = minInd;
					prevSecMin = secMin;
					System.out.println(" prevMin "+prevMin +" prevMinInd "+prevMinInd +" prevSecMin  "+prevSecMin);
				}
				return prevMin;
	}

	public int minCostIIMy(int[][] costs) {

		int last = -1;
		int[] minTwo = new int[2];
		int[] topColor = new int[2];
		int result = 0;
		for(int i=0;i<costs.length;i++){
			Arrays.fill(minTwo, Integer.MAX_VALUE);
			Arrays.fill(topColor, -1);
			for(int j=0;j<costs[0].length;j++){
				if(costs[i][j]<minTwo[0]){
					int temp = minTwo[0]; 
					minTwo[0] = costs[i][j];
					minTwo[1] = temp;

					int colorTemp = topColor[0];
					topColor[0] = j;
					topColor[1] = colorTemp;

				}else if(costs[i][j] < minTwo[1]){
					minTwo[1] = costs[i][j];
					topColor[1] = j;
				}
			}
			if(last!=topColor[0]){
				result+=minTwo[0];
				last = topColor[0];
			}else{
				result+=minTwo[1];
				last = topColor[1];
			}

		}

		return result;
	}
}
