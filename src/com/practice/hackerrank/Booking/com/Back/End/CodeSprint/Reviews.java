package com.practice.hackerrank.Booking.com.Back.End.CodeSprint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date a = new Date(1467720000*1000L); // *1000 is to convert seconds to milliseconds
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		String formattedDate = sdf.format(a);
		System.out.println(formattedDate);
		System.out.println(a);
	}

}
