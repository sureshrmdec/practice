package com.practice.algo.and.ds.binarysearch;

public class BinarySearch_ImplementPowerFunctionRe {

	public static void main(String[] args) {
		double x = -1;
		int n = 2147483647;
		BinarySearch_ImplementPowerFunctionRe o = new BinarySearch_ImplementPowerFunctionRe();
		System.out.println(o.myPow(x, n));
		
		
	}
	public double myPow(double x, int n) {

		if(n==0)
			return 1;
		 if(n<0) {
		        n = -n;
		        x = 1/x;
		    }		
		
		int nn = Math.abs(n);
        double result = 1;
        while(nn>=1){
            if(nn%2!=0){
                result*=x;
            }
            x*=x;
            nn = nn>>1;
        }

        return result;
    }

}
