package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;

//Encountered this question in Amazon Coding
//https://www.careercup.com/question?id=13437666

public class Amazon_LCAOfNAryTree {

	public static void main(String[] args) {
		ArrayList<OrgEmployee> reports0= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports1= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports2= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports3= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports4= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports5= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports6= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports7= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports8= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports9= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports10= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports11= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports12= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports13= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports14= new ArrayList<OrgEmployee>();
		ArrayList<OrgEmployee> reports15= new ArrayList<OrgEmployee>();
		
		OrgEmployee ceo = new OrgEmployee(0,reports0);
		OrgEmployee o1 = new OrgEmployee(1,reports1);
		OrgEmployee t2 = new OrgEmployee(2,reports2);
		OrgEmployee t3 = new OrgEmployee(3,reports3);
		OrgEmployee f4 = new OrgEmployee(4,reports4);
		OrgEmployee f5 = new OrgEmployee(5,reports5);
		OrgEmployee s6 = new OrgEmployee(6,reports6);
		OrgEmployee s7 = new OrgEmployee(7,reports7);
		OrgEmployee e8 = new OrgEmployee(8,reports8);
		OrgEmployee n9 = new OrgEmployee(9,reports9);
		OrgEmployee t10 = new OrgEmployee(10,reports10);
		OrgEmployee e11 = new OrgEmployee(11,reports11);
		OrgEmployee t12 = new OrgEmployee(12,reports12);
		OrgEmployee t13 = new OrgEmployee(13,reports13);
		OrgEmployee f14 = new OrgEmployee(14,reports14);
		OrgEmployee f15 = new OrgEmployee(15,reports15);
		
		reports0.add(o1);
		reports0.add(t2);
		reports0.add(t3);
		
		reports1.add(f4);
		reports1.add(f5);
		reports1.add(s6);
		
		reports2.add(s7);
		reports2.add(e8);
		reports2.add(n9);
		reports2.add(t10);

		
		
		reports3.add(e11);
		reports3.add(t12);
		reports3.add(t13);

		reports11.add(f14);
		reports11.add(f15);
		
		Amazon_LCAOfNAryTree o = new Amazon_LCAOfNAryTree();
		System.out.println(o.getManager(ceo, f4, f14).id);
	}

	public OrgEmployee getManager(OrgEmployee ceo, OrgEmployee o1, OrgEmployee o2){
		
		OrgEmployee common = null;
		
		if(ceo.id == o1.id || ceo.id==o2.id){
			return ceo;
		}
		
		int c=0;
		for(OrgEmployee report:ceo.reports){
			OrgEmployee man = getManager(report, o1, o2);
			if(man!=null){
				common = man;
				c++;
			}
		}
		if(c==2)
			return ceo;
		return common;
		
	}
	
}
class OrgEmployee{
	int id;
	ArrayList<OrgEmployee> reports= new ArrayList<OrgEmployee>();
	public OrgEmployee(int id, ArrayList<OrgEmployee> reports) {
		super();
		this.id = id;
		this.reports = reports;
	}
	
	
}