import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.time.Instant;

class MTCollatz {
	protected static int RANGE;
	protected static int COUNT = 2;
	protected static int[] STOP_TIMES;
	protected static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		RANGE = Integer.parseInt(args[0]);
		STOP_TIMES = new int[RANGE];
		STOP_TIMES[0] = 0;
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
		
		System.out.println(String.format("%d,%d,%d", RANGE, threadCount, (finish-start)));
	}

}
