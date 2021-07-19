import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.time.Instant;

/***
 * The MTCollatz class is the driver class for the multi-threaded Collatz program. 
 * The program requires two arguments from the command line and returns a string to the console
 * @author Roderick Davis
 * @date July 18th, 2021 
 * @info COP-5518 Project 1
 *
 */

class MTCollatz {
	protected static int RANGE;
	protected static int COUNT = 2;
	protected static int[] STOP_TIMES= new int[1000];
	protected static Lock lock = new ReentrantLock();		//MUTEX lock implementation
	
	public static void main(String[] args) {
		/**
		 * The global value RANGE is initialized with the first input argument.
		 * An array of Collatz is created with the length of the input argument.
		 * Collatz threads are created, started and finished to measure execution time
		 */
		RANGE = Integer.parseInt(args[0]);
		int threadCount = Integer.parseInt(args[1]);
		Collatz[] thread_array = new Collatz[threadCount];
		
		long start = Instant.now().toEpochMilli();
		
		for(Collatz t: thread_array) {
			t = new Collatz();
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long finish = Instant.now().toEpochMilli();
		
		for(int i = 1;i <= STOP_TIMES.length; i++) {
			System.err.println(String.format("%d,%d", i, STOP_TIMES[i-1]));		//k, Stop time frequency
		}
		
		System.out.println(String.format("%d,%d,%d", RANGE, threadCount, (finish-start)));		//Range of numbers, number of threads, and execution time
	}

}
