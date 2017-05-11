package com.practice.algo.and.ds.arrays;

import java.util.Random;

public class Arrays_ShuffleAnArray {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		Arrays_ShuffleAnArray obj = new Arrays_ShuffleAnArray(nums);
		  int[] param_1 = obj.reset();
		  int[] param_2 = obj.shuffle();
		  printArray(param_2);
		  
		  param_2 = obj.shuffle();
		  printArray(param_2);
		  
		  param_2 = obj.shuffle();
		  printArray(param_2);
		  
		  param_2 = obj.shuffle();
		  printArray(param_2);
		  
		  param_2 = obj.shuffle();
		  printArray(param_2);

	}
	int[] nums ;	
	Random r ;
    public Arrays_ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.r = new Random();
    }
    
    public int[] reset() {
    	return nums;
    }
    
/* https://en.wikipedia.org/wiki/Fisher–Yates_shuffle#The_modern_algorithm   
 
 	for i from n−1 downto 1 do
        j ← random integer such that 0 ≤ j ≤ i
        exchange a[j] and a[i]
  */
    
    public int[] shuffle() {
    	
    	int[] random = nums.clone();
    	for(int i = nums.length-1;i>0;i--){
    		int  j = r.nextInt(i+1);
    		int temp = random[i];
    		random[i] = random[j];
    		random[j] = temp;
    		
    	}
    	return random;
    	     
    }
    
    public static void printArray(int[] nums){
    	for(int n:nums)
    		System.out.print(n);
    	System.out.println("----------");
    }
}
