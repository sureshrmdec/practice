package com.practice.algo.and.ds.heap;

/*Q: If you have all the companies that are traded, and live inputs are coming of which company is being traded and what is the volume,
how do you maintain the data, so that you can carry out operation of giving the top 10 most traded companies by volume of shares most efficiently.

A: I juggled between Hash Map and Max Heap. I said Max Heap, since I can take out top 10 companies in a jiffy with a Max Heap. 
But then he asked you will need to find a company everytime there is a trade, which will take quite some time in Heap. 
He pointed out that in real world scenario, number of trades happening, and hence searching of the company and updating it, 
will be many times more than finding top 10. Which bought me to HashMap. Updations can happen in Real time, 
while finding top 10 can be done in O(n) or O(nlog(n)) time.

Even that wasn't optimal obviously. The interviewer was very nice and friendly type guy. He stressed that at every trade, at most, 
only 1 company will change in my top 10. This hit me and got me to the correct answer that we keep all actual data in HashMap, 
but also maintain a MinHeap of 10 most traded company.

*/


public class Bloomberg_SharesComingLiveStream_Top10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
