package com.practice.algo.and.ds.interviewbit;

public class Strings_AddBinaryStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_AddBinaryStrings o = new Strings_AddBinaryStrings();
		System.out.println(o.addBinaryIB("10101010000000000011111111101010101010011001100101010110", "10101001010100000000111111111100000111111101101"));
		
		System.out.println(o.addBinary("10101010000000000011111111101010101010011001100101010110", "10101001010100000000111111111100000111111101101"));
	}

	public String addBinary(String a, String b) {
		if (a.length() > b.length()) {
			int z = a.length() - b.length();
			for (int i = 0; i < z; i++) {
				b = "0" + b;
			}
		} else if (b.length() > a.length()) {
			int z = b.length() - a.length();
			for (int i = 0; i < z; i++) {
				a = "0" + a;
			}
		}

		String res = "";
		boolean carry = false;
		for (int i = a.length() - 1; i >= 0; i--) {
			char ac = a.charAt(i);
			char bc = b.charAt(i);
			if (ac == '0' && bc == '0') {
				if (carry) {
					res = 1 + res;
				} else {
					res = 0 + res;
				}
				carry = false;
			} else if (ac == '0' && bc == '1') {
				if (carry) {
					res = 0 + res;
					carry = true;
				} else {
					res = 1 + res;
					carry = false;
				}

			} else if (ac == '1' && bc == '0') {
				if (carry) {
					res = 0 + res;
					carry = true;
				} else {
					res = 1 + res;
					carry = false;
				}

			} else if (ac == '1' && bc == '1') {
				if (carry) {
					res = 1 + res;
				} else {
					res = 0 + res;
				}
				carry = true;
			}

		}
		if (carry) {
			res = 1 + res;
		}
		return res;
	}

	// Awesome Solution by Interview Bit
	// See how solution is managing 2 indexes i and j to traverse over 2
	// strings.Beautifully done!
	public String addBinaryIB(String A, String B) {

		int nA, nB;
		char res[];
		int i, j, k;

		nA = A.length();
		nB = B.length();
		res = new char[Math.max(nA, nB) + 1];

		k = Math.max(nA, nB);
		i = nA - 1;
		j = nB - 1;
		int sum = 0, carry = 0;

		while (i >= 0 || j >= 0 || carry != 0) {

			sum = carry;

			if (i >= 0)
				sum += (A.charAt(i) - '0');
			if (j >= 0)
				sum += (B.charAt(j) - '0');

			res[k] = (char) ((sum % 2) + '0');

			carry = sum / 2;

			i--;
			j--;
			k--;

		}

		if (res[0] == '1')
			return new String(res);

		int len = Math.max(nA, nB);

		return new String(res, 1, len);

	}
}
