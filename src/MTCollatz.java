import java.lang.Thread;
import java.util.*;
import java.time.Instant;

class Collatz extends Thread{
	private int number;
	
	public Collatz() {}
	
	public Collatz(int num) {
		this.number = num;
	}
	
	public void run() {
		while(this.number > 1) {
			
		}
	}

}

public class MTCollatz {
	//protected static int COUNTER = 1;

	public static int CollatzCount(int num) {
		int stopTime = 0;
		while(num > 1) {
			if(num % 2 == 0){
				num /= 2;
			}else {
				num = num*3 + 1;
			}
			stopTime++;
		}
		return stopTime;
	}

	public static void main(String[] args) {
		int count = 1;
		int upperBound = Integer.parseInt(args[0]);
		int stopTimes[] = new int[upperBound];
		long start = Instant.now().toEpochMilli();
		while(count <= upperBound) {
			int num = count;
			stopTimes[count - 1] = CollatzCount(num);
			System.out.println("Stop time for " + count + ": " + stopTimes[count - 1]);
			count++;
		}
		long finish = Instant.now().toEpochMilli();
		System.out.println("Time alotted: " + (finish - start) + "ms");
		
	}

}
