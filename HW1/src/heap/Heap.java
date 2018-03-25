package heap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class Heap {
	private static ArrayList <ProcessNode> processes= new ArrayList<ProcessNode>();
	
	
	public static void main(String[] args)
	{
//		for(int i =0;i<20;i++) {
//			processes.add(new ProcessNode("P"+i,generateUniqueID() ));
//		}
		processes.add(new ProcessNode("P1", 4));
		processes.add(new ProcessNode("P2", 1));
		processes.add(new ProcessNode("P3", 3));
		processes.add(new ProcessNode("P4", 2));
		processes.add(new ProcessNode("P5", 16));
		processes.add(new ProcessNode("P6", 9));
		processes.add(new ProcessNode("P7", 10));
		processes.add(new ProcessNode("P8", 14));
		processes.add(new ProcessNode("P9", 8));
		processes.add(new ProcessNode("P10", 7));
		
		print();
		buildMaxHeap();
		print();
		
		
	
	}
	
	public static void print() {
		for(ProcessNode p: processes) {
			p.printData();
		}
		System.out.println("--------------");
	
	}
	
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
		return valueInt;
	}
	
	public static int getParent(int i) {
		return (int)Math.floor((i-1)/2);
	}
	public static int getLeft(int i) {
		return (int)Math.floor((2*i)+1);
		
			
	}
	public static int getRight(int i) {
		return (int)Math.floor((2*i)+2);
		
	}
	public static int getHeapSize() {
		return processes.size();
	}
	
	public static void maxHeapify(int i) {
		int l = getLeft(i); //left node
		int r = getRight(i); //right node
		int largest;
		
		//checks to make sure indexes aren't larger than the heap, then checks and swaps priority
		if(l<=processes.size()-1 && processes.get(l).getPriority()>processes.get(i).getPriority()) {
			largest = l;
		}
		else largest = i;
		
		if(r<=processes.size()-1 && processes.get(r).getPriority()>processes.get(largest).getPriority()) {
			
			largest = r;
		}
		if(largest!=i) {
			
			exchange(i,largest);
			maxHeapify(largest);
		}
	}
	
	//swap that and the other in this ArrayList
	public static void exchange(int that, int theOther) {

		Collections.swap(processes, that, theOther);
		
	}
	
	
	public static void buildMaxHeap() {
		
		
		for(int i = (int)Math.floor((processes.size()-1)/2); i>=0;i--) {
			maxHeapify(i);
		}
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
