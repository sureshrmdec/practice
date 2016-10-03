package com.practice.algo.and.ds.interviewbit;

/*For B = 2, number of possibilities = sqrt(INT_MAX) = sqrt(2^31 - 1) < 2^16.
For B = 3, number of possibilities = INT_MAX**1/3 < 2^11
For B = 4, number of possibilities = INT_MAX**1/4 < 2^8
.
.
.
For B = 32, number of possibilities = 0 ( Not considering 1 as its considered in the first case, and 2^32 exceeds INT_MAX ). 
*/

public class Maths_PowerOfTwoIntegers {

	public static void main(String[] args) {
		Maths_PowerOfTwoIntegers o = new Maths_PowerOfTwoIntegers();
		System.out.println(o.isPower(1));
		

	}
	public boolean isPower(int a) {
		if(a==1)
			return true;
		int upperLimitA = (int)(Math.sqrt(a));
		for(int i =upperLimitA;i>=2;i--){
			if(a%i==0){
				int aa = a;
				while(true){
					aa /=i;
					if((aa%i==0)){
						if(aa/i==1)
							return true;
					}
					if(aa%i!=0){
						break;
					}
				}
				}
		}
		return false;
	}
	
	 public boolean isPowerIBSoln(int a) {
		
	        double x=2;
		    double i;
		    if(a==1) return true;
		    for(i=2;(i<33)&&(x<=(double)(Math.pow(2,16)));i++)
		    {   
		        if(Math.pow(x,i)==(double)a) return true;
		        if(Math.pow(x,i) >= (Math.pow(2,32))) {i=1;x++;}
		    }
		    return false;
	    }
}
