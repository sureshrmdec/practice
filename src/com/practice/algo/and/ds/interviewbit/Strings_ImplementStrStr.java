package com.practice.algo.and.ds.interviewbit;

public class Strings_ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_ImplementStrStr u = new Strings_ImplementStrStr();
		System.out.println(u.strStr("abcdefghijklamno", "efg"));

	}
	
	public int strStr(String haystack, String needle) {
		  for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) 
		    	  return i;
		      if (i + j == haystack.length()) 
		    	  return -1;
		      if (needle.charAt(j) != haystack.charAt(i + j)) 
		    	  break;
		    }
		  }
		}
	
	public int strStr2(final String haystack, final String needle) {
	
		if(needle.length()>haystack.length()){
			return -1;
		}
		if(needle.isEmpty()){
			return 0;
		}
		int res = -1;
		int MOD = 13;
		int n = haystack.length();
		int m = needle.length();
		
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
	    	patternHash = (d*patternHash + needle.charAt(i))%MOD;
	    	textHash = (d*textHash + haystack.charAt(i))%MOD;
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
	                if (haystack.charAt(i+j) != needle.charAt(j))
	                    break;
	            }
	            if (j == m)  // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            {
	                //System.out.println("Pattern found at index : "+i);
	            	res = i;
	            	break;
	            }
	        }
	         
	        // Calculate hash value for next window of text: Remove leading digit,
	        // add trailing digit          
	        if ( i < n-m )
	        {
	        	textHash = (d*(textHash - haystack.charAt(i)*h) + haystack.charAt(i+m))%MOD;
	             
	            // We might get negative value of t, converting it to positive
	            if(textHash < 0)
	            	textHash = (textHash + MOD);
	        }
	    }
	    
	    return res;
	    
	    
	    
	    
	
	}
}
