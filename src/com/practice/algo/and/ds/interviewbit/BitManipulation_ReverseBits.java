package com.practice.algo.and.ds.interviewbit;

public class BitManipulation_ReverseBits {

	public static void main(String[] args) {
		BitManipulation_ReverseBits o = new BitManipulation_ReverseBits();
		System.out.println(o.reverseBits(1));

	}
	public long reverse(long n) {
        long result = 0;
        int a = 31;
        while(a>=0){
            long l = n & 1;
            if(l==1){
                result = result | (l<<a);
            }
            n = n>>1;
            a--;
        }
        return result;
 	}

	public long reverseBits(long n) {
		
        long result = 0;
        long nn = n;
        int a = 31;
        while(a>=0){
            if((nn&1)==1){
                result+=Math.pow(2,a);
            }
            nn = nn>>1;
            a--;
        }
        return result;
    }
}
