package com.practice.algo.and.ds.general;

public class FlipZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int wL = 0; int wR = 0; 
		int nZero = 0;
		int bestWindowWidth = -1;
		char[] A = {'1', '1', '0','1', '1', '0', '0', '1', '1', '1'};
		int m = 2;
		int bestWR;
		int bestWL;
		while(wR < A.length){	
			//expand to the right, update '0' count:
			if (nZero <= m){
				
				if (A[wR] == '0') {
					nZero++;
					}
				wR++;
			}

			//shrink from left, update '0' count:
			if (nZero > m){ 
				if (A[wL] == '0'){ 
					nZero--;
					}
				wL++;
			}
			
			//update best window:
			if (wR - wL > bestWindowWidth){
				bestWindowWidth = wR - wL;
				bestWR = wR;
				bestWL = wL;
			}	
		}
	}

}
