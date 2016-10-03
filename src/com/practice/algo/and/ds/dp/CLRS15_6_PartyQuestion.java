package com.practice.algo.and.ds.dp;

import java.util.HashMap;
import java.util.Map;

/*You are asked to plan the company party for a big company and the rst step is to choose who will be
invited. There are two factors to be considered: a) each person has a desirability ai; if this is high you
really want to invite the person to the party (think the funny guy); b) the company hierarchy is organized
as a rooted the tree. The root is the CEO of the company and everyone else is the child of their direct
boss in the tree. You should never invite someone and their direct boss to the party (that would make it
hard for them to have fun.)
Your job is to devise an algorithm that takes n, the number of people in the company, a1; : : : ; an and the
company hierarchy as input and outputs the set of people to invite. The way the company hierarchy is
given is as follows. You are given sets C1;C2; : : : ;Cn where Ci contains the direct subordinates of the ith
employee. You are guaranteed that these make a tree (each person except the CEO is in precisely one
of the Ci sets and there are no cycles.) To make your life easier we also know that the CEO is always
employee number 1 and that each person's subordinates have a higher number than themselves.
You should never invite a person and their direct boss at the same time and among all possible such
solutions you should output the one with the maximum total desirability. The total desirability of an
invitation list is the sum of the desirability of the people invited.
*/
public class CLRS15_6_PartyQuestion {

	/**
	 * @param args
	 */
	
	static Map<Integer,int[]> subMap = new HashMap<Integer,int[]>();
	static int[] willingness = {-2,1,1,4};
	public static void main(String[] args) {
		
		subMap.put(1, new int[]{2,3});
		subMap.put(2, new int[]{4});
		subMap.put(3, null);
		subMap.put(4, null);
		


		
		int n = getMax();

		
	}

	
	private static int getMax() {
		int l = subMap.size();
		int[] D = new int[l+1];
		int[] DEx = new int[l+1];
		
		for(int i = l;i>0;i--){
			int sof = 0;
			int sofe = 0;
			int[] sub = subMap.get(i);
			if(sub!=null)
			for(int k=0;k<sub.length;k++){
				sofe+=DEx[sub[k]];
				sof+=D[sub[k]];
			}
			DEx[i] = sof;
			D[i] = Math.max(willingness[i-1]+sofe, sof);
		}
		return D[1];
	}
	
}