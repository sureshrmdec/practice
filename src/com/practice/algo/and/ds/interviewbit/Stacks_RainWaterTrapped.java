package com.practice.algo.and.ds.interviewbit;

import java.util.Stack;
//trap2 is by using 2 extra arrays but simple
//trap4 is using stack...(I tried it but cudnot implement it)...once yo understand,,,it is awesome soln
//trap3 is tricky...
//I ll give first prefernce to trap2 and then trap4

public class Stacks_RainWaterTrapped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks_RainWaterTrapped o = new Stacks_RainWaterTrapped();
		//int[] height = {2,1,0,2};
		//int[] height = {5,2,1,2,1,5};
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] height = {4,2,3};
		System.out.println(o.trap2(height));
	}
	//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	public int trap(int[] height) {
		if(height.length==0)
			return 0;
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int decrement = 0;
		int last = 0;

		stack.push(0);
		last = height[0];
		for(int i=1;i<height.length;i++){
			int h = height[i];
			if(h<last){
				//decrement=0;
				stack.push(i);
				last = h;
			}else if(h>=last){
				decrement = height[stack.peek()];
				stack.pop();
/*				if(!stack.isEmpty()){
					int index = stack.peek();
					result+=Math.abs((height[index]-decrement) - (h-decrement))!=0?Math.abs((height[index]-decrement) - (h-decrement))*(i-index-1):(i-index-1)*h;
					decrement = stack.pop();
				}*/

				if(!stack.isEmpty() && height[stack.peek()]>h ){
					int index = stack.peek();
					result += (Math.min(h, height[index])-decrement)*(i-index-1);
					//decrement = stack.pop();
				}else{
					while(!stack.isEmpty() && height[stack.peek()]<=h ){
						int index = stack.peek();
						result += (Math.min(h, height[index])-decrement)*(i-index-1);
						decrement = stack.pop();
					}	
				}
				last = h;
				stack.push(i);
			}

		}
		return result;
	}
	
	
	
	//Program Creek
	public int trap2(int[] height) {
	    int result = 0;
	 
	    if(height==null || height.length<=2)
	        return result;
	 
	    int left[] = new int[height.length];
	    int right[]= new int[height.length];
	 
	    //scan from left to right
	    int max = height[0];
	    left[0] = height[0];
	    for(int i=1; i<height.length; i++){
	        if(height[i]<max){
	            left[i]=max;
	        }else{
	            left[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //scan from right to left
	    max = height[height.length-1];
	    right[height.length-1]=height[height.length-1];
	    for(int i=height.length-2; i>=0; i--){
	        if(height[i]<max){
	            right[i]=max;
	        }else{
	            right[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //calculate total
	    for(int i=0; i<height.length; i++){
	        result+= Math.min(left[i],right[i])-height[i];
	    }
	 
	    return result;
	}
	
	//https://discuss.leetcode.com/topic/26932/very-concise-java-solution-no-stack-with-explanations
	public int trap3(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}
	
	//https://discuss.leetcode.com/topic/4939/a-stack-based-solution-for-reference-inspired-by-histogram/2
	
	public int trap4(int[] A) {
        if (A==null)
        	return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()?0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1); // empty means no il
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
