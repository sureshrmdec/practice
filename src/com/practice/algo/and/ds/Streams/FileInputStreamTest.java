package com.practice.algo.and.ds.Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
CopyCharacters is very similar to CopyBytes. The most important difference is that CopyCharacters uses FileReader and FileWriter 
for input and output in place of FileInputStream and FileOutputStream. Notice that both CopyBytes and CopyCharacters use an int 
variable to read to and write from. However, in CopyCharacters, the int variable holds a character value in its last 16 bits; 
in CopyBytes, the int variable holds a byte value in its last 8 bits.
*/

//private static int defaultCharBufferSize = 8192; default buffer size ..it is 2^13.

/*There are four buffered stream classes used to wrap unbuffered streams: BufferedInputStream and BufferedOutputStream create buffered byte streams, 
while BufferedReader and BufferedWriter create buffered character streams.
*/
public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {

      //  FileInputStream in = null;
      //  FileOutputStream out = null;
        FileReader in = null;
        FileWriter out = null;

        try {
           // in = new FileInputStream("/Users/skakar/Downloads/myname.txt");
           // out = new FileOutputStream("/Users/skakar/Downloads//outagain.txt");
            in = new FileReader("/Users/skakar/Downloads/myname.txt");
            out = new FileWriter("/Users/skakar/Downloads//outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
