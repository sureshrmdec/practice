package com.practice.algo.and.ds.interviewbit;

public class BinarySearch_ImplementPowerFunction {
//https://www.careercup.com/question?id=22767685
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 6;
		int y = x;
		y=8;
		BinarySearch_ImplementPowerFunction o = new BinarySearch_ImplementPowerFunction();
		System.out.println(o.powIB(3,7,10000));

	}

	//Interview Bit Soln
	public int powIB(int x, int n, int d) {
		long a = x;
		long res = 1L;
		while (n > 0) {
			if (n % 2 == 1) {
				res *= a;
				res %= d;
			}
			a *= a;
			a %= d;
			n = n >> 1;
		}
		//This + d is if x is negative...
		res = (res + d) % d;
		return (int) res;
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
