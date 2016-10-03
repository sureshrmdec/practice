package com.practice.algo.and.ds.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] a = {50,60,70,80,90,100};
		Integer[] a = {1,5,10};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(a));
		BucketSort bb = new BucketSort();
		bb.bucketSort(input);
	}

	private void bucketSort(ArrayList<Integer> input){
	
		 // Determine minimum and maximum values
        Integer minValue = input.get(0);
        Integer maxValue =  input.get(0);
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) < minValue) {
                minValue =input.get(i) ;
            } else if (input.get(i) > maxValue) {
                maxValue = input.get(i) ;
            }
        }
        
     // Initialise buckets
        
        int bucketCount = (maxValue - minValue) / 6 + 1;
        int[] min = new int[bucketCount];
        int[] max = new int[bucketCount];
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }
     // Distribute input array values into buckets
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < input.size(); i++) {
        	/*if(min[(input.get(i) - minValue) / 6] > input.get(i)){
        		min[(input.get(i) - minValue) / 6 ] = input.get(i);
        		
        	}
        	if(max[(input.get(i) - minValue) / 6] < input.get(i)){
        		max[(input.get(i) - minValue) / 6 ] = input.get(i);
        		
        	}*/
            buckets.get((input.get(i) - minValue) / bucketCount).add(input.get(i));
        }
     // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            Collections.sort(Arrays.asList(bucketArray));
            for (int j = 0; j < bucketArray.length; j++) {
                input.add(currentIndex++,bucketArray[j]);
            }
        }
        System.out.println(input);
	}
}
