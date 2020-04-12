import java.util.*;
class ReaderWriter extends Thread{
	static int write=1; //semaphore
	static int mutex=1;  //semaphore
	static int readcount=0;
	public static void main(String args[]){
		//write=1;
		//mutex=1;
		//readcount=0;
		Reader read = new Reader();
        Writer write = new Writer();
        Thread t1 = new Thread(read);
        t1.setName("thread1");
        Thread t2 = new Thread(read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread(read);
        t4.setName("thread4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
	}
	public static void waitWrite(){
		while(write == 0);  //wait until write = 1
		//System.out.println("write="+write);
		write--;
	}
	public static void signalWrite(){
		write++;
	}
	public static void waitRead(){
		while(mutex == 0);
		mutex--;
	}
	public static void signalRead(){
		mutex++;
	}
	static class Reader extends Thread{
		@Override
		public void run(){
			try{
				//reader wants to enter the critical section
				waitRead();
				
				//no. of readers has now increased by 1
				readcount++;
				// there is atleast one reader in the critical section
				// this ensure no writer can enter if there is even one reader
				// thus we give preference to readers here
				if(readcount == 1){
					waitWrite();
				}
				
				// other readers can enter while this current reader is inside 
				// the critical section
				signalRead();
				
				
				//Reading section
					System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
					Thread.sleep(1500);
					System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
				//releasing section
				waitRead();
				readcount--;
				
				//if no reader is left in the critical section
				if(readcount == 0){
					//then writers can enter
					signalWrite();
				}
				
				
				//reader leaves
				signalRead();
				
				//System.out.println("write="+write+" , mutex/read ="+mutex+", readcount="+readcount);
				
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
	static class Writer extends Thread{
		@Override
		public void run(){
			try{
				//writer requests for critical section
				waitWrite();
				
				//performs writing
				System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
				Thread.sleep(2500);
				System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
				
				//leaves the critical section
				signalWrite();
				//System.out.println("write="+write+" , mutex/read ="+mutex+", readcount="+readcount);
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

}

