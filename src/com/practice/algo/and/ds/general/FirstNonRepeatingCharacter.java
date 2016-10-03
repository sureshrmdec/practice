package com.practice.algo.and.ds.general;

public class FirstNonRepeatingCharacter {

	/*	Given a string, find the first non-repeating character in it. For example, if the input string is
	“GeeksforGeeks”, then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNonRepeatingCharacter d = new FirstNonRepeatingCharacter();
		String str = "geeksforgeeks";
		d.getChar(str);
	}

	Count[] count;
	private void getChar(String str) {
		count = new Count[256];
		
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			Count c = count[ch] ;
			if(c==null){
				c = new Count(i,1);
			}else{
				c.times++;
			}
			count[ch] = c;
		}
		int index = Integer.MAX_VALUE;
		for(int i=0;i<count.length;i++){
			if(count[i]!=null && count[i].times == 1 && count[i].index < index){
				index = count[i].index;
			}
		}
		System.out.println(str.charAt(index));
	}

	class Count{
		int index;
		int times;
		Count(int index,int times){
			this.index = index;
			this.times = times;
		}
	}
}
