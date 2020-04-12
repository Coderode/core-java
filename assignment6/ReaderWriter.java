// Sandeep (18MCA040)
//Write a multithreaded Java application to demonstrate synchronization in a 
//Reader-Writer problem for a shared limited buffer.

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;

class ReaderWriter{
    static Semaphore readLock = new Semaphore(1);  
    static Semaphore writLock = new Semaphore(1);  
    static int readCount = 0;
	static Queue<Integer> q= new LinkedList<>(); //SHARED LIMITED BUFFER
	
	public static void main(String[] args){
        Reader read = new Reader();
        Writer write = new Writer();
        Thread t1 = new Thread(write);
        t1.setName("thread1");
        Thread t2 = new Thread(read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread(write);
        t4.setName("thread4");
		Thread t5 = new Thread(write);
		t5.setName("thread5");
		Thread t6 = new Thread(write);
		t6.setName("thread6");
		
		try {
			t1.start();
			Thread.sleep(1500);
			t3.start();
			Thread.sleep(1500);
			t2.start();
			Thread.sleep(1500);
			t4.start();
			Thread.sleep(1500);
			t5.start();
			Thread.sleep(1500);
			t6.start();	
		}catch (Exception e) {
			System.out.println(e);
		}
        
    }

    static class Reader implements Runnable {
        public void run() {
            try {
				// Reader wants to enter the critical section
                readLock.acquire();
				// The number of readers has now increased by 1
                readCount++;
				
				// there is atleast one reader in the critical section
				// this ensure no writer can enter if there is even one reader
				// thus we give preference to readers here
                if (readCount == 1) {
                    writLock.acquire();
                }
				
				// other readers can enter while this current reader is inside 
				// the critical section
                readLock.release();

                // current reader performs reading here
		//Critical section	
				Thread.sleep(2000);
                System.out.println("\nThread "+Thread.currentThread().getName() + " is reading...");
				synchronized(this){
					if(!q.isEmpty()){
						System.out.println("Has read : "+q.remove());
					}else{
						System.out.println("Buffer is empty");
					}
				}
				Thread.sleep(100);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished reading!");
		//End 
                // a reader wants to leave
                readLock.acquire();
                readCount--;
				// that is, no reader is left in the critical section,
                if(readCount == 0) {
                    writLock.release(); // writers can enter
                }
				// reader leaves
                readLock.release();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class Writer implements Runnable{
        public void run() {
            try {
				// writer requests for critical section
                writLock.acquire();
				// performs the writing...
		//Critical section
				Thread.sleep(1000);
                System.out.println("\nThread "+Thread.currentThread().getName() + " is writing...");
				synchronized(this){
					if(q.size()<3){
						Random rm = new Random();
						int i=rm.nextInt(20);
						System.out.println("Adding :"+i +" to buffer");
						q.add(i);
					}else{
						System.out.println("Buffer is full");
					}
				}
				Thread.sleep(1000);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished writing!");
		//End	
				// leaves the critical section
                writLock.release();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
}