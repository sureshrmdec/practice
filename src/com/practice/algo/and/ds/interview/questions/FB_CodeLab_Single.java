package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FB_CodeLab_Single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {723, 256, 668, 723, 140, 360, 597, 233, 128, 845, 737, 804, 986, 701, 906, 512, 845, 510, 510, 227, 430, 701, 366, 946, 464, 619, 946, 627, 209, 771, 424, 555, 959, 711, 530, 937, 716, 261, 505, 658, 706, 140, 511, 277, 396, 233, 819, 196, 475, 906, 583, 261, 147, 658, 517, 197, 196, 702, 944, 711, 128, 555, 149, 483, 530, 291, 716, 258, 430, 464, 601, 749, 149, 415, 802, 573, 627, 771, 660, 601, 360, 986, 291, 51, 415, 51, 227, 258, 937, 366, 923, 669, 33, 517, 417, 702, 475, 706, 110, 417, 275, 804, 500, 473, 746, 973, 669, 275, 973, 147, 817, 657, 277, 923, 144, 660, 197, 511, 793, 893, 944, 505, 322, 817, 586, 512, 322, 668, 33, 424, 962, 597, 144, 746, 345, 753, 345, 269, 819, 483, 368, 802, 573, 962, 583, 615, 208, 209, 269, 749, 256, 657, 619, 893, 959, 473, 753, 299, 396, 299, 500, 368, 586, 110, 793, 737, 615};
		List<Integer> numsL = new ArrayList<Integer>(Arrays.asList(nums));
		FB_CodeLab_Single o = new FB_CodeLab_Single();
		System.out.println(o.singleNumberXOR(numsL));
	}

	//O(n) and without using memory
	public int singleNumberXOR(final List<Integer> nums) {
		int result = 0;
		for(int i=0;i<nums.size();i++){
			result^=nums.get(i);
		}
		return result;
	}
	
	public int singleNumber(final List<Integer> nums) {
		Set<Integer> set = new HashSet<>();
		int result = 0;
		for(int i=0;i<nums.size();i++){
			boolean added = set.add(nums.get(i));
			if(!added){
				set.remove(nums.get(i));
			}
			
		}
		Iterator<Integer> it = set.iterator();
		
		return it.next();
	}
}
