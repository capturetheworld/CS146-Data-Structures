package hw2;

public class BinTree {
	
	private  Process root=null;
	
	
	
	 public static void main(String[] args) {
		 
		 
	 }
	 
	 public static void treeInsert(BinTree T, Process z) {
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
	 
	 public static Process treeMinimum(Process x) {
		 while(x.getLeft()!=null) {
			 x=x.getLeft();
		 }
		 return x;
	 }
	 
	 public static void Transplant(BinTree T, Process u, Process v) {
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
	 
	 public static void treeDelete(BinTree T, Process z){
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
