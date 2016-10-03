package com.practice.algo.and.ds.interviewbit;

import java.util.Arrays;
import java.util.Comparator;

//Its not a Interview Bit problem.
//http://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/

public class DP_WeightedJobScheduling {

	class Job
	{
	    int start, finish, profit;
	 
	    // Constructor
	    Job(int start, int finish, int profit)
	    {
	        this.start = start;
	        this.finish = finish;
	        this.profit = profit;
	    }
	}
	
	// Used to sort job according to finish times
	class JobComparator implements Comparator<Job>
	{
	    public int compare(Job a, Job b)
	    {
	        return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
	    }
	}
	
	private int binarySearch(Job[] jobs,int index){
		
		int l = 0, h = index - 1;
		
		while(l<=h){
			int mid = (l+h)/2;
			
			if(jobs[mid].finish <= jobs[index].start){
				if (jobs[mid + 1].finish <= jobs[index].start)
                    l = mid + 1;
                else
                    return mid;
			}else{
				h= mid-1;
			}
			
		}
		return -1;
	}
	private int schedule(Job jobs[]){
		int res  = 0;
		Arrays.sort(jobs);
		
		int n = jobs.length;
        int table[] = new int[n];
        table[0] = jobs[0].profit;
        
		for(int i=1;i<n;i++){
			int inclProf = jobs[i].profit;
			int l = binarySearch(jobs,i);
			if (l != -1)
                inclProf += table[l];
			 // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i-1]);
		}
		
		
		return res;
	}
}
