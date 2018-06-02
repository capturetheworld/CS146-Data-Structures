package RBTree;

public class Node {
	

		private String name;
		private int key;//priority
		private Node left;//BSTLeftChild
		private Node right;//BSTRightChild
		private Node p = null;//BSTParent
		private char color ='r';
		
		
		//noargs ctor
		Node(){System.out.println("ERROR: You forgot to create a Node with the form: name, priority");}
		//ctor
		Node(String name,int key){
			this.key=key;
			this.name=name;
		}
		
		
		//Color
		public void setRed() {
			color='r';
		}
		 public void setBlack() {
			 color='b';
		}
		 public char getColor() {
			 return color;
		}
		 public void setColor(char co) {
			 color = co;
		}
		//Getters/Setters BST
		void setLeft(Node setTo) {
			left=setTo;
		}
		void setRight(Node setTo) {
			right=setTo;
		}
		void setParent(Node setTo) {
			p=setTo;
		}
		Node getLeft() {
			return left;
		}
		Node getRight() {
			return right;
		}
		Node getParent() {
			return p;
		}

		
		//Node Priority
		int getPriority() {
			return key;//returns priority index, larger is more Priority
		}
		
		void setPriority(int i) {
			key=i;//changes the priority index of this node, but keeps Node name
		}
		String getName() {
			return name;
		}
		
		void printName() {
			System.out.println(name);
		}
		void printKey() {
			System.out.print(key);
		}
		void printColor() {
			System.out.print(color);
		}
		
		
		void printData() {
			System.out.println(name + " ---------- Priority:" + key + " ---------- Color:" + color);
		}
		
		
		
		

	}


