//using collection framework, define your own collection type called triplet which stores 3 objects .
//use this triplet class to store sum of the triplet values.
//>>MyArray class is Generic class initially it set length =10;
//>>size – tells the no. of data present in array a ;
//>>length – capacity of the array;
//>>if size ==  length then we reallocate the array with double the size all copy all previous data into it set to array a;

//class implements Collection 
import java.util.*;
class MyArray<T> implements Collection{
	private Object a[];
	private int size;  //no. of elemetns present in a
	private int length;  //capacity of a
	
	MyArray(){
		this.size=0;
		this.length=10;    //initial capacity
		T array[]=(T[])new Object[10];  //allocating
		this.a=array;
	}
	
	public boolean add(Object obj){
		if(size == length){
			increaseSizeAndReallocate();   //reallocate if size array is full 
		}
		a[this.size]=obj;
		this.size++;
		return true;
	}
//method to increase capacity of the array;
	private void increaseSizeAndReallocate(){
		length=2*length;  //increase the size by double
		Object newData[]=new Object[length];
		for(int i=0; i<size; i++){
			newData[i]=a[i];
		}
		this.a=newData;
	}
//return the element present at index in the array
	public Object get(int index) throws Exception{
		if(index > this.size-1 || index <0){
			throw new Exception("ArrayIndexOutOfBoundsException");
		}
		
		return this.a[index];
	}
//remove element from array at index
	public void remove(int index) throws Exception{
		if(index > this.size-1 || index < 0){
			throw new Exception("ArrayIndexOutOfBound");
		}
		for(int i=index; i<size-1; i++){
			a[i]=a[i+1];
		}
		this.size--;
//if size is less than half of the array length then reduce the size to half;
		if(size < length/2){
			reduceArraylength();  
		}
	}
	private void reduceArraylength(){
		length = length/2;
		Object newData[]=new Object[length];
		for(int i=0; i<size; i++){
			newData[i]=a[i];
		}
		this.a=newData;
	}
	
	
	public int size(){
		return size;
	}
//remove all elements from the list
	public void clear(){
		size=0;
		this.length=10;
		Object newData[]=new Object[length];
		this.a=newData;
	}
	public boolean contains(Object element){
		for(int i=0; i<size; i++){
			if(a[i] == element ){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n");
		for(int i=0; i<size; i++){
			sb.append(String.valueOf(a[i]));
			sb.append("\n");
		}
		return sb.toString();
	}
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
	
//Other methods of Collection Interface
	public boolean addAll(Collection c){return true;}
	public boolean remove(Object element){return true;}
	public boolean removeAll(Collection c){return true;}
	//default boolean removeIf(Predicate<? super Triplet> filter){}
	public boolean retainAll(Collection c){return true;}
	public boolean containsAll(Collection c){return true;}
	public Iterator iterator(){return null;}
	public Object[] toArray(Object [] o){return this.a;}
	public Object[] toArray(){return this.a;}
	
	//default Stream parallelStream(){}
	//default Stream stream(){}
	//default Spliterator<Object> spliterator(){}
	public boolean equals(Object element){return true;}
	public int hashCode(){return 0;}
	
	
	
}

class Test{
	public static void main(String args[]) throws Exception{
		MyArray<Integer> A=new MyArray<Integer>();
		A.add(10);
		A.add(20);
		System.out.println(A);
		A.remove(1);
		A.add(40);
		System.out.println(A);
		System.out.println(A.contains(40));
		A.add(1);
		System.out.println(A);
		A.clear();
		System.out.println(A);
	}
}
