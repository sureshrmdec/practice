package com.practice.algo.and.ds.interviewbit;
//http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
public class BinarySearch_MedianOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1,3,4,5,6,7};
		//int[] b = {2};
		//int[] a = {10, 20, 40, 60};
		//int[] b = {15, 35, 50, 70, 100};
		//1 2 3 4 5 6 7 8 9 10 12 13 15 18 19 21
		int[] a = {4,6,8,10,16};
		int[] b = {3,5,7,9};
		System.out.println(findKth(4,a, b,0,0));
		System.out.println(findMedianSortedArrays(a, b));
	}
	// 4 6 8 10 16
	// 3 5 7 9
	
	/*Notes:
	 * For the above data set nums1 = {4 6 8 10 16} and nums2 = {3 5 7 9},
	 * total is 9... and median would be 5...that means k = 5
	 * we have to find k/2 elemnts in both the array and then discard one and continue the search
	 * 
	 * When k=5, nums1 = {4 6 8 10 16}
	 * 			 nums2 = {3 5 7 9}
	 * 			 s1 = 0;
	 * 			 s2 = 0;
	 * 			k/2 = 2..so first 2 elements in nums1 are 4,6 and in nums2 are 3,5
	 * 			we will discard 3,5 and move s2 = m2+1 i.e now s2 is at index 2
	 * 			Also, Important we reduce the k now to k - k/2 i.e. in this case k=3;
	 * 
	 * when k=3, nums1 = {4 6 8 10 16}
	 * 			 nums2 = { 7 9}  -->>3 5 taken out (By moving s2 to 2 (m2+1)
	 * 		     s1 = 0;	
	 * 			 s2 = 2;
	 * 			 k/2 = 1...so first 1 element in nums1 is 4 and in nums2 is 7
	 * 			 we will discard 4 and move s1 = m1+1 i.e now s1 is at index 1	
	 * 			 Also, Important we reduce the k now to k - k/2 i.e. in this case k=2;
	 * 
	 * when k=2, nums1 = {6 8 10 16} -->> 4 taken out (By moving s1 to 1 (m1+1)
	 * 			 nums2 = { 7 9}  -->>3 5 taken out (By moving s2 to 2 (m2+1)
	 * 		     s1 = 1;	
	 * 			 s2 = 2;
	 * 			 k/2 = 1...so first 1 element in nums1 is 6 and in nums2 is 7
	 * 			 we will discard 6 and move s1 = m1+1 i.e now s1 is at index 2	
	 * 			 Also, Important we reduce the k now to k - k/2 i.e. in this case k=1;
	 * 
	 * when k=1
	 * 			return Math.min(nums1[s1], nums2[s2]); (which makes sense)
	 * 
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	 
	public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
	    if(s1>=nums1.length)
	        return nums2[s2+k-1];
	 
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	 
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    // m1 and m2 gives the index of k/2th element respective to s1 or s2.
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}

}
