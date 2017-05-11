package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.careercup.com/question?id=5145104823091200
public class CareerCup_Uber_CountLoggedInUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class InputValue {
	    String name;
	    double login;
	    double logout;
	}

	class Type implements Comparable<Type> {
	    boolean loggedin;
	    double time;

	    public Type(boolean loggedin, double time) {
			super();
			this.loggedin = loggedin;
			this.time = time;
		}


		@Override
		public int compareTo(Type that) {
			// TODO Auto-generated method stub
			 if(this.time > that.time)
				 return 1;
			 else if(this.time < that.time)
				 return -1;
			 return 0;
		}
	}

	class ReturnValue {
	    double time;
	    int numLoggedIn;
		public ReturnValue(double time, int numLoggedIn) {
			super();
			this.time = time;
			this.numLoggedIn = numLoggedIn;
		}
	    
	}

	public List<ReturnValue> findLoggedIn(List<InputValue> list) {
	    List<Type> loggedIn = new ArrayList<Type>();
	    List<ReturnValue> retValue = new ArrayList<ReturnValue>();
	    int loggedInNow = 0;
	    
	    for (InputValue iv: list) {
	        loggedIn.add(new Type(true,iv.login));
	        loggedIn.add(new Type(false,iv.logout));
	    }
	    
	    Collections.sort(loggedIn);
	    
	    for(Type t: loggedIn) {
	        if (t.loggedin == true)
	            loggedInNow++;
	        else loggedInNow--;
	        
	        retValue.add(new ReturnValue(t.time, loggedInNow));
	    }
	    
	    return retValue;
	}

}
