package com.practice.also.and.ds.implementation;

import java.util.Scanner;


/*Cat Snuke came up with some problems. He wants to construct as many problem sets as possible using those problems. Each problem set must contain exactly three problems: one for the Easy slot, one for the Medium slot, and one for the Hard slot. Each problem can only be assigned to a single slot in a single problem set. He came up with E + EM + M + MH + H problems in total. The distribution of the problems is as follows:

    E problems can only be used in the Easy slot.
    EM problems can be used either in the Easy slot or the Medium slot.
    M problems can only be used in the Medium slot.
    MH problems can be used either in the Medium slot or the Hard slot.
    H problems can only be used in the Hard slot.

Return the maximal number of problem sets he can construct.
 
Definition
    	
Class:	ProblemSetsEasy
Method:	maxSets
Parameters:	int, int, int, int, int
Returns:	int
Method signature:	int maxSets(int E, int EM, int M, int MH, int H)
(be sure your method is public)
    
 
Constraints
-	E, EM, M, MH, H must be between 0 and 100000, inclusive.
*/
public class TCSRM657Div2L2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int em = sc.nextInt();
		int m = sc.nextInt();
		int mh = sc.nextInt();
		int h = sc.nextInt();
		
		TCSRM657Div2L2 ii = new TCSRM657Div2L2();
		int res = ii.maxSets(e, em, m, mh, h);
		System.out.println(res);
	}
		
	public boolean allowedX(int E, int EM, int M, int MH, int H, int x)
	{
		//not enough easy probs
	    if (E + EM < x) {
	        return false;
	    }
	    
	    int aa = Math.min(EM, E + EM - x); //maximum a
	    
	    //not enough hard probs
	    if (H + MH < x) {
	        return false;
	    }
	    
	    int bb = Math.min(MH, H + MH - x); //maximum b
	    
	    return (M + aa + bb >= x); 
	 
	}    
	 
	public int maxSets(int E, int EM, int M, int MH, int H)
	{
	    int res = 0;
	    for (int x = 1; x <= MH + H; x++) {
	        if (allowedX(E,EM,M,MH,H, x)) {
	            res = x;
	        }
	    }
	    return res;
	}
}
