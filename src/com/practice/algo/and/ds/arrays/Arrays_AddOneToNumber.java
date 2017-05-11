package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Also See question in package com.practice.algo.and.ds.interview.questions, class CareerCup_AddANumberToAnArray ;
// Command+Shift+R --> CareerCup_AddANumberToAnArray

public class Arrays_AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_AddOneToNumber s = new Arrays_AddOneToNumber();
		Integer aa[] = { 0, 6, 0, 6, 4, 8, 8, 1};
		List<Integer> a = Arrays.asList(aa);
		System.out.println(s.plusOne2(a));
	}

	
	public ArrayList<Integer> plusOne2(List<Integer> a) {
		ArrayList<Integer> res = new ArrayList<>(a.size()+1);
		int j =1;
		for(int i=a.size()-1;i>=0;i--){
			j = a.get(i)+j;
			res.add(0, j%10);
			j = j/10;
		}
		if(j>0)
			res.add(0, j);
		for(int i=0;i<res.size();i++){

			if(res.get(i)==0){
				res.remove(i);
				i--;
			}else{
				break;
			}
		}
		return res;
	}

	//Interview Bit Soln
	//This soln is using same arraylist
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int size;
		int carry = 1;
		int num;
		size = A.size();
		for (int i = size - 1; i >= 0; i--) {
			num = A.get(i);
			num += carry;
			carry = 0;
			if (num == 10) { // Notice, num can only be 10
				num = 0;
				carry = 1;
			}
			A.set(i, num);
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (carry == 1)
			res.add(1);
		for (int x : A) {
			if (x == 0 && res.size() == 0)
				continue;
			res.add(x);
		}
		return res;
		}

}
