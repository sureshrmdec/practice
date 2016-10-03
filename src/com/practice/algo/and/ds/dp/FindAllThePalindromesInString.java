package com.practice.algo.and.ds.dp;

public class FindAllThePalindromesInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Mississippi";
		FindAllThePalindromesInString f = new FindAllThePalindromesInString();
		f.getAllPalindromes(str);
	}

	private void getAllPalindromes(String str) {
		// TODO Auto-generated method stub
	
		int[][] dp = new int[str.length()][str.length()];
		
		//Mark one length string as palindromes
		for(int i=0;i<str.length();i++){
			dp[i][i] = 1;	
		}

		//Mark two length string as palindromes if both start and end are same
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1))
				dp[i][i+1] = 1;	
		}
		
		
		for(int jump =2 ;jump<str.length();jump++){
			for(int i=0;i<str.length()-jump;i++){
				int j = i+jump;
				
				if(str.charAt(i)==str.charAt(j)){
					if(dp[i+1][j-1]>=1){
						dp[i][j] = dp[i+1][j-1]>=1?(1+dp[i+1][j-1]):0;
						for(int k=i;k<=j;k++){
							System.out.print(str.charAt(k));
						}
						System.out.println();
					}
				}else{
					dp[i][j] = 0;
				}
				 
			}	
		}
		
	}

}
