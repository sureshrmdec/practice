package com.practice.algo.and.ds.spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GSS1_CanYouAnswerTheseQueriesI {

	static class SegNode {
		public SegNode(int left, int right, int segsum, int bestsum) {
			super();
			this.left = left;
			this.right = right;
			this.segsum = segsum;
			this.bestsum = bestsum;
		}
		public SegNode(){
			this.left = Integer.MIN_VALUE;
			this.right = Integer.MIN_VALUE;
			this.segsum = Integer.MIN_VALUE;
			this.bestsum = Integer.MIN_VALUE;
		}
		private int left,right,segsum,bestsum;
	};

	//array size
	static int n;
	static SegNode[] nodes;
	private static Reader in;
    private static PrintWriter out;
    
	public static void main(String[] args) throws IOException{
		  in = new Reader ();
	      out = new PrintWriter (System.out, true);
	        
		  n = in.nextInt();
		  //Height of segment tree 
	      int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
	      //Maximum size of segment tree
	      int max_size = 2 * (int) Math.pow(2, x) - 1;
	      nodes = new SegNode[max_size+1];
	      
		  for (int i = 0; i < n; ++i){
			  int it = in.nextInt();
			  SegNode node = new SegNode(it,it,it,it);
			  //nodes[n + i - 1] = node;
			  nodes[n + i] = node;
		  } 
			   
		  
		  build();
		  int M = in.nextInt();
		 
		  for(int i=0;i<M;i++){
			  int l = in.nextInt();
			  int r = in.nextInt();
			  out.println(query(l,r));
		  }
		  
	}
	
	public static SegNode merge(SegNode cl,SegNode cr)
	{
		
		if(cl!=null && cr!=null){
			SegNode newNode = new SegNode(); 
			newNode.segsum = cl.segsum+cr.segsum;
			newNode.left = Math.max(cl.segsum+cr.left,cl.left);
			newNode.right = Math.max(cr.segsum+cl.right,cr.right);
			newNode.bestsum = max3(cl.bestsum,cr.bestsum,cl.right+cr.left);
			return newNode;
		}
		if(cl==null){
			return cr;
		}else if(cr==null){
			return cl;
		}
		
		return null;
	}
	
	public static int max3(int a,int b,int c)
	{
		return Math.max(Math.max(a,b),c);
	}

	public static void build() {  // build the tree
		for (int i = n - 1; i >= 0; --i){ 
			//nodes[i] = new SegNode();
			nodes[i] = merge(nodes[i<<1],nodes[i<<1|1]);
			//nodes[i] = merge(nodes[2*i+1],nodes[2*i+2]);
		}
	}

	public static int query(int l, int r) {  // sum on interval (l, r)
		SegNode leftinMergeNode = null;
		SegNode rightinMerge = null;

		for (l += n-1, r += n-1; l <= r; l >>= 1, r >>= 1) {
			//if l is the right child
			if ((l&1)>0) {
				leftinMergeNode = merge(leftinMergeNode,nodes[l++]);
			}
			//if r is the left child
			if ((r&1)==0) {
				rightinMerge = merge(rightinMerge,nodes[r--]);
			}
			
	}

		SegNode res = merge(leftinMergeNode,rightinMerge);
		return res.bestsum;
	}
	
}	
	
class Reader {
    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
    }public void close() throws IOException{if(din==null) return;din.close();}
}