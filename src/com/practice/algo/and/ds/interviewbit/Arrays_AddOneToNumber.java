package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Arrays_AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_AddOneToNumber s = new Arrays_AddOneToNumber();
		Integer aa[] = { 0, 6, 0, 6, 4, 8, 8, 1};
		List<Integer> a = Arrays.asList(aa);
		
		System.out.println(s.plusOne2(a));
	}

	public ArrayList<Integer> plusOne(List<Integer> a) {
		boolean carry = false;
		
		ArrayList<Integer> f = new ArrayList<>();
		
		LinkedList<Integer> result = new LinkedList<>();
		if((a.get(a.size()-1) + 1)>9){
			carry=true;
			result.addFirst(0);
		}else{
			result.addFirst(a.get(a.size()-1)+1);
		}

		for(int i=a.size()-2;i>=0;i--){
			int in = a.get(i);
			int n;
			if(carry && in==9){
				result.addFirst(0);
				carry=true;
			}else if(carry){
				n=in+1;
				result.addFirst(n);
				carry=false;
			}else{
				n=in;
				result.addFirst(n);
				carry=false;
			}
		}
		if(carry){
			result.addFirst(1);
		}
		boolean add = false;
		for(int i :result){
			if(i==0 && !add){
				continue;
			}else if(i>=0){
				add=true;
				f.add(i);
			}
		}
		return f;
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

}
