package heap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Heap {
	private static ArrayList <ProcessNode> processes= new ArrayList<ProcessNode>();
	private static int heapSize;
	
	
	public static void main(String[] args)
	{
		
//		for(int i =0;i<20;i++) {
//			processes.add(new ProcessNode("P"+i,generateUniqueID() ));
//		}
		processes.add(new ProcessNode("P1", 100));
		processes.add(new ProcessNode("P2", 30));
		processes.add(new ProcessNode("P3", 20));
		processes.add(new ProcessNode("P4", 1));
		processes.add(new ProcessNode("P5", 3));
		processes.add(new ProcessNode("P6", 10));
		processes.add(new ProcessNode("P7", 15));
		setHeapSize(processes.size());
		print();
		heapIncreaseKey(4,300);
		//ProcessNode maxval = heapExtractMax();
		//System.out.print("The max node that was just extracted was: "); maxval.printData();
		print();
	
		
		
		
	
	}
	//prints out a list of processes and IDs
	public static void print() {
		for(ProcessNode p: processes) {
			p.printData();
		}
		System.out.println("--------------");//prints out a separator
	
	}
	
	//generates a unique ID that is not already found in the heap
	public static int generateUniqueID() {
		boolean found = false;
		double value=0;
		int valueInt=0;
		while(!found) {
		  value = Math.random()*100;
		  valueInt = (int)value;
		  found=true;
		 
			for(ProcessNode p: processes) {
				if(p.getPriority() == valueInt) {
					found = false;
				 }
		   }
	}
		return valueInt;//returns the random value
	}
	
	////////getters//////
	public static int getParent(int i) {
		return (int)Math.floor((i-1)/2);//returns parent of a node
	}
	public static int getLeft(int i) {
		return (int)Math.floor((2*i)+1);//returns left child node
		
			
	}
	public static int getRight(int i) {
		return (int)Math.floor((2*i)+2);//returns right child node
		
	}
	public static int getHeapSize() {
		return heapSize;//returns size of the node
	}
	public static void setHeapSize(int that) {
		heapSize = that;
	}
	
	//swaps the largest child with root node all the way down
	public static void maxHeapify(int i) {
		int l = getLeft(i); //left node
		int r = getRight(i); //right node
		int largest;
		
		//checks to make sure indexes aren't larger than the heap, then checks and swaps priority
		if(l<=getHeapSize()-1 && processes.get(l).getPriority()>processes.get(i).getPriority()) {
			largest = l;
		}
		else largest = i;
		
		if(r<=getHeapSize()-1 && processes.get(r).getPriority()>processes.get(largest).getPriority()) {
			
			largest = r;
		}
		if(largest!=i) {//only if the largest isn't the root node
			
			exchange(i,largest);//exchanges the appropriate nodes
			maxHeapify(largest);//recursive call down the heap
		}
	}
	
	//swap that and the other in this ArrayList
	public static void exchange(int that, int theOther) {
		Collections.swap(processes, that, theOther);//uses the swap method to swap the nodes in the tree
		
	}
	
	//builds a Max Heap by first starting at the center
	public static void buildMaxHeap() {
		for(int i = (int)Math.floor((processes.size()-1)/2); i>=0;i--) {
			maxHeapify(i); //uses Max Heapify to make sure that each smaller heap follows the max heap property
		}
	
		
		
	}
	
	public static void heapSort()
	{
		buildMaxHeap();
		for(int i = processes.size()-1; i>=1;i--) {
			exchange(0,i);//exchanges the first and last
			setHeapSize(getHeapSize()-1);
			maxHeapify(0); //uses Max Heapify to make sure that each smaller heap follows the max heap property
		}
		
		
	}
	//returns the value of the max data
	public static int heapMaximum() {
		return processes.get(0).getPriority();
	}
	//returns the int of the data, but actually removes the node itself (including ID)
	public static ProcessNode heapExtractMax() {
		if (getHeapSize()==0) {
			 System.out.println ("Heap Underflow, not enough processes for a max value");
			 return null;
		}
		
		ProcessNode max = processes.get(0);//sets a max node to the largest/root node
		processes.set(0, processes.get(getHeapSize()-1));//sets root node to the smallest element
		setHeapSize(getHeapSize()-1);//sets heap size to 1 less than the original
		processes.remove(getHeapSize());//(removes the smallest node since it's now the root node)
		maxHeapify(0);//calls max heapify so the largest can be on top.
		
		return max;//returns the priority value of the max, can easily be modified to return the whole node.
		
	}
	
	public static void heapIncreaseKey(int index, int increaseTo) {
		if (increaseTo<processes.get(index).getPriority()) { //if the new priority is less than the old one
			 System.out.println ("The new priority is less than the current priority of this node which is " + processes.get(index).getPriority() + " please enter a greater number");
		}
		
		processes.get(index).setPriority(increaseTo);
		
		while (index>0 && processes.get(getParent(index)).getPriority()<processes.get(index).getPriority()) {
			//while the index is greater than 0 and the parent's priority is less that the child's priority
			//exchange
			//System.out.println("we are exchanging" + getParent(index) + "," + index);
			exchange(getParent(index), index); //exchange the parent of the index node, and the index node
			index = getParent(index); //set the index to the parent's index moving up the tree
			
		}
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
