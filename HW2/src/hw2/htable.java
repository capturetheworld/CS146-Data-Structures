package hw2;

import java.util.LinkedList;
import java.util.Scanner;

public class htable {
	
	 private static LinkedList < Process > [] hashTable;
	

		 public static void main(LinkedList < Process > [] thathashTable) {
			 hashTable=thathashTable;
			 
			 estabNext();
			 Scanner scan = new Scanner(System.in);
			 int x = 0;
			  while (x < 1000) {
			   System.out.println("Choose a HashTable action: \n1. Insert \n2. Search \n3. Delete \n4. List \n5. Forget hashtable and go back to BST");
			   switch (Integer.parseInt(scan.nextLine())) {

			    case 1:

			     System.out.println("Enter a priority:");
			     int prio = Integer.parseInt(scan.nextLine());
			     

			     break;
			    case 2:
			     System.out.println("Enter the Priority of what you want to delete:");
			     
			     System.out.println("Delete Complete");

			     break;
			    case 3:
			     System.out.println("Printing...");
			   

			     break;
			    case 4:
			    	System.out.println("4...");
			     

			    case 5:
			    	System.out.println("Quitting...");
				     x = 1000;
				     break;
			      
			     }
			  }
		 }
		 
		 
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
		

}
	



	

		
		
		

	
	
	
	
 




