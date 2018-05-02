package hw2;

class Process {
	private String name;
	private int key;//priority
	private Process left;//BSTLeftChild
	private Process right;//BSTRightChild
	private Process p;//BSTParent
	private Process next;//linkedlist
	
	
	//noargs ctor
	Process(){System.out.println("ERROR: You forgot to create a process with the form: name, priority");}
	//ctor
	Process(String name,int key){
		this.key=key;
		this.name=name;
	}
	
	
	//LinkedList
	public void setNext(Process setTo) {
		next=setTo;
	}
	 public Process getNext() {
		return next;
	}
	//Getters/Setters BST
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

	
	//Process Priority
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
	
	//linkedlist remainder generator
	 int coded(int s) {
			return key%s;
		}
	
	void printData() {
		System.out.println(name + " ········Priority:" + key);
	}
	
	
	
	

}