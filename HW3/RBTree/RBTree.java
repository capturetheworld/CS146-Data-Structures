package RBTree;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class RBTree {
	 private Node root = null;
	 
	




	 public static void main(String[] args) {

	  Scanner scan = new Scanner(System.in);
	  RBTree mainTree = new RBTree();




	  mainTree.insert(mainTree, new Node("1InternetExplorer", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("2Eclipse", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("3Sketch", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("4Illustrator", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("5Photoshop", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("6OneNote", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("7Word", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("8PowerPoint", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("9Chrome", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("10Github", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("11Excel", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("12Outlook", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("13Selfcontrol", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("14Snapchat", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("15Twitter", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("16SmartVideohub", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("17ProVideoPlayer", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("18FireFox", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("19Photos", mainTree.generatePriority(mainTree)));
	  mainTree.insert(mainTree, new Node("20ProPresenter", mainTree.generatePriority(mainTree)));

	  //System.out.println("broken");
//	  mainTree.insert(mainTree, new Node("1InternetExplorer", 11));
//	  mainTree.insert(mainTree, new Node("2Eclipse", 2));
//	  mainTree.insert(mainTree, new Node("3Sketch", 14));
//	  mainTree.insert(mainTree, new Node("4Illustrator", 1));
//	  mainTree.insert(mainTree, new Node("5Photoshop", 7));
//	  mainTree.insert(mainTree, new Node("6OneNote", 15));
//	  mainTree.insert(mainTree, new Node("7Word", 5));
//	  mainTree.insert(mainTree, new Node("8PowerPoint", 8));
//	  mainTree.insert(mainTree, new Node("9Chrome", 4));
	 
	  int x = 0;
	  while (x < 1000) {
	   System.out.println("\n >>>>>  MAIN MENU | CHOOSE AN ACTION  <<<<< \n1. Insert \n\t2. Delete \n\t\t3. Print Sorted List\n\t\t\t 4. Search\n\t\t\t\t5. Quit");
	   switch (Integer.parseInt(scan.nextLine())) {

	    case 1:

	     mainTree.printLevelOrder(mainTree,mainTree.root);	
	     System.out.println("Enter a name:");
	     String str = scan.nextLine();
	     System.out.println("Enter a priority:");
	     int prio = Integer.parseInt(scan.nextLine());
	     mainTree.insert(mainTree, new Node(str, prio));
	     System.out.println("Insert Complete.");
	     mainTree.printLevelOrder(mainTree,mainTree.root);	

	     break;
	    case 2:
	     mainTree.printLevelOrder(mainTree,mainTree.root);	
	     System.out.println("Enter the Priority of what you want to delete:");
	     int key = Integer.parseInt(scan.nextLine());
	     Node toDelete = mainTree.search(mainTree.root, key);
	     if (toDelete != null) {
	      mainTree.delete(mainTree, toDelete);
	     }
	     System.out.println("Delete Complete");
	     mainTree.printLevelOrder(mainTree,mainTree.root);	

	     break;
	    case 3:
	     System.out.println("Printing...");
	     mainTree.inordertreeWalk(mainTree.root);

	     break;
	    case 4:
		     System.out.println("Search");
		     System.out.println("Enter a priority:");
		     int prio2 = Integer.parseInt(scan.nextLine());
		     Node found = mainTree.search(mainTree.root,prio2);
		     found.printData();
		     break;
	    case 5:
	     System.out.println("PROGRAM OFF");
	     x = 1000;
	     break;

	   
	      
	     }
	      
	      
	   
	      
	     

	     

	     }
	     
	     
	   }
	  

	 
	 
	

	  
	//Searches for the Node comparing (starting at root first) with the key
	  public Node search(Node compare, int key) {
	   if (compare == null)
	    return null;
	   else if (compare.getPriority() == key)
	    return compare;
	   if (compare.getPriority() > key) {
	    return search(compare.getLeft(), key);
	   }

	    return search(compare.getRight(), key);


	  }
	  
	  
	  //generates a random unique priority
	  public int generatePriority(RBTree T) {
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
	  
	
	  
	//prints out (in order) the processes
	  public void inordertreeWalk(Node x) {
	   if (x != null) {
	    inordertreeWalk(x.getLeft());
	    x.printData();
	    inordertreeWalk(x.getRight());
	   }
	  }
	  
	  
	  
	  
	//finds the minimum of the given tree, usually starts with root node
	  public Node treeMinimum(Node x) {
	   while (x.getLeft() != null) {
	    x = x.getLeft();
	   }
	   return x;
	  }

	  
	  
	  
	  
	  /////////////////////
	  
	 //Right Rotate, rotates node to the right
	  public void rightRotate(RBTree T, Node y) {
		  Node x = y.getLeft();
		  y.setLeft(x.getRight());
		  if (x.getRight()!=null) //if the left child isn't null set it's parent to x
			  x.getRight().setParent(y);
		  x.setParent(y.getParent()); //set x's parent to y's parent
		  if(x.getParent()==null) //if it was the root, there was no grandparent
			  T.root = x;
		  else if (y==y.getParent().getLeft()) //if y was on the left, y's parent should have it's left set to x
			  y.getParent().setLeft(x);
		  else
			  y.getParent().setRight(x);
		  x.setRight(y);
		  y.setParent(x);
			  
		  	
	  }
	
	  
	  
	  //Left Rotate, rotates nodes to the left
	  public void leftRotate(RBTree T, Node x) {
		  Node y = x.getRight();
		  x.setRight(y.getLeft());
		  if (y.getLeft()!=null) //if the left child isn't null set it's parent to x
			  y.getLeft().setParent(x);
		  y.setParent(x.getParent()); //set y's parent to x's parent
		  if(x.getParent()==null) //if it was the root, there was no grandparent
			  T.root = y;
		  else if (x==x.getParent().getLeft()) //if x was on the left, y should be set that way
			  x.getParent().setLeft(y);
		  else
			  x.getParent().setRight(y);//if x was on the right, y should be set that way
		  y.setLeft(x);
		  x.setParent(y);
			  
		  	
	  }
	
	  
	  
	  //Insert a node
	  public void insert(RBTree T, Node z) {
		  Node y = null;
		  Node x = T.root;
		  while (x!=null) {
			  y = x;
			  if(z.getPriority()<x.getPriority())
				  x=x.getLeft();
			  else
				  x=x.getRight();
		  }
		  z.setParent(y);
		  

		  if(y==null) {
			  
			  T.root=z;
			
		  }
		  else if(z.getPriority()<y.getPriority()) {
			  y.setLeft(z);
		  }
		  else {
			  y.setRight(z);
		  }
		  z.setLeft(null);
		  z.setRight(null);
		  z.setRed();
		  //System.out.println("WHAT");
		 // z.printData();
		  insertFixup(T,z);
	  }

	  
	  
	  //fix the insertion of a node, recolors, and rotates
	  public void insertFixup(RBTree T, Node z) {
		  if(T.root!=z) {
			 // System.out.println("Root is not z");
		  }
		 
			  
		  while(z.getParent()!=null && z.getParent().getColor()=='r') {
			  if(z.getParent()==z.getParent().getParent().getRight()) {//if z's parent is the left of gparent
				  Node uncle=z.getParent().getParent().getRight();//set uncle to right
				  //CASE 1
				  //Uncle is red
				  //Recolor parent, grandparent, uncle
				  if(uncle.getColor()=='r') {
					  z.getParent().setBlack();
					  uncle.setBlack();
					  z.getParent().getParent().setRed();
					  z=z.getParent().getParent();
					  }
				  //CASE 2
				  //Uncle is black, triangle
				  //Rotate z parent in opposite direction of z
				  else if(z==z.getParent().getRight()) {
					  z=z.getParent();
					  leftRotate(T,z);
				  }
				  
				  //CASE 3
				  //Uncle is black, line
				  //rotate grandparent opposite direction
				  //recolor parent and grandparent
				  else {
					  z.getParent().setBlack();
					  z.getParent().getParent().setRed();
					  rightRotate(T,z.getParent().getParent());
				  }
				  
			  }
			  else {//if z's parent is the right of gparent
				  Node uncle=z.getParent().getParent().getLeft();//set uncle to right
				  //CASE 1
				  //Uncle is red
				  //Recolor parent, grandparent, uncle
				  if(uncle.getColor()=='r') {
					  z.getParent().setBlack();
					  uncle.setBlack();
					  z.getParent().getParent().setRed();
					  z=z.getParent().getParent();
					  }
				  //CASE 2
				  //Uncle is black, triangle
				  //Rotate z parent in opposite direction of z
				  else if(z==z.getParent().getLeft()) {
					  z=z.getParent();
					  rightRotate(T,z);
				  }
				  
				  //CASE 3
				  //Uncle is black, line
				  //rotate grandparent opposite direction
				  //recolor parent and grandparent
				  else {
					  z.getParent().setBlack();
					  z.getParent().getParent().setRed();
					  leftRotate(T,z.getParent().getParent());
				  }
				  
			  }
		  }
		  
		 T.root.setBlack();
		 
	  }
	  
	  //Transplant subtree
	  //transplants the tree and all of its child nodes with another tree and its child nodes
	  public void Transplant(RBTree T, Node u, Node v) {
		  if(u.getParent()==null)
			  T.root = v;
		  else if (u==u.getParent().getLeft())
			  u.getParent().setLeft(v);
		  else
			  u.getParent().setRight(v);
		  v.setParent(u.getParent());
	  }

	  
	  
	  //Delete a node
	  
	  public void delete(RBTree T, Node z) {
		  Node y = z;
		  Node x = null;
		  char yoriginalcolor = y.getColor();
		  if(z.getLeft()==null) {
			  x = z.getRight();
			  Transplant(T,z,z.getRight());//transplant
		  }
		  else if(z.getRight()==null) {
			  x = z.getLeft();
			  Transplant(T,z,z.getLeft());//transplant
		  }
		  else {
			  y=treeMinimum(z.getRight());
			  x = y.getRight();
			  if(y.getParent()==z) {
				  x.setParent(y);
			  }
			  else {
				  Transplant(T,y,y.getRight());//transplant
				  y.setRight(z.getRight());
				  y.getRight().setParent(y);
			  }
			  Transplant(T,y,y.getRight());
			  y.setLeft(z.getLeft());
			  y.getLeft().setParent(y);
			  y.setColor(z.getColor());
			  
		  }
		  if(yoriginalcolor == 'b') {
			  deleteFixup(T,x);
		  }
		  
		  
	  }
	  
	  //delete Fixup
	  public void deleteFixup(RBTree T, Node x) {
		  while(x!=root &&x.getColor()=='b') {
			  if(x==x.getParent().getLeft()) {
				  Node w = x.getParent().getRight();
				  if(w.getColor()=='r') {
					  w.setBlack();
					  x.getParent().setRed();
					  leftRotate(T,x.getParent());
					  w=x.getParent().getRight();
				  }
				  
				  //case 2 both of w's children are black
				 if(w.getLeft().getColor()=='b'&& w.getRight().getColor()=='b') {
					 w.setRed();
					 x=x.getParent();
				 }
				 else{
					 
				 if (w.getRight().getColor()=='b') {
					 w.getLeft().setBlack();
					 w.setRed();
					 rightRotate(T,w);
					 w=x.getParent().getRight();
				 	}
				 w.setColor(x.getParent().getColor());
				 x.getParent().setBlack();
				 w.getRight().setBlack();
				 leftRotate(T,x.getParent());
				 x = root;
				
				 }
			  }
			  else {
				  Node w = x.getParent().getLeft();
				  if(w.getColor()=='r') {
					  w.setBlack();
					  x.getParent().setRed();
					  rightRotate(T,x.getParent());
					  w=x.getParent().getLeft();
				  }
				  
				  //case 2 both of w's children are black
				 if(w.getRight().getColor()=='b'&& w.getLeft().getColor()=='b') {
					 w.setRed();
					 x=x.getParent();
				 }
				 else{
					 
				 if (w.getLeft().getColor()=='b') {
					 w.getRight().setBlack();
					 w.setRed();
					 leftRotate(T,w);
					 w=x.getParent().getLeft();
				 	}
				 w.setColor(x.getParent().getColor());
				 x.getParent().setBlack();
				 w.getLeft().setBlack();
				 rightRotate(T,x.getParent());
				 x = root;
				
				 }
				  
			  }
			  x.setBlack();
		  }
	  }
	  
	  


//Print out level order and draw it out
void printLevelOrder(RBTree T, Node root)
{
    
    if(T.root == null)
        return;
     
 
    Queue<Node> q =new LinkedList<Node>();
     
    q.add(T.root);
     
     
    while(true)
    {
         
        int countNodes = q.size();
        if(countNodes == 0)
            break;
         
        while(countNodes > 0)
        {
            Node current = q.peek();
            current.printKey();current.printColor();System.out.print(" ");
            q.remove();
            if(current.getLeft() != null)
                q.add(current.getLeft());
            if(current.getRight() != null)
                q.add(current.getRight());
            countNodes--;
        }
        System.out.println();
    }
}
	  
	  
	  
	  
	  

	  
//////////////////////////////////	 	 

}
