package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_LeetCode_ExpressionAddOperators {

	public static void main(String[] args) {
		BackTracking_LeetCode_ExpressionAddOperators o = new BackTracking_LeetCode_ExpressionAddOperators();
		o.addOperators("123", 6);

	}
	public List<String> addOperators(String num, int target) {

		List<String> result = new ArrayList<>();
		StringBuilder content = new StringBuilder();
		addOperatorsHelper(num,target,result,content,0,0,0);
		System.out.println("--------------");
		System.out.println(result);
		return result;

	}
	private void addOperatorsHelper(String num, int target, List<String> result, StringBuilder content,int start,long eval,long multed) {
		if(start==num.length()){
			System.out.println(content.toString());
			if(target == eval)
				result.add(content.toString());

		}
		for(int i=start;i<num.length();i++){
			if(i != start && num.charAt(start) == '0') break;
			String sub = num.substring(start,i+1);
			long cur = Long.parseLong(sub);
			int len = content.length();
			if(start == 0){ // This is imporant as this gives you the start and reduce the complexity by taking start==0 outside
				addOperatorsHelper(num,target,result, content.append(cur),i + 1, cur,cur);
				content.setLength(len);
			}
			else{
				addOperatorsHelper(num, target, result, content.append("+").append(cur), i+1,eval+cur,cur);
				content.setLength(len);
				addOperatorsHelper(num, target, result, content.append("-").append(cur), i+1,eval-cur,-cur);
				content.setLength(len);
				addOperatorsHelper(num, target, result, content.append("*").append(cur), i+1,eval - multed + multed * cur, multed * cur);
				content.setLength(len);
			}

		}
	}

}
