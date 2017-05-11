package com.practice.algo.and.ds.codechef;

import java.util.Scanner;

class CoursesInAUniversityMay2017 {

	public static void main(String[] args) {
		new CoursesInAUniversityMay2017().courses();
	}

	public void courses(){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int tc=0;tc<t;tc++){
			int courses = sc.nextInt();
			int max = Integer.MIN_VALUE;
			for(int i = 0;i<courses;i++){
				int num = sc.nextInt();
				max = Math.max(max, num);
				
			}
			
			System.out.println(courses-max);

		}
	}

}
