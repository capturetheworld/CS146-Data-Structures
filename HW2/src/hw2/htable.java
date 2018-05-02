package hw2;

import java.util.LinkedList;
import java.util.Scanner;

public class htable {
	
	 private static LinkedList < Process > [] hashTable;
	

		 public static void main(LinkedList < Process > [] thathashTable) {
			 hashTable=thathashTable;
			 
			 estabNext();//makes sure all the node.nexts are established in the Linked List
			 Scanner scan = new Scanner(System.in);
			 int x = 0;
			  while (x < 1000) {
			   System.out.println("\n\n-----------SECONDARY MENU | CHOOSE A HASH TABLE FUNCTION---------- \n1. Insert \n2. Search \n3. Delete \n4. List \n5. Forget hashtable and go back to BST");
			   switch (Integer.parseInt(scan.nextLine())) {

			    case 1:

			    	 System.out.println("Enter a name:");
			         String str = scan.nextLine();
			         System.out.println("Enter a priority:");
			         int prio = Integer.parseInt(scan.nextLine());
			         insert(str,prio);
			         System.out.println("Insert Complete.");
			     

			     break;
			    case 2:
			     System.out.println("Search");
			     System.out.println("Enter a priority:");
		         int prio2 = Integer.parseInt(scan.nextLine());
		         Process found = search(prio2);
		         if(found!=null)
		        	 System.out.println("The name of the Process with this priority is: "+ found.getName());
		         else
		        	 System.out.println("Process with that priority wasn't found");
			     
			     

			     break;
			    case 3:
			     System.out.println("Delete");
			     System.out.println("Enter a priority:");
		         int prio3 = Integer.parseInt(scan.nextLine());
		        Process toDelete= search(prio3);
		        if(toDelete!=null) {
		         delete(prio3,toDelete);
		         
		         System.out.println("Delete Complete");
		        }
		        else
		        	System.out.println("can't find it to delete");
		         
		         
		       
			   

			     break;
			    case 4:
			    	System.out.println("\nPrinting...");
			    	print();
			    	break;
			     

			    case 5:
			    	System.out.println("Quitting...");
				     x = 1000;
				     break;
			      
			     }
			  }
		 }
		 
		 //goes through each linked list inside each array index and traverses the list adding the Next Node pointer to each process
		 
		 public static void estabNext() {
		 for (int aindex = 0; aindex < hashTable.length; aindex++) {
	    	  for(int j = 1; j<hashTable[aindex].size()-1;j++) {
	    		  hashTable[aindex].get(j).setNext(hashTable[aindex].get(j+1));
	    		 // System.out.println("The node "+ hashTable[aindex].get(j).getPriority() + " now set next as " +hashTable[aindex].get(j+1).getPriority() );
	    	  //System.out.println("i and j are "+ aindex +"   "+ j);
	    	  //System.out.println("hashtable size "+ hashTable[aindex].size());
	    	  }
	      
	      }
		 }
		 
		 //inserts a process into linked list
		 public static void insert(String name, int key) {
			 Process x = new Process(name,key);//create new process
			 int pointer = x.coded(11);//finds the hashFunction
			 hashTable[pointer].add(x);
		 }
		 
		 //looks for a given Process via a key returns the Process that matches 
		 public static Process search(int key) {
			 for (int aindex = 0; aindex < hashTable.length; aindex++) {
		    	  for(int j = 1; j<hashTable[aindex].size();j++) {
		    		  if(hashTable[aindex].get(j).getPriority()==key)
		    			  return hashTable[aindex].get(j);
		    		
		    	  }
		      
		      }
			 return null;//can't find it
		 }
		 
		 //similar to the search, but returns the location (in the array, LinkedList) of the Node to be deleted
		 //checks to see that it is not at the start or end of the LinkedList
		 //deletes the process
		 public static void delete(int key, Process p) {
			 int arraystore=-1;
			 int LLstore=-1;
			 
			 for (int aindex = 0; aindex < hashTable.length; aindex++) {
		    	  for(int j = 1; j<hashTable[aindex].size();j++) {
		    		  if(hashTable[aindex].get(j).getPriority()==key) {
		    			  arraystore=aindex;
		    			  LLstore=j;
		    		  }
		    		
		    	  }
		      
		      }
			//establishes the .next pointer if it is not at the end or start of the Linked List
			 if(hashTable[arraystore].get(LLstore-1)!=null && p.getNext()!=null){
				 hashTable[arraystore].get(LLstore-1).setNext(hashTable[arraystore].get(LLstore+1));
			 }
			 hashTable[arraystore].remove(p);

			 
		 }
		 
		 //prints out hashTable not sorted, in order of the chained hashTable
		 private static void print() {
			 for (int aindex = 0; aindex < hashTable.length; aindex++) {
		    	  for(int j = 1; j<hashTable[aindex].size();j++) {
		    		  hashTable[aindex].get(j).printData();
		    	  }
		      
		      }
		 }
		
		
		

}
	



	

		
		
		

	
	
	
	
 




