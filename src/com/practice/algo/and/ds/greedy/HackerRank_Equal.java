package com.practice.algo.and.ds.greedy;

import java.util.Scanner;

public class HackerRank_Equal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	    int T,N,i,j,min,temp;
	    int[] sum;
	    T = sc.nextInt();
	    while(T>0)
	    {
	        min = 1000000;
	        N= sc.nextInt();;
	        int[] A = new int[N];
	        for(i=0 ; i< N ; i++)
	        {
	            A[i] = sc.nextInt();
	            if(A[i]<min)
	                min = A[i];
	        }
	        sum = new int[6];
	        for(j=0 ; j<=5 ; j++)
	        {
	            sum[j]=0;
	            for(i=0 ; i< N ; i++)
	            {
	                temp = mod(A[i] - (min-j));
	                sum[j] = sum[j] + functn(temp);
	            }
	        }
	        System.out.println(array_smallest(sum,6));
	        T--;
	    }
	}

	
	private static int functn(int temp)  // similar to greedy Coin-change
	{
	    int x=0;
	    if(temp>=5)
	    {
	        x = temp/5;
	        temp = temp%5;
	    }
	    if(temp>=2)
	    {
	        x += temp/2;
	        temp = temp%2;
	    }
	    x += temp;
	    return x;

	}

	static int array_smallest(int array[],int array_length)
	{
	    int smallest = Integer.MAX_VALUE;
	    int i;
	    for (i = 0; i < array_length; i++)
	    {
	        if (array[i] < smallest) {
	            smallest = array[i];
	        }
	    }
	    return smallest;
	}

	private static int mod(int x)
	{
	    if(x>0)
	        return x;
	    else
	        return (-1)*x;
	}


}
