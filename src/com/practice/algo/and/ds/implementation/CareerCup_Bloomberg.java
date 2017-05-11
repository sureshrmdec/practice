package com.practice.algo.and.ds.implementation;

/*Given historical data for the stocks of a company for say 8 day. you can buy and sell the stocks just once. Find the maximum profit you can make:
 5	9	6	2	4	8	3	1*/
public class CareerCup_Bloomberg {

	public static void main(String[] args) {
        int[] data = {5,9,6,2,4,8,3,1,100};
        
        int diff = 0;
        
        int min = data[0];
        
        for (int i=0; i < data.length; i++){
            //get min
            if (data[i] < min){
                min = data[i];
            }
            
            int tempDiff = data[i] - min;
            
            if (tempDiff > diff){
                diff = tempDiff;
            }
            
        }
        
        System.out.println(diff);
    }
}
