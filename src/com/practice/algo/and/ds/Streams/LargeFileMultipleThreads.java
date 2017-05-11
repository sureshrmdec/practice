package com.practice.algo.and.ds.Streams;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Naresh Bhabat
 * 
Following  implementation helps to deal with extra large files in java.
This program is tested for dealing with 2GB input file.
There are some points where extra logic can be added in future.


Pleasenote: if we want to deal with binary input file, then instead of reading line,we need to read bytes from read file object.



It uses random access file,which is almost like streaming API.


 * ****************************************
Notes regarding executor framework and its readings.
Please note :ExecutorService executor = Executors.newFixedThreadPool(10);

 *  	   for 10 threads:Total time required for reading and writing the text in
 *         :seconds 349.317
 * 
 *         For 100:Total time required for reading the text and writing   : seconds 464.042
 * 
 *         For 1000 : Total time required for reading and writing text :466.538 
 *         For 10000  Total time required for reading and writing in seconds 479.701
 *
 * 
 */
public class LargeFileMultipleThreads {//extends TestCase {

	static final String FILEPATH = "/Users/skakar/Downloads/book.txt";
	static final String FILEPATH_WRITE = "/Users/skakar/Downloads/book1.txt";
	static volatile RandomAccessFile fileToWrite;
	static volatile RandomAccessFile file;
	//static volatile String fileContentsIter;
	static volatile int position = 0;

	static volatile AtomicInteger readIndex = new AtomicInteger(0);
	static volatile AtomicInteger writeIndex = new AtomicInteger(0);
	static int offset = 1024;
	static BlockingQueue<FileChunk> blockQ;
	static boolean fileReadComplete = false;
	static Integer semaphore = 0;

	private static int getReadIndex(){
		return readIndex.get();
	}

	private static int getWriteIndex(){
		return writeIndex.get();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();

		try {
			blockQ = new LinkedBlockingQueue<>(4);
			fileToWrite = new RandomAccessFile(FILEPATH_WRITE, "rw");//for random write,independent of thread obstacles 
			file = new RandomAccessFile(FILEPATH, "r");//for random read,independent of thread obstacles 
			seriouslyReadProcessAndWriteAsynch();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		long currentTimeMillis2 = System.currentTimeMillis();
		double time_seconds = (currentTimeMillis2 - currentTimeMillis) / 1000.0;
		System.out.println("Total time required for reading the text in seconds " + time_seconds);

	}

	/**
	 * @throws IOException
	 * Something  asynchronously serious
	 */
	public static void seriouslyReadProcessAndWriteAsynch() throws IOException {
		ExecutorService readerExecutor = Executors.newFixedThreadPool(4);//pls see for explanation in comments section of the class
		ExecutorService writeExecutor = Executors.newFixedThreadPool(4);

		Runnable producer = new Runnable() {

			@Override
			public void run() {

				while(true){
					byte[] b = new byte[offset];
					int readIndex2 = getReadIndex();
					try {
						file.read(b, 0, offset);
						if(b.length < offset)
							fileReadComplete = true;

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						blockQ.put(new FileChunk(b, readIndex2));
						readIndex.getAndAdd(offset);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		};

		for(int i=0;i<4;i++){
			readerExecutor.execute(producer);	
		}


		Runnable consumer = new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						synchronized (semaphore) {
							
							FileChunk chunk = blockQ.take();
							while(chunk.offset != getWriteIndex())
								semaphore.wait();
							if(chunk.offset == getWriteIndex()){
							try {
								fileToWrite.write(chunk.b);
								writeIndex.set(chunk.offset+offset);
								semaphore.notifyAll();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							}
						}

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		for(int i=0;i<4;i++){
			writeExecutor.execute(consumer);
		}



		if(fileReadComplete)
			readerExecutor.shutdown();
		if(fileReadComplete)
			writeExecutor.shutdown();
		while (!readerExecutor.isTerminated() || !writeExecutor.isTerminated()) {
		}
		System.out.println("Finished all threads");
		file.close();
		fileToWrite.close();
	}

	/**
	 * @param filePath
	 * @param data
	 * @param position
	 */
	private static void writeToFile(String filePath, String data) {
		try {
			// fileToWrite.seek(position);
			data = "\n" + data;
			if (data.contains("Randomization")) {
				return;
			}
			System.out.println("Let us do something time consuming to make this thread busy"+(position++) + "   :" + data);
			System.out.println("Lets consume through this loop");
			int i=1000;
			while(i>0){

				i--;
			}
			fileToWrite.write(data.getBytes());
			throw new Exception();
		} catch (Exception exception) {
			System.out.println("exception was thrown but still we are able to proceeed further"
					+ " \n This can be used for marking failure of the records");
			//exception.printStackTrace();

		}

	}

	static class FileChunk{
		byte[] b;
		int offset;

		public FileChunk(byte[] b, int offset){
			this.b = b;
			this.offset = offset;
		}
	}
}