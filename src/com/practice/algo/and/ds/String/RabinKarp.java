package com.practice.algo.and.ds.String;

public class RabinKarp {

	/**
	 * @param args
	 */
	private static int MOD = 13;
	public static void main(String[] args) {

		System.out.println(31415%13);
		System.out.println(67399%13);
		RabinKarp rk = new RabinKarp();
		String text = "saurabh";
		String pattern=	"a";
		rk.search(text,pattern);
		
	}


	
	private void search(String text, String pattern) {
		// TODO Auto-generated method stub
		
		int n = text.length();
		int m = pattern.length();
		
		int h = 1;
		int d = 256;
		// The value of h would be "pow(d, M-1)%q"
	    for (int i = 0; i < m-1; i++)
	        h = (h*d)%MOD;
	  
	    // Calculate the hash value of pattern and first window of text
	    int patternHash = 0;
	    int textHash = 0;
	    for (int i = 0; i < m; i++)
	    {
	    	patternHash = (d*patternHash + pattern.charAt(i))%MOD;
	    	textHash = (d*textHash + text.charAt(i))%MOD;
	    }
	    
	    
//	  Slide the pattern over text one by one
	    for (int i = 0; i <= n - m; i++)
	    {
	        
	        // Check the hash values of current window of text and pattern
	        // If the hash values match then only check for characters on by one
	        if ( patternHash == textHash )
	        {
	            /* Check for characters one by one */
	        	int j=0;
	            for (j = 0; j < m; j++)
	            {
	                if (text.charAt(i+j) != pattern.charAt(j))
	                    break;
	            }
	            if (j == m)  // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            {
	                System.out.println("Pattern found at index : "+i);
	            }
	        }
	         
	        // Calculate hash value for next window of text: Remove leading digit,
	        // add trailing digit          
	        if ( i < n-m )
	        {
	        	textHash = (d*(textHash - text.charAt(i)*h) + text.charAt(i+m))%MOD;
	             
	            // We might get negative value of t, converting it to positive
	            if(textHash < 0)
	            	textHash = (textHash + MOD);
	        }
	    }
	    
	    
	    
	    
	    
	    
	}

}
