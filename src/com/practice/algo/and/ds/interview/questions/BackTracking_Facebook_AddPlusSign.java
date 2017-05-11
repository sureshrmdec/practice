package com.practice.algo.and.ds.interview.questions;

/*2. You have a string of numbers, i.e. 123. You can insert a + or - sign in front of ever number, or you can leave it empty. 
 * Find all of the different possibilities, make the calculation and return the sum.
For example;
+1+2+3 = 6
+12+3 = 15
+123 = 123
+1+23 = 24
...
-1-2-3 = 6
...
Return the sum of all the results.
*/
//https://www.careercup.com/question?id=5679991586029568
public class BackTracking_Facebook_AddPlusSign {

	
	int mainSum=0;
	public static void main(String[] args) {
		BackTracking_Facebook_AddPlusSign o = new BackTracking_Facebook_AddPlusSign();
		System.out.println(o.sum("123"));
		System.out.println(o.mainSum);
		System.out.println(o.plusMinusNone("12"));
		System.out.println(o.finalSum);
		
	}
	public int sum(String input){
		
		sumHelper(input,1,0,0);
		
		return 0;
	}

	private void sumHelper(String input, int start,int sum,int prev) {
		if(start == input.length()){
			mainSum+=sum;
			return;
		}
		
		for(int i=start;i<input.length();i++){
			String sub = input.substring(start,i+1);
			int p = Integer.parseInt(sub);
			
				sumHelper(input, i+1,+p+sum,p*10);
				sumHelper(input, i+1,-p+sum,-p*10);
			
		}
		
	}
	int finalSum = 0;
	void solve(String s, int curSum) {
		if (s.length() == 0) {
			finalSum += curSum;
			return;
		}

		int cur = 0;

		for (int i = 0; i < s.length(); i++) {
			cur = cur * 10 + s.charAt(i) - '0';
			solve(s.substring(i + 1),curSum + cur);
			solve(s.substring(i + 1), curSum - cur);
		}
	}


	int plusMinusNone(String s) {
		int res = 0;
		solve(s,0);
		return res;
	}

}
