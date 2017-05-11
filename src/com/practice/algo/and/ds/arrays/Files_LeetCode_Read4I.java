package com.practice.algo.and.ds.arrays;


public class Files_LeetCode_Read4I {
	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return    The number of characters read
	 */

	/* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */

	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		boolean endOfFile = false;
		int readBytes = 0;

		while (readBytes < n && !endOfFile) {
			int currReadBytes = read4(buffer);
			if (currReadBytes !=4) {
				endOfFile = true;
			}
			int length = Math.min(n - readBytes, currReadBytes); //currReadBytes can be 4 or less, (n - readBytes) is no of bytes remaining to be read
			for (int i=0; i<length; i++) {
				buf[readBytes + i] = buffer[i];
			}
			readBytes += length;
		}
		return readBytes;
		
	}

	//This method is declared in super class...
	public int read4(char[] buf){
		return 4;
	}
}
