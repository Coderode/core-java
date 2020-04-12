
import java.util.*;

class MyTimer extends TimerTask{
	public void run(){
		try{
			System.out.println("Time started (for 3 sec):");
			Thread.sleep(3000);
			System.out.println("Time Out!");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		TimerTask timerTask = new MyTimer();
		
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 3*1000);
		Thread.sleep(15000);
		timer.cancel();
		System.out.println("Time Out!");
		
		
	}
	
}
