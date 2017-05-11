package com.practice.algo.and.ds.interviewbit;

public class Strings_CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_CountAndSay f = new Strings_CountAndSay();
		System.out.println(f.countAndSay(4));

	}
	public String countAndSay(int a) {
	
		if(a==0){
			return "";
		}
		if(a==1){
			return "1";
		}
		if(a==2){
			return "11";
		}
		
		String s = "11";
		String ns = "";
		for(int j=3;j<=a;j++){
			
			int count = 1;
			Character pc = s.charAt(0);
			for(int l = 1;l<s.length();l++){
				Character cc = s.charAt(l); 
				if(pc!=cc){
				ns = ns.concat(count+"").concat(pc.toString());
				count=1;
				pc =cc;
				}else{
				count++;
				}
			}
			ns = ns.concat(count+"").concat(pc.toString());
			s = ns;
			ns = "";
			
		}
	return s;	
	}
}
