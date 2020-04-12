
class ThreadDemo{
	public static void main(String args[]){
		Thread t=new MyThread();
		t.start();
	}
}
class MyThread extends Thread{
	public void run(){
		try{
			for(int i=1; i<=10; i++){
				System.out.print(i+" ");
				if(i==10){
					i=0;
				}
				Thread.sleep(100);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}