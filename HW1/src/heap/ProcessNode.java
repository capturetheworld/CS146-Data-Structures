package heap;

public class ProcessNode {
	private String name;
	private int index;//priority
	//private int time;
	
	
	ProcessNode(String n,int i){
		this.index=i;
		this.name=n;
		
	}
	
	ProcessNode(){
		this("foobar", Heap.generateUniqueID());
		System.out.println("You forgot to create a process with the form: name, priority \n A \"foobar\" process and random priority have been generated ");
		
		
	
	}
	
	int getPriority() {
		return index;//returns priority index, larger is more Priority
	}
	
	void setPriority(int i) {
		index=i;//changes the priority index of this node, but keeps process name
	}
	String getName() {
		return name;
	}
	
	void printName() {
		System.out.println(name);
	}
	
	void printData() {
		System.out.println(name + " ········Index:" + index);
	}
	
	
	
	

}
