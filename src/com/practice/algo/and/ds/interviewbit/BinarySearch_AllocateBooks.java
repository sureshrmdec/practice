package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch_AllocateBooks p = new BinarySearch_AllocateBooks();

		/*int b= 12;
		Integer[] c = {31, 14, 19, 75};*/
		int b= 1;
		Integer[] c = {12, 34, 67, 90};
		//{97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
		//{12, 34, 67, 90}
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(c));
		System.out.println(p.books(a, b));
		
	}
	/*P : [12, 34, 67, 90]
	M : 2
	
	*
	*/
	public int books(ArrayList<Integer> a, int b) {
		if(b>a.size()){
			return -1;
		}
		int l = 1;
		int h = 0;
		for(int i=0;i<a.size();i++){
			h+=a.get(i);
		}
		BigInteger result=BigInteger.ZERO;
		while(l<=h){
			int mid = (l+h)/2;
			
			if(isPossible(mid,a,b)){
				l = mid+1;
				result = BigInteger.valueOf(mid);
			}else{
				h=mid-1;
			}
			
		}
		
		return (result.intValue());
		
	}
	boolean isPossible(int t,ArrayList<Integer> c, int a){
	
		int currentSum = 0;
		int i=c.size()-1;
		for(;i>=0 && a>0;i--){
			currentSum+=c.get(i);
			if(c.get(i)>t){
				return true;
			}
			if(currentSum>=t && a>0){
				i++;
				//currentSum = c.get(i);
				currentSum = 0;
				a--;
			}

			
			
		}
		if(a>0)
			return false;
		if(i>=0 && a<1){
			return true;
		}
		
		
		return true;
	}
}
