package com.practice.algo.and.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Graphs_SmallestMultipleOf0and1 {

	  // Return the smallest multiple of the number (as a string) consisting only of digits 0 and 1
    //
    // All possible digits that can be constructed using the digits 0/1 can be represented
    // as a tree, where at each level, appending a 0 is one branch and appending a 1 is another
    //
    // If we perform BFS on this tree, the first number we see which is an exact multiple of the input
    // number will be the result (since it will be the smallest). Make sure to consider left
    // branch (i.e. 0) before considering the right branch (i.e. 1)
    //
    // The 2 paths we take at each level when the current number is num:
    //      (num * 10)
    //      (num * 10) + 1
    // 
    // Since the result can grow huge quite easily, it might not be possible to store the result in a
    // 32 or even a 64 bit int/long variable.
    //
    // One alternative is to use BigNumber, but a simpler alternative exists if we leverage modulo.
    //
    // The operations we perform above (i.e. multiplications and additions) will retain the useful part
    // of the result when using modulo. We use the given number itself as the modulo, and when we see a
    // result of 0, it means we have found a number which is an exact multiple of the input number.
    //
    // To reconstruct the number, we need to store the parent nodes of each node, when adding the node
    // in the queue (similar to using BFS for computing shortest path)
    //
    // We will also need to know if we appended a 0 or a 1 at each step, and so we add this information
    // as part of the node data structure as well.
    //
    // Re-visiting nodes is unecessary since we have seen this modulo result (i.e. value % num) already.
    // Any additional digits we add from now will only make the number longer and we already are tracking
    // the path for this same modulo result we've seen earlier.
    //
    public static String multiple(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Invalid args");
        }

        String result = "0";

        if (num > 0) {
            // An array to mark all the visited nodes
            boolean[] isVisited = new boolean[num];
            // The queue used by BFS
            Queue<Node> queue = new ArrayDeque<>();

            // Add the first number 1 and mark it visited
            queue.add(new Node(true, 1 % num, null));
            isVisited[1 % num] = true;

            // The final destination node which represents the answer
            Node destNode = null;

            while (!queue.isEmpty()) {
                // Get the next node from the queue
                Node currNode = queue.remove();

                if (currNode.val == 0) {
                    // We have reached a valid multiple of num
                    destNode = currNode;
                    break;
                } else {
                    // Visit the next 2 neighbors
                    // Append 0 - (currNode.val * 10)
                    // Append 1 - (currNode.val * 10) + 1

                    // Append a '0'
                    int val1 = (currNode.val * 10) % num;
                    if (!isVisited[val1]) {
                        queue.add(new Node(false, val1, currNode));
                        isVisited[val1] = true;
                    }

                    // Append a '1'
                    int val2 = (val1 + 1) % num;
                    if (!isVisited[val2]) {
                        queue.add(new Node(true, val2, currNode));
                        isVisited[val2] = true;
                    }
                }
            }

            // Trace the path from destination to source
            if (destNode == null) {
                throw new IllegalStateException("Result should not be null");
            } else {
                StringBuilder reverseResultBuilder = new StringBuilder();
                Node currNode = destNode;
                while (currNode != null) {
                    reverseResultBuilder.append(currNode.isDigitOne ? '1' : '0');
                    currNode = currNode.parent;
                }
                result = reverseResultBuilder.reverse().toString();
            }
        }

        return result;
    }

    // Node represents every digit being appended in the decision tree
    private static class Node {
        // True if '1', false otherwise (i.e. '0')
        public final boolean isDigitOne;
        // The number represented in the tree modulo the input number
        public final int val;
        // The parent node in the tree
        public final Node parent;

        public Node(boolean isDigitOne, int val, Node parent) {
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        System.out.println("Input number: " + num);
        System.out.println("Smallest multiple using only 0s and 1s as digits: " + Graphs_SmallestMultipleOf0and1.multiple(num));
    }
   }
