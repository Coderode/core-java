class ThreadDemo{
	public static void main(String args[]){
		NewThread t1=new NewThread("thread 1");
		NewThread t2=new NewThread("thread 2");
		t1.start();
		t2.start();
	}
}

class NewThread extends Thread{
	String tname;
	NewThread(String tname){
		this.tname=tname;
		System.out.println("child thread is created!");
	}
	public void run(){
		try{
			for(int i=0; i<1000; i++){
				System.out.println(tname+":"+i);
				Thread.sleep(10000);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}