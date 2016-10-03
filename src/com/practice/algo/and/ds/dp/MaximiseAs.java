package com.practice.algo.and.ds.dp;

/*
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 * 
 * Below is the problem statement.

Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed. 

If you can only press the keyboard for N times (with the above four
keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the 
output is M (No. of As that you can produce).

Examples:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing 
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A, 
Ctrl C, Ctrl V, Ctrl V*/


public class MaximiseAs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaximiseAs a = new MaximiseAs();
		int n = 12 ;
		//System.out.println(a.findMax(n));
		System.out.println(a.findoptimal(n));
	}

	private int findMax(int n) {
		// TODO Auto-generated method stub
		int dp[] = new int[n+1];
		for(int i=1;i<7;i++){
			dp[i] = i;
		}
		if(n<7){
			return n;
		}
		int cv = 3;
		for(int i =7;i<=n;i++){
			dp[i] = Math.max(3*dp[i-4], dp[i-1]+(dp[i-1] - dp[i-2]));
			/*/*/
		}
		return dp[n];
	}

	int findoptimal(int N)
	{
	    // The optimal string length is N when N is smaller than 7
	    if (N <= 6)
	        return N;
	 
	    // An array to store result of subproblems
	    int[] screen = new int[N+1];
	 
	    int b;  // To pick a breakpoint
	 
	    // Initializing the optimal lengths array for uptil 6 input
	    // strokes.
	    int n;
	    for (n=1; n<=6; n++)
	        screen[n-1] = n;
	 
	    // Solve all subproblems in bottom manner
	    for (n=7; n<=N+1; n++)
	    {
	    	System.out.println("-------------");
	        // Initialize length of optimal string for n keystrokes
	        screen[n-1] = 0;
	 
	        // For any keystroke n, we need to loop from n-3 keystrokes
	        // back to 1 keystroke to find a breakpoint 'b' after which we
	        // will have ctrl-a, ctrl-c and then only ctrl-v all the way.
	        for (b=n-3; b>=1; b--)
	        {
	            // if the breakpoint is at b'th keystroke then
	            // the optimal string would have length
	            // (n-b-1)*screen[b-1];
	        	System.out.println("b : " + b);
	        	System.out.println("n-b-1 : " + (n-b-1));
	        	System.out.println("screen[b-1] : " + (screen[b-1]));
	        
	            int curr = (n-b-1)*screen[b-1];
	        	System.out.println("curr "+curr);
	            if (curr > screen[n-1])
	                screen[n-1] = curr;
	        }
	    }
	    System.out.println(screen[N-1]);
	    return screen[N];
	}
}
