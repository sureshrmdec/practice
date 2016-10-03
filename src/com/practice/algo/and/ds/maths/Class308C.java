package com.practice.algo.and.ds.maths;
import java.io.PrintWriter;
import java.util.Scanner;

/*Vanya has a scales for weighing loads and weights of masses w^0,w^1,w^2....w^100 grams where w is some integer not less than 2 
 * (exactly one weight of each nominal value). Vanya wonders whether he can weight an item with mass m using the given weights, 
 * if the weights can be put on both pans of the scales. Formally speaking, your task is to determine whether it is possible to 
 * place an item of mass m and some weights on the left pan of the scales, and some weights on the right pan of the scales 
 * so that the pans of the scales were in balance.
Input

The first line contains two integers w and m — the number defining the masses of the weights and the mass of the item.
Output

Print word 'YES' if the item can be weighted and 'NO' if it cannot.
Sample test(s)
Input

3 7

Output

YES

Input

100 99

Output

YES

Input

100 50

Output

NO
Note

Note to the first sample test. One pan can have an item of mass 7 and a weight of mass 3, and the second pan can have two weights 
of masses 9 and 1, correspondingly. Then 7+3 = 9+1
 */

/*OK I'll try . — we need to find if solution to equation M=w^0*a0 +w^1* a1 + w^2*a2.... Exist or not . 
This equation is equal to M-w^0*a0 =w^1 *a1 + w^2*a2.... Rhs has a common factor of w so lhs should be 
divisible by w . a0 can have 3 values -1 ,0,1 We try all cases of a0 and check if Lhs formed is divisible or not. 
Since w^0 is 1 we have m-1 , m+1, m. If any of the three is divisible my w. That would be new value of m. 
And equation now becomes m'= w^0 * a1 + w^1 *a2.... Which is solved similarly untill we reach a point 
such that m,m+1,m-1 is not divisible by w by m( answer doesn't exist) becomes 1 (possible)
		*/
public class Class308C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//new File("input.txt"));
		PrintWriter pw = new PrintWriter(System.out);//new File("output.txt"));
		int w = sc.nextInt(), m = sc.nextInt();
		
		while (m > 1) {
		      if (m % w == 0)
		        m /= w;
		      else if ((m + 1) % w == 0)
		        m = (m + 1) / w;
		      else if ((m - 1) % w == 0)
		        m = (m - 1) / w;
		      else
		        break;
		    }
		 if (m == 1)
		      System.out.println("YES");
		    else
		      System.out.println("NO");
		
	}

}
