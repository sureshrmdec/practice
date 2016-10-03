package com.practice.algo.and.ds.spoj;

import java.util.*;

public class Thelastdigit_LASTDIG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int b = sc.nextInt();
			int index = sc.nextInt();
			List x = new ArrayList();
			b = b<10?b:b-10;
			x.add(b);
			int p = 2;
				while(true){
					String s = Integer.toString(((Double)Math.pow(b, p)).intValue());
					char c = s.charAt(s.length()-1);
					if(c-'0' != b){
						x.add(c-'0');
						p+=1;
					}else
						break;
				}
				System.out.println(index==0?1:x.get((index-1)%(x.size())));
			}
		}
}
