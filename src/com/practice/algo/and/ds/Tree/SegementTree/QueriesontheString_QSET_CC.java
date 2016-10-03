package com.practice.algo.and.ds.Tree.SegementTree;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.practice.algo.and.ds.Tree.SegementTree.AdditionAndMultiplication_ADDMUL_CC.SegNode;

public class QueriesontheString_QSET_CC {

	static SegNode[] nodes;
	static int MAXN = 100000;
	static int MAXM = 100000;
	static int[] arr;
	
	static class SegNode {
		    int left[] = new int[3];
	    int right[] = new int[3];
	    int cnt;
	    int total;
	   
	    public SegNode(){
	        this.cnt=0;
	    }
	};
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		String[] na = rb.readLine().split(" ");
		int m,n;
		n = Integer.parseInt(na[0]);
		m=Integer.parseInt(na[1]);
		nodes = new SegNode[6*MAXN];
		
		String arrStr = rb.readLine();
		arr = new int[arrStr.length()+1];

	    for(int i=0; i<n; i++)
	        arr[i] = Integer.parseInt(Character.toString(arrStr.charAt(i)));
	    build_tree(1,0,n-1);
	    while(m-->0){
	    	String[] query = rb.readLine().split(" ");
	        int fl; int l; int r;
	        fl = Integer.parseInt(query[0]);
	        l = Integer.parseInt(query[1]);
	        r = Integer.parseInt(query[2]);
	        
	        if(fl==2)
	            System.out.println(query_tree(1,0,n-1,l-1,r-1).cnt);
	        else update_tree(1,0,n-1,l-1,r);
	    }
	}
	public static SegNode query_tree(int node, int a, int b, int i, int j){
	    if(a > b || a > j || b < i){
	    	SegNode ret = new SegNode();
	        return ret;
	    }
	    if(a >= i && b <= j)
	        return nodes[node];
	    SegNode q1 = query_tree(node*2, a, (a+b)/2, i, j);
	    SegNode q2 = query_tree(1+node*2, 1+(a+b)/2, b, i, j);
	    return merge(q1,q2);
	}
	public static SegNode merge(SegNode a, SegNode b){
		SegNode ret = new SegNode();
	    ret.cnt=a.cnt+b.cnt;
	    for(int i=0; i<3; i++)
	        for(int j=0; j<3; j++)
	            if((i+j)%3==0){
	            	ret.cnt+=a.right[i]*b.left[j];
	            }
	    for(int i=0; i<3; i++){
	        ret.left[i]=a.left[i]+b.left[(6-a.total+i)%3];
	        ret.right[i]=b.right[i]+a.right[(6-b.total+i)%3];
	    }
	    ret.total=(a.total+b.total)%3;
	    return ret;
	}
	public static void assign(int node, int p){
		nodes[node]= new SegNode();
		nodes[node].left[p]=1;
		nodes[node].right[p]=1;
		nodes[node].total=p;
	    if(p==0)nodes[node].cnt=1;
	}
	public static void build_tree(int node, int a, int b)
	{
	    if(a > b) return;
	    if(a == b){
	        assign(node,(arr[a]-0)%3);
	        return;
	    }
	    build_tree(node*2, a, (a+b)/2);
	    build_tree(node*2+1, 1+(a+b)/2, b);
	    nodes[node] = merge(nodes[node*2],nodes[node*2+1]);
	}
	
	public static void update_tree(int node, int a, int b, int i, int value){
	    if(a > b || a > i || b < i)
	        return;
	    if(a == b){
	        assign(node,value%3);
	        return;
	    }
	    update_tree(node*2, a, (a+b)/2, i,  value);
	    update_tree(1+node*2, 1+(a+b)/2, b, i, value);
	    nodes[node] = merge(nodes[node*2], nodes[node*2+1]);
	}
}
