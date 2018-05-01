package hw2;
import java.util.Scanner;

public class BinTree {
	
	private  Process root=null;
	
	
	
	 public static void main(String[] args) {
		
		 Scanner scan = new Scanner(System.in);
		 BinTree mainTree = new BinTree();
		 
		 
		 
		
		 mainTree.treeInsert(mainTree, new Process("1InternetExplorer",1));
		 mainTree.treeInsert(mainTree, new Process("2Eclipse",3));
		 mainTree.treeInsert(mainTree, new Process("3Sketch",15));
		 mainTree.treeInsert(mainTree, new Process("4Illustrator",40));
		 mainTree.treeInsert(mainTree, new Process("5Photoshop",75));
		 mainTree.treeInsert(mainTree, new Process("6OneNote",85));
		 mainTree.treeInsert(mainTree, new Process("7Word",23));
		 mainTree.treeInsert(mainTree, new Process("8PowerPoint",38));
		 mainTree.treeInsert(mainTree, new Process("9Chrome",1000));
		 mainTree.treeInsert(mainTree, new Process("10Github",47));
		 mainTree.treeInsert(mainTree, new Process("11Excel",75));
		 mainTree.treeInsert(mainTree, new Process("12Outlook",23));
		 mainTree.treeInsert(mainTree, new Process("13Selfcontrol",29));
		 mainTree.treeInsert(mainTree, new Process("14Snapchat",32));
		 mainTree.treeInsert(mainTree, new Process("15Twitter",95));
		 mainTree.treeInsert(mainTree, new Process("16SmartVideohub",87));
		 mainTree.treeInsert(mainTree, new Process("17ProVideoPlayer",66));
		 mainTree.treeInsert(mainTree, new Process("18FireFox",98));
		 mainTree.treeInsert(mainTree, new Process("19Photos",43));
		 mainTree.treeInsert(mainTree, new Process("20ProPresenter",92));
		
		
		 mainTree.inordertreeWalk(mainTree.root);
		 System.out.println("\n...Above is a list of existing processes...\n");
		 int x=0;
		 while(x<1000) {
	    System.out.println("Choose an action: \n1. Insert \n\t2. Delete \n\t\t3. Print Sorted List Again\n\t\t\t 4. Quit");
		 switch (Integer.parseInt(scan.nextLine())) {
		
	      case 1:
	    	
	    	
	        System.out.println ( "Enter a name:" );
	        String str = scan.nextLine();
	        System.out.println ( "Enter a priority:" );
	        int prio = Integer.parseInt(scan.nextLine());
	        mainTree.treeInsert(mainTree, new Process(str,prio));
	        System.out.println("Insert Complete.");
	        
	        break;
	      case 2:
	        System.out.println ( "You picked option 2" );
	        break;
	      case 3:
	    	  System.out.println ( "Printing..." );
		        mainTree.inordertreeWalk(mainTree.root);
	        System.out.println ( "You picked option 3" );
	        break;
	      case 4:
	    	  System.out.println ( "Quitting..." );
	    	  x=1000;
	    	  break;
	      default:
	        System.err.println ( "Unrecognized option" );
	        break;
	    }
		 }
		 
		 
	 }
	 
	 public void inordertreeWalk(Process x) {
		 if(x!=null) {
			 inordertreeWalk(x.getLeft());
			 x.printData();
			 inordertreeWalk(x.getRight());
		 }
	 }
	 
	 public void treeInsert(BinTree T, Process z) {
		 Process y = null;
		 Process x = T.root;
		 while(x!=null) {
			 y=x;
			 if (z.getPriority() < x.getPriority()) {
				 x = x.getLeft();
			 }
			 else {
				 x = x.getRight();
			 }
			 z.setParent(y);
		    
		 }
		 if(y==null) {
			 T.root = z;
		 }
		 else if (z.getPriority()<y.getPriority()) {
			 y.setLeft(z);
		 }
		 else {
			 y.setRight(z);
		 }
	 }
	 
	 public  Process treeMinimum(Process x) {
		 while(x.getLeft()!=null) {
			 x=x.getLeft();
		 }
		 return x;
	 }
	 
	 public  void Transplant(BinTree T, Process u, Process v) {
		 if(u.getParent()==null) {
			 T.root=v;
		 }
		 else if (u==u.getParent().getLeft()) {
			 u.getParent().setLeft(v);
		 }
		 else { 
			 u.getParent().setRight(v);
		 }
		 if(v!=null) {
			 v.setParent(u.getParent());
		 }
	 }
	 
	 public void treeDelete(BinTree T, Process z){
		 if(z.getLeft()==null) {
			 Transplant(T,z,z.getRight());
		 }
		 else if (z.getRight()==null) {
			 Transplant(T,z,z.getLeft());
		 }
		 else{
			 Process y=treeMinimum(z.getRight());
			 if(y.getParent()!=z) {
				 Transplant(T,y,y.getRight());
				 y.setRight(z.getRight());
				 y.getRight().setParent(y);
			 }
			 Transplant(T,z,y);
			 y.setLeft(z.getLeft());
			 y.getLeft().setParent(y);
		 }
	 }
	 
	
}


 class Process {
	private String name;
	private int key;//priority
	private Process left;
	private Process right;
	private Process p;
	
	
	
	Process(String name,int key){
		this.key=key;
		this.name=name;
		
	}
	
	Process(){
		
		System.out.println("ERROR: You forgot to create a process with the form: name, priority");
		
	
	}
	void setLeft(Process setTo) {
		left=setTo;
	}
	void setRight(Process setTo) {
		right=setTo;
	}
	void setParent(Process setTo) {
		p=setTo;
	}
	Process getLeft() {
		return left;
	}
	Process getRight() {
		return right;
	}
	Process getParent() {
		return p;
	}

	
	
	int getPriority() {
		return key;//returns priority index, larger is more Priority
	}
	
	void setPriority(int i) {
		key=i;//changes the priority index of this node, but keeps process name
	}
	String getName() {
		return name;
	}
	
	void printName() {
		System.out.println(name);
	}
	
	
	
	void printData() {
		System.out.println(name + " ········Index:" + key);
	}
	
	
	
	

}
