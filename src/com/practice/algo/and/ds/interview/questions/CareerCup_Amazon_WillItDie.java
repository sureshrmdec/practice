package com.practice.algo.and.ds.interview.questions;

//https://www.careercup.com/question?id=5107149794443264

/*given a stream of natural numbers , 

and a array J contains integers in increasing orders 
operations performed J = [2,3,4] 
1 2 3 4 5 6 7 8 9 10…………..27....100...1111 
first operation 

J[0] = 2 => remove every 2nd integer 

now the stream is 
1 3 5 7 … 27 
J[1] = 3 
remove every 3rd 
stream is now 
1 3 7 … 
3rd 
given a natural number n , find if it will survive given J, or at what index it will 
die.
*/
public class CareerCup_Amazon_WillItDie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		int[] j = {3,4};
		int n =9;
		CareerCup_Amazon_WillItDie o = new CareerCup_Amazon_WillItDie();
		o.willItDie(nums, j, n);
	}
	public static void willItDie(int[] nums, int[] j, int n){
		
		int index = n;
		int numsL = nums.length;
		for(int jj:j){
			int currentJ = jj;
			if(index%currentJ==0)
				System.out.println("It will die");
			index = (index) - ((index)/currentJ);
		}
		
	}
}
