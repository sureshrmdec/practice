package com.practice.algo.and.ds.arrays;

//Awesome Problem
public class Files_LeetCode_Read4II {

	public static void main(String[] args) {
		String a = "ab";
		Files_LeetCode_Read4II o = new Files_LeetCode_Read4II();
		o.read(a.toCharArray(), 1);

		o.read(a.toCharArray(), 2);

	}
	//n = 7
	//Case 1: File has more than n characters
	//Case 2: File has more than 4 characters but less than n
	//Case 2: File has more than 1 character but less than 4

	//n = 2
	//Case 1: File has more than 1 character but less than 4

	//"ab"
	//[read(1),read(2)]

	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];

	//	/https://discuss.leetcode.com/topic/7094/a-simple-java-code
	public int read(char[] buf, int n) {
		int ptr = 0;
		while (ptr < n) {
			if (buffPtr == 0) {  //buffer read from read4 has been consumed
				buffCnt = read4(buff);
			}
			if (buffCnt == 0) //if read4 returns 0 characters 
				break;
			while (ptr < n && buffPtr < buffCnt) {
				buf[ptr++] = buff[buffPtr++];
			}
			if (buffPtr >= buffCnt)  //if buffPtr has read all what was consumed by read4..it could be 4 or less characters too.
				buffPtr = 0;
		}
		return ptr;
	}

	//This method is declared in super class...
	public int read4(char[] buf){
		return 4;
	}

	//https://discuss.leetcode.com/topic/32780/simple-short-java-c
	/*
	public int read(char[] buf, int n) {
        int i = 0;
        while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
            buf[i++] = buf4[i4++];
        return i;
    }
    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;
	 */
}
