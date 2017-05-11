package com.practice.algo.and.ds.arrays;

//https://www.careercup.com/question?id=5692698000359424
//http://codereview.stackexchange.com/questions/48756/find-all-the-missing-numbers
//http://stackoverflow.com/questions/3492302/easy-interview-question-got-harder-given-numbers-1-100-find-the-missing-numbe

public class CarrerCup_FB_FinsAllMissingNumbers {
	public static int count = 0;
    public static int position = 0;
    public static boolean flag = false;

    public static void main(String[] args) {

        int a[] = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };

        findMissingNumbers(a, position);

    }

    private static void findMissingNumbers(int a[], int position) {

        if (position == a.length - 1)
            return;

        for (; position < a[a.length - 1]; position++) {

            if ((a[position] - count) != position) {
                System.out.println("Missing Number: " + (position + count));
                flag = true;
                count++;
                break;
            }
        }

        if (flag) {
            flag = false;
            findMissingNumbers(a, position);
        }
    }
}
