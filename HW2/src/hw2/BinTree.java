package hw2;
import java.util.Scanner;



import java.util.LinkedList;


public class BinTree {

 private Process root = null;
 private static int listsize = 11; //hashtable size
 private static LinkedList < Process > [] hashTable = new LinkedList[listsize];




 public static void main(String[] args) {

  Scanner scan = new Scanner(System.in);
  BinTree mainTree = new BinTree();




  mainTree.treeInsert(mainTree, new Process("1InternetExplorer", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("2Eclipse", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("3Sketch", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("4Illustrator", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("5Photoshop", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("6OneNote", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("7Word", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("8PowerPoint", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("9Chrome", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("10Github", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("11Excel", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("12Outlook", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("13Selfcontrol", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("14Snapchat", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("15Twitter", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("16SmartVideohub", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("17ProVideoPlayer", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("18FireFox", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("19Photos", mainTree.generatePriority(mainTree)));
  mainTree.treeInsert(mainTree, new Process("20ProPresenter", mainTree.generatePriority(mainTree)));


  
  int x = 0;
  while (x < 1000) {
   System.out.println("\n >>>>>  MAIN MENU | CHOOSE AN ACTION  <<<<< \n1. Insert \n\t2. Delete \n\t\t3. Print Sorted List\n\t\t\t 4. Quit " + "\n\t\t\t\t 5. Switch to Hashtable");
   switch (Integer.parseInt(scan.nextLine())) {

    case 1:


     System.out.println("Enter a name:");
     String str = scan.nextLine();
     System.out.println("Enter a priority:");
     int prio = Integer.parseInt(scan.nextLine());
     mainTree.treeInsert(mainTree, new Process(str, prio));
     System.out.println("Insert Complete.");

     break;
    case 2:
     System.out.println("Enter the Priority of what you want to delete:");
     int key = Integer.parseInt(scan.nextLine());
     Process toDelete = mainTree.search(mainTree.root, key);
     if (toDelete != null) {
      mainTree.treeDelete(mainTree, toDelete);
     }
     System.out.println("Delete Complete");

     break;
    case 3:
     System.out.println("Printing...");
     mainTree.inordertreeWalk(mainTree.root);

     break;
    case 4:
     System.out.println("PROGRAM OFF");
     x = 1000;
     break;

    case 5:
     System.out.println("\n\n\n\n\n******************Hashtable Created**************************");
     for (int i = 0; i < hashTable.length; i++) {
      hashTable[i] = new LinkedList <Process> ();
      hashTable[i].add(null);
      
      
     }
      
      
      mainTree.addalltoList(mainTree.root);
      htable.main(mainTree.gethashTable(mainTree));
      
      
      //System.out.println("THE DATA IS" +  hashTable[0].get(2).getPriority());
      

     

     }
     
     
   }
  }

 
 
//Inserts Process into BST, maintains the BST structure takes in a BST and a Process
 public void treeInsert(BinTree T, Process z) {
  Process y = null;
  Process x = T.root;
  while (x != null) {
   y = x;
   if (z.getPriority() < x.getPriority()) {//compares priority
    x = x.getLeft();
   } else {
    x = x.getRight();
   }
   z.setParent(y);//setsParent

  }
  if (y == null) {
   T.root = z;
  } else if (z.getPriority() < y.getPriority()) {
   y.setLeft(z);
  } else {
   y.setRight(z);//setsChild
  }
 }

  
//searches for the process comparing (starting at root first) with the key
  public Process search(Process compare, int key) {
   if (compare == null)
    return null;
   else if (compare.getPriority() == key)
    return compare;
   if (compare.getPriority() > key) {
    return search(compare.getLeft(), key);
   }

   return search(compare.getRight(), key);


  }
//prints out (in order) the processes
  public void inordertreeWalk(Process x) {
   if (x != null) {
    inordertreeWalk(x.getLeft());
    x.printData();
    inordertreeWalk(x.getRight());
   }
  }
  //generates a random unique priority
  public int generatePriority(BinTree T) {
	  boolean found = false;
	  double value = 0;
	  int valueInt = 0;
	  while (!found) {
	   value = Math.random() * 100;
	   valueInt = (int) value;
	   found = true;

	   
	    if ((search(T.root, valueInt)!=null)) {
	     found = false;
	    }
	   }
	  
	  return valueInt; //returns the random value
	 }
  
//Adds all Process to hashTable List
  public void addalltoList(Process x) {
   if (x != null) {
	   addalltoList(x.getLeft());
   
    int pointer = x.coded(listsize);
    //System.out.println("List size coded is"+ hashTable[pointer]);
    hashTable[pointer].add(x);
   // System.out.println("completed");
    addalltoList(x.getRight());
   }
  }
  
  //sends hashTable
  public  LinkedList<Process>[] gethashTable(BinTree T){
	  return hashTable;
  }
  
  
  
  
//finds the minimum of the given tree, usually starts with root node
  public Process treeMinimum(Process x) {
   while (x.getLeft() != null) {
    x = x.getLeft();
   }
   return x;
  }

  //transplants the tree and all of its child nodes with another tree and its child nodes
  public void Transplant(BinTree T, Process u, Process v) {
   if (u.getParent() == null) {
    T.root = v;
   } else if (u == u.getParent().getLeft()) {
    u.getParent().setLeft(v);
   } else {
    u.getParent().setRight(v);
   }
   if (v != null) {
    v.setParent(u.getParent());
   }
  }

  //deletes the subtree at a specific node and all the children using the transplant method
  public void treeDelete(BinTree T, Process z) {
   if (z.getLeft() == null) {
    Transplant(T, z, z.getRight());
   } else if (z.getRight() == null) {
    Transplant(T, z, z.getLeft());
   } else {
    Process y = treeMinimum(z.getRight());
    if (y.getParent() != z) {
     Transplant(T, y, y.getRight());
     y.setRight(z.getRight());
     y.getRight().setParent(y);
    }
    Transplant(T, z, y);
    y.setLeft(z.getLeft());
    y.getLeft().setParent(y);
   }
  }


 }