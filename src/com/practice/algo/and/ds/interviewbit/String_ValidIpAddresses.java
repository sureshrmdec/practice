package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class String_ValidIpAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String_ValidIpAddresses o = new String_ValidIpAddresses();
		o.restoreIpAddresses("0100100");
		
	}
	public ArrayList<String> restoreIpAddresses(String a) {
		ArrayList<String> r = new ArrayList<>();
		restoreIpAddressesHelper(a,"",3,r);
		System.out.println(r);
		return r;
	}
	public void restoreIpAddressesHelper(String a,String soFar,int remainingDots,ArrayList<String> r) {
		String ip = soFar;
		for(int i=1;i<4;i++){
			if(remainingDots==0){
				if(a.charAt(0)=='0' && a.length()>1){
					return;
				}
				if(!a.isEmpty() && Integer.parseInt(a)>255){
					return;
				}else{
					r.add(ip+a);
					return;
				}
			}
			if(a.length()<= i || Integer.parseInt(a.substring(0,i))>255){
				return;
			}
			if(a.substring(0,i).charAt(0)=='0' && a.substring(0,i).length()>1){
				return;
			}
			String part = soFar + a.substring(0,i);
			
			String aa = a.substring(i);
			restoreIpAddressesHelper(aa, part+".",remainingDots-1,r);
		}
		
		//return ip;
	}
	
}
