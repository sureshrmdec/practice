package com.practice.algo.and.ds.heap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class HavkerRank_MinimumAverageWaitingTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		for(int i=0;i<N;i++){
			int tt = sc.nextInt();
			int ll = sc.nextInt();
			list.add(new Customer(tt,ll));
		}
		Collections.sort(list, new CustomerTimeComparator());
		/*5
		28 78
		31 89
		95 37
		96 38
		98 84
		*/
		BigInteger result=BigInteger.ZERO;
		PriorityQueue<Customer> pq = new PriorityQueue<Customer>();
		int currentCustomer = 0;
		BigInteger currentTime = BigInteger.valueOf(list.get(0).t);
		for(currentCustomer=0;currentCustomer<list.size();currentCustomer++){
			pq.add(list.get(currentCustomer));
				
			while(!pq.isEmpty()){
				Customer c = pq.poll();
				int pizzaTime = c.l;
				BigInteger finalArr = (currentTime).subtract(BigInteger.valueOf(c.t));
				BigInteger totalCustomerTime = finalArr.add(BigInteger.valueOf(pizzaTime));
				currentTime = currentTime.add(BigInteger.valueOf(pizzaTime));
				result= result.add(totalCustomerTime);
				
				int cc = currentCustomer+1;
				while(true){
					if(cc < N && BigInteger.valueOf(list.get(cc).t).compareTo(currentTime)<=0){
						//pq.add(new Customer(t[cc],l[cc]));
						pq.add(list.get(cc));
						currentCustomer++;
						cc++;
					}
					else{
						break;
					}
				}
				
				
			}	
		}
		
		System.out.println(result.divide(BigInteger.valueOf(N)));
		
	}

}
class CustomerTimeComparator implements Comparator<Customer>{

	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if(o1.t < o2.t){
			return -1;
		}else if(o1.t > o2.t){
			return 1;
		}
		if(o1.l < o2.l){
			return -1;
		}else if(o1.l > o2.l){
			return 1;
		}
		return 0;
	}
	
}
class Customer implements Comparable<Customer>{
	int l;
	int t;
	int sortBy;
	Customer(int t,int l){
		this.t = t;
		this.l = l;
	}
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		if(this.l < o.l){
			return -1;
		}else if(this.l > o.l){
			return 1;
		}
		return 0;
	}
}