package com.practice.algo.and.ds.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*key
*  keyboard
*  keyed
*  keyhole
*  keynote
*  keypunch
*  keys
*  keystone
*  keyword
*
*  [paste, pasty]
*  paste
*  pasteboard
*  pastel
*  pasteup
*  pastiche
*  pastime
*  pastor
*  pastoral
*  pastry
*  pasture
*  pasty
* */
public class RangeTreeOneDSerach<Key extends Comparable<Key>, Value> {
	private Node root;   // root of the BST
	
	public void put(Key key, Value val) {
        root = put(root, key, val);
    }
	// make new node the root with uniform probability
    private Node put(Node x, Key key, Value val) {
    	
    	 if (x == null) return new Node(key, val);
    	 int cmp = key.compareTo(x.key);
    	 if (cmp == 0) { 
    		 x.val = val; return x;
    		 }
         if (StdRandom.bernoulli(1.0 / (size(x) + 1.0))) return putRoot(x, key, val);
    	 if(cmp<0){
    		 x.left  = put(x.left,  key, val);
    	 }else{
    		 x.right  = put(x.right,  key, val);
    	 }
    	 fix(x);
         return x;
    }
    private Node putRoot(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if      (cmp == 0) { x.val = val; return x; }
        else if (cmp  < 0) { x.left  = putRoot(x.left,  key, val); x = rotR(x); }
        else               { x.right = putRoot(x.right, key, val); x = rotL(x); }
        return x;
    }
    // fix subtree count field
    private void fix(Node x) {
        if (x == null) return;                 // check needed for remove
        x.N = 1 + size(x.left) + size(x.right);
    }

    // right rotate
    private Node rotR(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        fix(h);
        fix(x);
        return x;
    }

    // left rotate
    private Node rotL(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        fix(h);
        fix(x);
        return x;
    }

 // return number of nodes in subtree rooted at x
    public int size() { return size(root); }
    private int size(Node x) { 
        if (x == null) return 0;
        else           return x.N;
    }

    // height of tree (empty tree height = 0)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
    // return all keys in given interval
    public Iterable<Key> range(Key min, Key max) {
        return range(new Interval<Key>(min, max));
    }
    public Iterable<Key> range(Interval<Key> interval) { 
        Queue<Key> list = new LinkedList<Key>();
        range(root, interval, list);
        return list;
    }
    private void range(Node x, Interval<Key> interval, Queue<Key> list) {
        if (x == null) return;
        if (!less(x.key, interval.min()))  {
        	range(x.left, interval, list);
        }
        if (interval.contains(x.key))    { 
        	list.add(x.key);
        }
        if (!less(interval.max(), x.key)) { 
        	range(x.right, interval, list);
        }
    }

    private boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }
    // return the smallest key
    public Key min() {
        Key key = null;
        for (Node x = root; x != null; x = x.left)
            key = x.key;
        return key;
    }
    
    // return the largest key
    public Key max() {
        Key key = null;
        for (Node x = root; x != null; x = x.right)
            key = x.key;
        return key;
    }
 // check integrity of subtree count fields
    public boolean check() { 
    	return checkCount() && isBST(); 
    }
 // check integrity of count fields
    private boolean checkCount() { return checkCount(root); }
    private boolean checkCount(Node x) {
        if (x == null) return true;
        return checkCount(x.left) && checkCount(x.right) && (x.N == 1 + size(x.left) + size(x.right));
    }


    // does this tree satisfy the BST property?
    private boolean isBST() { 
    	return isBST(root, min(), max()); 
    	}
 // are all the values in the BST rooted at x between min and max, and recursively?
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (less(x.key, min) || less(max, x.key)) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 
    
    /***************************************************************************
     *  BST search
     ***************************************************************************/

     public boolean contains(Key key) {
         return (get(key) != null);
     }

     // return value associated with the given key
     // if no such value, return null
     public Value get(Key key) {
         return get(root, key);
     }

     private Value get(Node x, Key key) {
         if (x == null) return null;
         int cmp = key.compareTo(x.key);
         if      (cmp == 0) return x.val;
         else if (cmp  < 0) return get(x.left,  key);
         else               return get(x.right, key);
     }
     
    public static void main(String[] args) {

        int N = 0;
        //RangeTreeOneDSerach<Integer, Integer> st = new RangeTreeOneDSerach<Integer, Integer>();
      TreeMap<Integer,Integer> st = new TreeMap<Integer,Integer>();
       
        st.put(7,N++);
        st.put(15,N++);
        
        st.put(89,N++);
        st.put(100,N++);
        st.put(21,N++);
        st.put(4,N++);
        st.put(5,N++);
        st.put(17,N++);
       /* System.out.println();
        System.out.println("height:          " + st.height());
        System.out.println("size:            " + st.size());
        System.out.println("min key:         " + st.min());
        System.out.println("max key:         " + st.max());
        System.out.println("integrity check: " + st.check());
        System.out.println();

        System.out.println(new Interval<String>("keyboard", "keys"));
       Iterable<Integer> list = st.range(new Interval<Integer>(20,60));
        for (Integer s : list)
            System.out.println(s + " " + st.get(s));
        System.out.println();

       System.out.println(new Interval<String>("paste", "pasty"));
        list = st.range(new Interval<Integer>(40,100));
        for (Integer s : list)
            System.out.println(s);*/
        System.out.println();

    
	}
	
	// BST helper node data type
    private class Node {
        Key key;            // key
        Value val;          // associated data
        Node left, right;   // left and right subtrees
        int N;              // node count of descendents

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.N   = 1;
        }
    }

}
