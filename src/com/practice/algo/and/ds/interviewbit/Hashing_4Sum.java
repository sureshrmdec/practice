package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hashing_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] S = {-10,-10,-10,-9,-9,-8,-8,8,8,9,9,10,10};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(S));
		Hashing_4Sum o = new  Hashing_4Sum();
		System.out.println(o.get4Sum(in, 0));
		
	}
	public ArrayList<ArrayList<Integer>> get4Sum(ArrayList<Integer> nums, int target){  
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
    if(nums==null|| nums.size()<4)
        return result;
 
    Collections.sort(nums);
 
    for(int i=0; i<nums.size()-3; i++){
        if(i!=0 && nums.get(i)==nums.get(i-1))
            continue;
        for(int j=i+1; j<nums.size()-2; j++){
            if(j!=i+1 && nums.get(j)==nums.get(j-1))
                continue;
            int k=j+1;
            int l=nums.size()-1;
            while(k<l){
                if(nums.get(i)+nums.get(j)+nums.get(k)+nums.get(l)<target){
                    k++;
                }else if(nums.get(i)+nums.get(j)+nums.get(k)+nums.get(l)>target){
                    l--;
                }else{
                	ArrayList<Integer> t = new ArrayList<Integer>();
                    t.add(nums.get(i));
                    t.add(nums.get(j));
                    t.add(nums.get(k));
                    t.add(nums.get(l));
                    result.add(t);
 
                    k++;
                    l--;
 
                    while(k<l &&nums.get(l)==nums.get(l+1) ){
                        l--;
                    }
 
                    while(k<l &&nums.get(k)==nums.get(k-1)){
                        k++;
                    }
                }
 
 
            }
        }
    }
 
    return result;
    }


}
