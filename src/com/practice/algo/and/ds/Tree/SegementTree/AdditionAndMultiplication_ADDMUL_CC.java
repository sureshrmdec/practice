package com.practice.algo.and.ds.Tree.SegementTree;

/*https://www.codechef.com/problems/ADDMUL
*/
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



public class AdditionAndMultiplication_ADDMUL_CC {

	//Segement Tree
	static SegNode[] nodes;
	static int mod=1000000007;
	
	static class SegNode {
		boolean change = false;
		public SegNode(int subtree_size,int add, int mul, int sum, int reset,boolean change) {
			super();
			this.sum = sum;
			this.mul = mul;
			this.add = add;
			this.reset = reset;
			this.subtree_size = subtree_size;
			this.change = change;
		}
		public SegNode(){
			this.sum = 0;
			this.mul = 1;
			this.add = 0;
			this.reset = 0;
			this.subtree_size = 0;
			this.change = false;
		}
		private int subtree_size,sum,mul,add,reset;
	};
	
	static int n;
	static int[] ar ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		
		String[] na = r.readLine().split(" ");
		n = Integer.parseInt(na[0]);
		int Q=Integer.parseInt(na[1]);
		
		String[] ina = r.readLine().split(" ");
		ar = new int[ina.length + 1];
		for(int i=1;i<ar.length;i++){
		ar[i] = Integer.parseInt(ina[i-1]);
		}
		nodes = new SegNode[100009];
		init(1,n,1);
		  
		
		while(Q-- > 0){
			String[] query = r.readLine().split(" ");
			int operation = Integer.parseInt(query[0]); 
			if( operation <= 3 ){
				int x = Integer.parseInt(query[1]);
				int y = Integer.parseInt(query[2]);
				int v = Integer.parseInt(query[3]);
				v %= mod;
				Update(1,n, x,y,1,v, operation);
			}
			else if ( operation == 4 ){
				int x = Integer.parseInt(query[1]);
				int y = Integer.parseInt(query[2]);
				System.out.println(Query(1,n,x,y,1));
			}

		}
	}

	static void merge(int node)
	{
		int x = node*2;
		int y = node*2+1;
		nodes[node].sum = (nodes[x].sum + nodes[y].sum)%mod;
	}

	static void init(int s,int e,int node)
	{
		if( s==e ){
			nodes[node] = new SegNode(1,0,1,ar[s],0,false);
			return;
		}
		init(s,(s+e)/2,node*2);
		init((s+e)/2+1,e,node*2+1);
		nodes[node] = new SegNode(nodes[node*2].subtree_size + nodes[node*2+1].subtree_size , 0,1,(nodes[node*2].sum + nodes[node*2+1].sum)%mod , 0, false ) ;
	}

	static void lazy(int node)
	{
		int x = node*2;
		int y = x+1;

		int add = nodes[node].add;
		int mul = nodes[node].mul;
		int sizex = nodes[x].subtree_size;
		int sizey = nodes[y].subtree_size;

		if( nodes[node].change ){
			int change_to = nodes[node].reset;
			nodes[node] = new SegNode(nodes[node].subtree_size , 0 , 1, nodes[node].sum , 0,false);
			nodes[x] = new SegNode(sizex ,0,1, (change_to*sizex)%mod , change_to , true );
			nodes[y] = new SegNode(sizey ,0,1, (change_to*sizey)%mod , change_to , true );
			return;
		}

		if( nodes[node].add == 0 && nodes[node].mul == 1 )	return;

		nodes[node] = new SegNode(nodes[node].subtree_size , 0 , 1, nodes[node].sum , 0, false );
		nodes[x] = new SegNode ( sizex , (mul*nodes[x].add + add)%mod , (nodes[x].mul*mul)%mod , (nodes[x].sum*mul + add*sizex)%mod ,(nodes[x].reset*mul+add)%mod , nodes[x].change);
		nodes[y] = new SegNode ( sizey , (mul*nodes[y].add + add)%mod , (nodes[y].mul*mul)%mod , (nodes[y].sum*mul + add*sizey)%mod ,(nodes[y].reset*mul+add)%mod , nodes[y].change);
	}

	static void Update(int s,int e,int i,int j,int node,int v,int op)
	{
		if( j < s || e < i )	return ;
		if ( i<=s && e<=j ) {
			if (op == 1)	//addition
				nodes[node] = new SegNode ( nodes[node].subtree_size , (nodes[node].add + v)%mod , nodes[node].mul , (nodes[node].sum + v*nodes[node].subtree_size)%mod , (nodes[node].reset + v)%mod, nodes[node].change );
			else if ( op == 2)	// multiplication
				nodes[node] = new SegNode ( nodes[node].subtree_size , (nodes[node].add*v)%mod , (nodes[node].mul*v)%mod , (nodes[node].sum*v)%mod , (nodes[node].reset*v)%mod, nodes[node].change );
			else if ( op == 3)	//reset Query
				nodes[node] = new SegNode(nodes[node].subtree_size , 0,1,(v*nodes[node].subtree_size)%mod , v, true);
			return ;
		}
		lazy(node);
		Update(s,(s+e)/2,i,j,node*2,v,op);
		Update((s+e)/2+1,e,i,j,node*2+1,v,op);
		merge(node);
	}

	static int Query(int s,int e,int i,int j,int node)
	{
		if( j<s || e<i )	return 0;
		if( i<=s  && e<=j )	return nodes[node].sum ;
		lazy(node);
		return (Query(s,(s+e)/2, i, j, node*2) + Query((s+e)/2+1,e, i,j, node*2+1))%mod;	
	}


}

