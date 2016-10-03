package com.practice.algo.and.ds.interviewbit;

import java.util.HashMap;

public class DP_ArrangeII {

	public static void main(String[] args) {
		DP_ArrangeII p = new DP_ArrangeII();
	//8323071	
		System.out.println(p.arrange("BBWBBBWW", 3));
	   //System.out.println(p.arrange2("BBWBBBWW", 3));
		//System.out.println(p.arrange("WWWBWWBB", 3));
		//System.out.println(p.arrange2("WWWBWWBB", 3));
	}
	
	
	public int arrange(String A, int B) {
        //C(m, k) = P (j to m) + C(j, k - 1)
        int[][] dp = new int[A.length() + 1][B + 1];
        if(A.length() < B) return -1;
        for(int i = 1; i <= A.length(); i++){
            dp[i][1] = product(A, 0, i - 1);
        }
      
        // Product
            for(int k = 2; k <= B; k++){
                for(int j = k; j <= A.length(); j++){
                    int min = Integer.MAX_VALUE;
                   // System.out.println("--------");
                    for(int i = k - 1; i <= j - 1; i++){
                    	//System.out.println("i = "+i+",k = "+(k-1));
                        dp[j][k] =  Math.min((dp[i][k - 1] + product(A, i, j - 1)), min);//i = 2 j = 4
                        min = dp[j][k];
                    }
                }
            }
        
        return dp[A.length()][B];
        
    }
    
    public int product(String A, int start, int end){
        int W = 0, B = 0;
        for(int i = start; i <= end; i++){
            if(A.charAt(i) == 'W') W++;
            else if(A.charAt(i) == 'B') B++;
        }
        return W * B;
    }
    
	 public int arrange2(String a, int b) {
		 DPNode[][] dp = new DPNode[a.length()+1][b+1];
		 
		 /*for(int i=1;i<b;i++){
			dp[i][i] =0;
		 }*/
		 for(int i=1;i<=a.length();i++){
			 	String str = a.substring(0,i);
			 	int bs=0;int w=0;
			 	for(int j=0;j<str.length();j++){
			 		char c = str.charAt(j);
			 		if(c=='B'){
						 bs++;
					 }else{
						w++;
					 }	
			 	}
			 	dp[i][1] = new DPNode(bs,w,bs*w);
		}
		 
		 for(int i=0;i<=b;i++){
			 dp[0][i] = new DPNode(0,0,Integer.MAX_VALUE);
			 dp[i][0] = new DPNode(0,0,Integer.MAX_VALUE);
		 }
		 
		 for(int i=1;i<=a.length();i++){
			 char currentHorse = a.charAt(i-1);
			 for(int j=1;j<=b;j++){
				 if(dp[i][j]!=null && dp[i][j].value!=Integer.MAX_VALUE){
					 continue;
				 }
				 //horses are less than equal to stables
				 if(i<j){
					 dp[i][j] = new DPNode(0,0,Integer.MAX_VALUE);
					 continue;
				 }else{
					 //more horses less stable..3 horses 1 stable 
					 
/*					 					     WWWBWWBB
 * 										  	 dp[8][3]WWW,BWW,BB(2)
					 			  		/      			\	
					 dp[7][2]WWW,BWWB(4)       	  		dp[7][3]WWW,BWW,B(2)
					/		   \     			      /	    	\	
		  dp[6][1](5)			dp[6][2]WWW,BWW(2)	 dp[6][2]    dp[6][3]WWW,B,WW(0)
		/   		 \        /     \								/		\
dp[5][0]  		dp[5][1] dp[5][1]   dp[5][2]WWW,BW(1)	dp[5][2]WWW,BW(1)	dp[5][3]WWW,B,W(0)
		       /	  \	            /      \								/		\
			dp[4][0]  dp[4][1]    dp[4][1]  dp[4][2]WWW,B		WWW,B(0)dp[4][2]	dp[4][3]WW,W,B(0)
										   /      \								/		\
									WWW,e dp[3][1]  dp[3][2]WW,W			dp[3][2]  dp[3][3]W,W,W
													/		\
				    						WW,e dp[2][1]	dp[2][2]W,W
				    						  			/      \
				    						  		 dp[1][1]W    dp[1][2]
*/
					DPNode right = dp[i-1][j];
					DPNode left = dp[i-1][j-1];
					int bs = right.b;
					int ws = right.w;
					int rightValueAfterDeducting = right.value - (bs*ws);
					int bl = 0;
					int wl = 0;
					 if(currentHorse=='B'){
						 bs = bs+1;
						 bl=1;
					 }else{
						 ws= ws +1;
						 wl=1;
					 }
					 
					 int newRightvalue = rightValueAfterDeducting  + (bs*ws);
					
					 DPNode fromRightNode = new DPNode(bs,ws,newRightvalue);
					
					
					int leftValue = left.value;
					
					DPNode fromLeftNode = new DPNode(bl,wl,leftValue);
					
					 dp[i][j] = leftValue<=newRightvalue?fromLeftNode:fromRightNode;
					 System.out.println("i--> "+i+" j--> "+j+" fromLeftNode--> "+fromLeftNode.value+" fromRightNode--> "+fromRightNode.value+" actualValue--> "+dp[i][j].value);
				 }
			 }	 
		 }
		return dp[a.length()][b].value; 
	 }
	

	
	class DPNode{
		public DPNode(int bs, int ws, int newRightvalue) {
			// TODO Auto-generated constructor stub
			this.b = bs;
			this.w = ws;
			this.value = newRightvalue;
		}
		public DPNode() {
			// TODO Auto-generated constructor stub
		}
		public int b;
		public int w;
		public int value;
	}
}
