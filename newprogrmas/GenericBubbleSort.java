
class GenericBubbleSort{
	public static void main(String args[]){
		Double a[]={2.3,10.0,5.2,6.5,1.2,0.1};
		BubbleSort<Double> b=new BubbleSort();
		b.display(a);
		Double c[]= b.bubbleSort(a);
		b.display(c);
	}
}

class BubbleSort<T extends Comparable<? super T>>{
	T [] bubbleSort(T a[]){
		int n=a.length;
		boolean flag=false;
		for(int round=1; round<=n-1; round++){
			flag=true;
			for(int i=0; i<n-round; i++){
				int j=i+1;
				if(a[i].compareTo(a[j]) > 0){
					T temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					flag=false;
				}
			}
			if(flag){
				break;
			}
		}
		return a;
	}
	void display(T a[]){
		System.out.print("\n[");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+", ");
		}
		System.out.print("\b\b]");
	}
}