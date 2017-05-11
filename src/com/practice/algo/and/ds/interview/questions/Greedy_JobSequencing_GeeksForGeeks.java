package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
//http://www.academia.edu/8799813/Greedy_Algorithm
public class Greedy_JobSequencing_GeeksForGeeks {

	public static void main(String[] args) {
		Job o1 = new Job('1',7,15);
		Job t2 = new Job('2',2,20);
		Job t3 = new Job('3',5,30);
		Job f4 = new Job('4',3,18);
		Job f5 = new Job('5',4,18);
		Job s6 = new Job('6',5,10);
		Job s7 = new Job('7',2,23);
		Job e8 = new Job('8',7,16);
		Job n9 = new Job('9',3,25);

		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(o1);jobs.add(t2);jobs.add(t3);jobs.add(f4);jobs.add(f5);jobs.add(s6);jobs.add(s7);jobs.add(e8);jobs.add(n9);
		Greedy_JobSequencing_GeeksForGeeks o = new Greedy_JobSequencing_GeeksForGeeks();
		o.maximiseProfit(jobs);

	}

	private void maximiseProfit(ArrayList<Job> jobs) {
		// TODO Auto-generated method stub
		Comparator<Job> comp = new Comparator<Greedy_JobSequencing_GeeksForGeeks.Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				if(o1.profit > (o2.profit))
					return -1;
				else if(o1.profit < (o2.profit))
					return 1;
				else
					return 0;
			}
		};
		Collections.sort(jobs,comp);
		
		int n = jobs.size();
		int[] result = new int[n]; // To store result (Sequence of jobs)
	    boolean[]  slot = new boolean[n];  // To keep track of free time slots
	 
		for(int i=0;i<jobs.size();i++){
			 // Find a free slot for this job (Note that we start
		       // from the last possible slot)
		       for (int j=jobs.get(i).dead-1; j>=0; j--)
		       {
		          // Free slot found
		          if (slot[j]==false)
		          {
		             result[j] = jobs.get(i).id-'0';  // Add this job to result
		             slot[j] = true; // Make this slot occupied
		             break;
		          }
		       }
			
		}
		for (int i=0; i<n; i++)
		       if (slot[i])
		    	   System.out.println(result[i]);

	}	

	static class Job{
		char id;      // Job Id
		int dead;    // Deadline of job
		Integer profit;  // Profit if job is over before or on deadline
		public Job(char id, int dead, Integer profit) {
			super();
			this.id = id;
			this.dead = dead;
			this.profit = profit;
		}
	}
}
