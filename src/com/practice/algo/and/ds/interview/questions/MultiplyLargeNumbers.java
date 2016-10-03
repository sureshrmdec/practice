/*package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class MultiplyLargeNumbers {

	//  0 1 2
	//  2 3 4 num1
	//    1 5 num2
	//1 1 7 0 temp1
	2 3 4   temp2

	1 1 7 0 result
	3 5 1 0 result


	List<Integer>  multiply ( List<Integer> num1, List<Integer> num2 )  {


		if(num1.size()>num2.size()){
			multiple2(num1,num2);    
		}else{
			multiple2(num2,num1);    
		}
	}
	List<Integer>  multiply2 ( List<Integer> num1, List<Integer> num2 )  {
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for(int i=num2.size()-1;i>=0;i--){

			int a = num2.get(i);
			boolean c = false;
			int carry = 0;
			for(int j=num1.size()-1;j>=0;j--){ 

				temp = new ArrayList<Integer>();
				int remain = 0
						int b = num1.get(j);
				Integer res = a*b;
				res +=carry;
				if(res>9){

					String s = Integer.toString(res);
					carry = Integer.parseInt(s.subString(0,s.length());
					remain = Integer.parseInt(s.subString(s.length(),s.length()+1);
					temp.addFirst(remain);    

				}


			}
			copyTempToresult(temp,result); 
		}
		return result;
	}

	private void copyTempToresult(List<Integer> temp, List<Integer> result ){
		int i=0;

		while(i<=temp.size() || i<= result.size()){
			temp.get(i);
			result.get(i);

			// carry logic
			i++;

		}




	}

}
*/