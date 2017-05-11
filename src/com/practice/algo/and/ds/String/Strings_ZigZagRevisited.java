package com.practice.algo.and.ds.String;

public class Strings_ZigZagRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_ZigZagRevisited o = new Strings_ZigZagRevisited();
		System.out.println(o.convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 1));
		System.out.println(o.convert("PAYPALISHIRING",3));
	}
	public String convert(String a, int b) {
		int steps = b-1;
		if(b==1)
			return a;
		StringBuilder[] str = new StringBuilder[b];
		for(int i =0;i<b;i++){
			str[i] = new StringBuilder();
		}
		int direction = 1; //1 implies up and -1 implies down
		int index=0;
		int count = 0;

		for(int i=0;i<a.length();i++){
			str[index].append(a.charAt(i));
			index=index+direction;

			count++;;
			if(count==steps){
				count=0;
				direction = -direction;
			}

		}
		StringBuilder result = new StringBuilder();
		for(int i=0;i<b;i++){
			result.append(str[i].toString());
		}
		
		return result.toString();


	}
}
