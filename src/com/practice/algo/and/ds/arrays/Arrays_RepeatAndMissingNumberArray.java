package com.practice.algo.and.ds.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays_RepeatAndMissingNumberArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {4, 3, 2, 3};
		Arrays_RepeatAndMissingNumberArray aa = new Arrays_RepeatAndMissingNumberArray();
		List<Integer> al = Arrays.asList(a);

		System.out.println(aa.repeatedNumberNoMemory(al));

	}


	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		Collections.sort(a);

		Integer[] r = new Integer[2];
		//1 2 3 3 5
		//1 1 3 4 5
		//1 1 2 4 5
		for(int i=1;i<a.size();i++){

			int la = a.get(i);
			int pla = a.get(i-1);
			if((la-pla==0)){
				//System.out.println("A:="+i);	
				//res.add(0, i);
				r[0] = la;
			}
			if((la-pla>1)){
				//res.add(1, la-1);
				r[1]=la-1;
				//System.out.println("B:"+(i));
			}
		}
		if(r[1]==null){
			if(a.get(a.size() - 1) == a.size()-1){
				r[1] = a.size();
			}else if(a.get(0) == 2){
				r[1] =  1;
			}
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(r));
		return arrayList;
	}

	//Awesome Soln
	//Without Sorting
	public ArrayList<Integer> repeatedNumber2(final List<Integer> a) {

		Integer[] r = new Integer[2];
		//1 2 3 3 5
		//1 1 3 4 5
		//1 1 2 4 5
		for(int i=0;i<a.size();i++){
			int n = Math.abs(a.get(i));
			if(a.get(n-1)>0){
				int nn = a.get(n-1);
				a.set(n-1, -nn);	
			}else{
				r[0] = n;
			}
		}
		for(int i=0;i<a.size();i++){
			if(a.get(i)>0){
				r[1]=i+1;
				break;
			}
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(r));
		return arrayList;
	}

	//
	public List<Integer> repeatedNumberNoMemory(final List<Integer> nums) {

		int arraySize = nums.size();
		BigInteger arrSum = BigInteger.ZERO;
		BigInteger arrSumSq = BigInteger.ZERO;

		BigInteger idxSum = BigInteger.ZERO;
		BigInteger idxSumSq = BigInteger.ZERO;

		for(int i = 0; i < arraySize; i++){
			int num = nums.get(i);
			arrSum = arrSum.add(BigInteger.valueOf(num));
			arrSumSq = arrSumSq.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(num)));

			BigInteger idxPos = BigInteger.valueOf(i).add(BigInteger.ONE);
			idxSum = idxSum.add(idxPos);
			idxSumSq = idxSumSq.add(idxPos.multiply(idxPos));
		}

		// sq(a) - sq(b) = (a+b)*(a-b)
				// idxSumSq.subtract(arrSumSq) => sq(a) - sq(b)
		BigInteger apb = idxSumSq.subtract(arrSumSq).divide(idxSum.subtract(arrSum));
		BigInteger amb = idxSum.subtract(arrSum);


		BigInteger b = apb.add(amb).divide(BigInteger.valueOf(2));
		BigInteger a = apb.subtract(b);

		List<Integer> res  = new ArrayList<>();
		res.add(a.intValue());
		res.add(b.intValue());

		return res;
	}
}
