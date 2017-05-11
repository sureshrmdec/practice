package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Greedy_GasStations {

	public static void main(String[] args) {
		Greedy_GasStations o = new Greedy_GasStations();
		Integer[] gasA = {1,2,7,5};
		Integer[] costA = {2,1,6,6};
		//Integer[] gasA = {99,98,97,100};
		//Integer[] costA = {100,100,100,97};
		ArrayList<Integer> gas = new ArrayList<>(Arrays.asList(gasA));
		ArrayList<Integer> cost = new ArrayList<>(Arrays.asList(costA));
		System.out.println(o.canCompleteCircuit(gas, cost));
	}

	public int startStation(ArrayList<Integer> gas,ArrayList<Integer> cost){
		int k=0;
		
		for(int i=k;i<gas.size();i++){
			int s = gas.size();
			int result = 0;
			int p = 0;
			jloop:
			for(int j=i;j<gas.size();j++){
				p++;
				result+=gas.get(j)-cost.get(j);
				if(result<0){
					k=j;
					break;
				}
				if(j==gas.size()-1 && p<s){
					j=0;
					while(p!=s){
						result+=gas.get(j)-cost.get(j);
						if(result<0){
							k=j;
							break jloop;
						}
						p++;
						j++;
					}
				}
				if(p==s)
					return i;
			}
			
		}
		
		return -1;
		
		
	}
	
	//http://buttercola.blogspot.com/2014/09/leetcode-gas-station.html
	
	 public int canCompleteCircuit(ArrayList<Integer> gas,ArrayList<Integer> cost) {
	        if (gas == null || gas.size() == 0 || cost == null || cost.size() == 0) {
	            return -1;
	        }
	         
	        int sum = 0;
	        int total = 0;
	        int startIdx = 0;
	         
	        for (int i = 0; i < gas.size(); i++) {
	            sum += (gas.get(i) - cost.get(i));
	            total += (gas.get(i) - cost.get(i));
	             
	            if (sum < 0) {
	                sum = 0;
	                startIdx = i + 1;
	            }
	        }
	         
	        return total >= 0 ? startIdx % gas.size() : -1;
	    }
}
