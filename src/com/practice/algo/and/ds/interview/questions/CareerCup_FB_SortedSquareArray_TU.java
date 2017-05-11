package com.practice.algo.and.ds.interview.questions;

//https://www.careercup.com/question?id=5681516425248768

/*Given: sorted array of integers 
Return: sorted array of squares of those integers 
Ex: [1,3,5] -> [1,9,25] 

Integers can be negative.
e.g. [-6,-4,1,2,3,5])*/

public class CareerCup_FB_SortedSquareArray_TU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArray = {-6,-4,1,2,3,5};
		CareerCup_FB_SortedSquareArray_TU o = new CareerCup_FB_SortedSquareArray_TU();
		o.sortedSquare(sortedArray);
	}
	public int[] sortedSquare(int[] sortedArray)
	{
		int[] sortedSquare = new int[sortedArray.length];
		int front = 0;
		int back = sortedArray.length - 1;
		int currentPos = sortedArray.length - 1;
		while(front <= back)
		{
			int frontSq = sortedArray[front] * sortedArray[front];
			int backSq = sortedArray[back] * sortedArray[back];
			
			if(frontSq <= backSq)
			{
				sortedSquare[currentPos--] = backSq;
				--back;
			}
			else
			{
				sortedSquare[currentPos--] = frontSq;
				++front;
			}
		}
		
		return sortedSquare;
	}
}
