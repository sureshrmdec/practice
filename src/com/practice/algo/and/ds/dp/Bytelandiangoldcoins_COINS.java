package com.practice.algo.and.ds.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Bytelandiangoldcoins_COINS {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	static Map<BigInteger,BigInteger> map = new HashMap<BigInteger,BigInteger>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		String line = r.readLine();
/*		for(BigInteger i=BigInteger.ZERO;i.compareTo(BigInteger.valueOf(11))<=0;i=i.add(BigInteger.ONE)){
			map.put(i, i);
		}*/
		
		while(line != null){
			for(String str: line.split(" ")){

				
				int n = Integer.parseInt(str);
				
				getMax(BigInteger.valueOf(n));
				System.out.println(map.get(BigInteger.valueOf(n)));
			}
			line = r.readLine();
		}

		
	}
	
	private static BigInteger getMax(BigInteger n){
		
		if(map.get(n)!=null && (map.get(n)).compareTo(n) > 0){
			return (map.get(n));
		}
		if(n.compareTo(BigInteger.valueOf(11))<=0){
			map.put(n, n);
			return n;
		}
		
			BigInteger c = getMax(n.divide(BigInteger.valueOf(2))).add(getMax(n.divide(BigInteger.valueOf(3)))).add(getMax(n.divide(BigInteger.valueOf(4))));
			c = c.compareTo(n)>0?c:n;
			map.put(n, c);
			return (map.get(n));
		
	}

}
