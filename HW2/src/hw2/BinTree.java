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




  mainTree.treeInsert(mainTree, new Process("1InternetExplorer", 82));
  mainTree.treeInsert(mainTree, new Process("2Eclipse", 84));
  mainTree.treeInsert(mainTree, new Process("3Sketch", 73));
  mainTree.treeInsert(mainTree, new Process("4Illustrator", 4));
  mainTree.treeInsert(mainTree, new Process("5Photoshop", 75));
  mainTree.treeInsert(mainTree, new Process("6OneNote", 85));
  mainTree.treeInsert(mainTree, new Process("7Word", 24));
  mainTree.treeInsert(mainTree, new Process("8PowerPoint", 38));
  mainTree.treeInsert(mainTree, new Process("9Chrome", 1000));
  mainTree.treeInsert(mainTree, new Process("10Github", 47));
  mainTree.treeInsert(mainTree, new Process("11Excel", 77));
  mainTree.treeInsert(mainTree, new Process("12Outlook", 23));
  mainTree.treeInsert(mainTree, new Process("13Selfcontrol", 29));
  mainTree.treeInsert(mainTree, new Process("14Snapchat", 32));
  mainTree.treeInsert(mainTree, new Process("15Twitter", 95));
  mainTree.treeInsert(mainTree, new Process("16SmartVideohub", 87));
  mainTree.treeInsert(mainTree, new Process("17ProVideoPlayer", 66));
  mainTree.treeInsert(mainTree, new Process("18FireFox", 98));
  mainTree.treeInsert(mainTree, new Process("19Photos", 43));
  mainTree.treeInsert(mainTree, new Process("20ProPresenter", 92));


  
  int x = 0;
  while (x < 1000) {
   System.out.println("\nMain Menu >>>>> Choose an action: \n1. Insert \n\t2. Delete \n\t\t3. Print Sorted List\n\t\t\t 4. Quit " + "\n\t\t\t\t 5. Switch to Hashtable");
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

  public void inordertreeWalk(Process x) {
   if (x != null) {
    inordertreeWalk(x.getLeft());
    x.printData();
    inordertreeWalk(x.getRight());
   }
  }

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
  
  public  LinkedList<Process>[] gethashTable(BinTree T){
	  return hashTable;
  }

  public void treeInsert(BinTree T, Process z) {
   Process y = null;
   Process x = T.root;
   while (x != null) {
    y = x;
    if (z.getPriority() < x.getPriority()) {
     x = x.getLeft();
    } else {
     x = x.getRight();
    }
    z.setParent(y);

   }
   if (y == null) {
    T.root = z;
   } else if (z.getPriority() < y.getPriority()) {
    y.setLeft(z);
   } else {
    y.setRight(z);
   }
  }

  public Process treeMinimum(Process x) {
   while (x.getLeft() != null) {
    x = x.getLeft();
   }
   return x;
  }

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