import java.lang.Thread;

/***
 * This class is an extension of the Thread class.
 * This thread class is meant to be implemented in the MTCollatz class for multithreading purposes.
 * @author Roderick Davis
 * @date July 18th, 2021 
 * @info COP-5518 Project 1
 *
 */

public class Collatz extends Thread{	
	
	public Collatz() {}
	
	@Override
	public void run() {
		/**
		 * Overidden run method that increments the STOP_TIMES array based on
		 * the stop time calculated by the CollatzCount method. This method also
		 * increments the static COUNT value in the MTCollatz class.
		 */
		
		while(MTCollatz.COUNT <= MTCollatz.RANGE) {
			MTCollatz.lock.lock();
			try {
				MTCollatz.STOP_TIMES[CollatzCount(MTCollatz.COUNT) - 1]++;
				MTCollatz.COUNT++;
			}finally {
				MTCollatz.lock.unlock();
			}
			
		}
	}
	
	public static int CollatzCount(int count) {
		/**
		 * This method performs the Collatz function on a given number
		 * 
		 * @param the number for Collatz to be performed
		 * 
		 * @return the stop-time value
		 */
		
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
