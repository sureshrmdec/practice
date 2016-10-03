package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;

public class CareerCup_FB_PrintNumberinEnglish {

	//https://www.careercup.com/question?id=5765581773996032
	static HashMap<Integer,String> map = new HashMap<>();
	
	
	public static void main(String[] args) {
		map.put(1,"One");
		map.put(2,"Two");
		map.put(3,"Three");
		map.put(4,"Four");
		map.put(5,"Five");
		map.put(6,"Six");
		map.put(7,"Seven");
		map.put(8,"Eight");
		map.put(9,"Nine");
		map.put(10,"Ten");
		map.put(11,"Eleven");
		map.put(12,"Twelve");
		map.put(13,"Thirteen");
		map.put(14,"Fourteen");
		map.put(20,"Twenty");
		map.put(30,"Thirty");
		map.put(40,"Forty");
		map.put(50,"Fifty");
		map.put(60,"Sixty");
		map.put(70,"Seventy");
		map.put(80,"EIghty");
		map.put(90,"Ninety");
		map.put(100,"Hundred");
		map.put(1000,"Thousand");
		CareerCup_FB_PrintNumberinEnglish o = new CareerCup_FB_PrintNumberinEnglish();
		o.printInEnglish(514);
	}
	public void printInEnglish(Integer n){
	
		if(map.containsKey(n)){
			System.out.println(map.get(n));
			return;
		}
		String s = n.toString();
		Double ssh = Math.pow(10, s.length()-1);
		int h = ssh.intValue();
		while(n>=0){
			if(h==10){
				if(map.containsKey(n)){
					System.out.println(map.get(n));
					return;
				}
				if(n/h*10>9){
				System.out.println(map.get(n/h*10));
				}
				System.out.println(map.get(n%h));
				return;
			}
			else{
			System.out.println(map.get(n/h));
			System.out.println(map.get(h));
			}
			n = n%h;
			h = h/10;
			
		}
		
	}
}
