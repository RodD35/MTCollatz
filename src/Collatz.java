import java.lang.Thread;

public class Collatz extends Thread{	
	
	public Collatz() {}
	
	public void run() {
		while(MTCollatz.COUNT <= MTCollatz.RANGE) {
			MTCollatz.lock.lock();
			try {
				MTCollatz.STOP_TIMES[MTCollatz.COUNT - 1] = CollatzCount(MTCollatz.COUNT);
				MTCollatz.COUNT++;
			}finally {
				MTCollatz.lock.unlock();
			}
			
		}
	}
	
	public static int CollatzCount(int count) {
		int temp_num = count;
		int stopTime = 0;
		while(temp_num > 1) {
			if(temp_num % 2 == 0){temp_num /= 2;}
			else {temp_num = temp_num*3 + 1;}
			stopTime++;
		}
		return stopTime;
	}

}
