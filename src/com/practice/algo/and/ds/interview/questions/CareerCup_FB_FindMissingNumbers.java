package com.practice.algo.and.ds.interview.questions;

/*Given array : {10,2,3,5,7,8,9,1}; Range : 10

N (Sum of 1 to 10 ) = 55

S (Sum of given elements ) = 45

a+b = 10------------------------------------(1)

Np(Product of 1 to 10) = 3628800

P(Product of given elements) = 151200

So a*b = 24---------------------------------(2)

Now we have two equations and two variables, if we solve we will get values 6 and 4.

http://algorithms.tutorialhorizon.com/algorithms-find-two-missing-numbers-in-a-sequence-of-consecutive-numbers/

*/
public class CareerCup_FB_FindMissingNumbers {

	int Sum;
	int SumN;
	int P=1;
	int Np=1;
	int a,b;
	public int []  missingNumbers(int [] arrA, int range){
		SumN = range*(range+1)/2;
		for(int i=0;i<arrA.length;i++){
			Sum +=arrA[i];
		}
		int s= SumN-Sum;
		for(int i=0;i<arrA.length;i++){
			P *=arrA[i];
		}
		for(int i=1;i<=range;i++){
			Np *=i;
		}
		int product = Np/P;
//		System.out.println(product);
		int diffSqr = (int)Math.sqrt(s*s-4*product); // (a-b)^2 = (a+b)^2-4ab
		a = (s+diffSqr)/2;
		b= s-a;
		int [] result = {a,b};
		return result;
	}
	public static void main(String args[]){
		int [] arrA = {10,2,3,5,7,8,9,1};
		CareerCup_FB_FindMissingNumbers f = new CareerCup_FB_FindMissingNumbers();
		int [] results = f.missingNumbers(arrA, 10);
		System.out.println("Missing numbers are :" + results[0] + " and " + results[1]);
	}

}
