package com.practice.algo.and.ds.bitmanipulation;

//http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
public class BitManipulation_AddTwoNumbers {

	public static void main(String[] args) {
		BitManipulation_AddTwoNumbers o = new BitManipulation_AddTwoNumbers();
		System.out.println(o.add(5, 7)); //0101 0111
		System.out.println(o.subtract(5, 7));

	}
	/*0101       0101   
	  0111 -->>  0111  
	  1100       0010  (2) --> 0010
	       CARRY 0101  (5) --> 1010
	       					   1000 (8)
	       				CARRY  0010 (2)	
                               
	*/	
	public int add(int x,int y){
		
		while (y != 0)
		{
			// carry now contains common set bits of x and y
			int carry = x & y;  

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y; 

			// Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
		}
		return x;
		
	}
	//In subract, change carry to borrow... and add ~ (tilda) in front of x........
	public int subtract(int x,int y){
		
		while (y != 0)
		{
			// carry now contains common set bits of x and y
			int borrow = ~(x) & y;  

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y; 

			// Carry is shifted by one so that adding it to x gives the required sum
			y = borrow << 1;
		}
		return x;
		
	}

}
