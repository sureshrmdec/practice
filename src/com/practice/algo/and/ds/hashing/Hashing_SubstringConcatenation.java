package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hashing_SubstringConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing_SubstringConcatenation o = new Hashing_SubstringConcatenation();
		//ArrayList<String> words = new ArrayList<>();
		//words.add("ab");
		//words.add("ba");
		//words.add("is");
		String[] words = {"foo", "bar"};
		String str = "barfoobarfoothefoobarman";		
	//	System.out.println(o.findSubstring(str, words));
		//System.out.println(o.getIndexes("mississippi", words));
		long start = System.currentTimeMillis();
		
		System.out.println(o.findSubstring(str, words));
		System.out.println(System.currentTimeMillis()-start);
		start = System.currentTimeMillis();
		
		
		System.out.println(System.currentTimeMillis()-start);

	}


	public List<Integer> findSubstring(String s, String[] words) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(s==null||s.length()==0||words==null||words.length==0){
	        return result;
	    } 
	 
	    //frequency of words
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for(String w: words){
	        if(map.containsKey(w)){
	            map.put(w, map.get(w)+1);
	        }else{
	            map.put(w, 1);
	        }
	    }
	 
	    int len = words[0].length();
	 
	    for(int j=0; j<len; j++){
	        HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
	        int start = j;//start index of start
	        int count = 0;//count totoal qualified words so far
	 
	        for(int i=j; i<=s.length()-len; i=i+len){
	            String sub = s.substring(i, i+len);
	            if(map.containsKey(sub)){
	                //set frequency in current map
	                if(currentMap.containsKey(sub)){
	                    currentMap.put(sub, currentMap.get(sub)+1);
	                }else{
	                    currentMap.put(sub, 1);
	                }
	 
	                count++;
	 
	                while(currentMap.get(sub)>map.get(sub)){
	                    String left = s.substring(start, start+len);
	                    currentMap.put(left, currentMap.get(left)-1);
	 
	                    count--;
	                    start = start + len;
	                }
	 
	 
	                if(count==words.length){
	                    result.add(start); //add to result
	                    //shift right and reset currentMap, count & start point         
	                    String left = s.substring(start, start+len);
	                    currentMap.put(left, currentMap.get(left)-1);
	                    count--;
	                    start = start + len;
	                }
	            }else{
	                currentMap.clear();
	                start = i+len;
	                count = 0;
	            }
	        }
	    }
	 
	    return result;
	}
}
