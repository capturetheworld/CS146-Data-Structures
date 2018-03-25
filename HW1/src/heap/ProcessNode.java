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
		System.out.println("To create a Process Node you must enter a name and priority.");
	}
	
	int getPriority() {
		return index;//returns priority index, larger is more Priority
	}
	
	String getName() {
		return name;
	}
	
	void printName() {
		System.out.println(name);
	}
	
	void printData() {
		System.out.println(name + " ········ID:" + index);
	}
	
	
	
	

}
