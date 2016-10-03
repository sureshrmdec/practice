package com.practice.algo.and.ds.interviewbit;

public class BinarySearch_ImplementPowerFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch_ImplementPowerFunction o = new BinarySearch_ImplementPowerFunction();
		System.out.println(o.pow(71045970,41535484,64735492));

	}
	//3^50 ->>  (3^25)^2 ->> (3^12)^4 *3^2 ->> (3^6)^8 * 9 --> (3^3)^16 * 9 --> (3^2)^16 * (3^1)^16 * 9
	public int pow(int x,int y){
		
		 int temp;
		    if( y == 0)
		        return 1;
		    temp = pow(x, y/2);
		    if (y%2 == 0)
		        return temp*temp;
		    else
		        return x*temp*temp;
	}
	
	public int pow(int x, int y, int d) {
		
		 int temp;
		    if( x == 0)
		        return 0;
		    if( y == 0)
		        return 1;
		    temp = (pow(x, y/2,d))%d;
		    if (y%2 == 0)
		        return (temp*temp)%d<0?(d+(temp*temp)%d):(temp*temp)%d;
		    else
		        return (x*temp*temp)%d<0?(d+(x*temp*temp)%d):(x*temp*temp)%d;
	}

}
