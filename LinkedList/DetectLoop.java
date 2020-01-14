package linkedlist.three;


public abstract class DetectLoop {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		System.out.println("Inserting at end");
		list.insertEnd(new Node(5));
		list.insertEnd(new Node(6));
		Node n1=new Node(101);
		list.insertEnd(n1);
		list.insertEnd(new Node(2));
		list.insertEnd(new Node(55));
		list.insertEnd(new Node(67));
		list.insertEnd(new Node(77));
		list.insertEnd(new Node(9));
		Node n2=new Node(90);
		list.insertEnd(n2);
		
		n2.nextNode=n1;
		

		boolean result = list.detectLoop();
		System.out.println("Contains Loop : " + result);

	}

}

class LinkedList {
	Node head;

	public boolean detectLoop() {

		if (head != null) {
			Node slowPointer = head;
			Node fastPointer = head;
			while (fastPointer != null && fastPointer.nextNode != null) {
				slowPointer = slowPointer.nextNode;
				fastPointer = fastPointer.nextNode.nextNode;
				if(slowPointer.data==fastPointer.data)
					return true;
			}
			return false;
		} else {
			return false;
		}

	}

	public Node insertEnd(Node node) {
		Node currentNode = head;
		if (currentNode == null) {
			head = node;
			return node;
		}

		while (currentNode.nextNode != null) {
			currentNode = currentNode.nextNode;
		}
		currentNode.nextNode = node;
		return node;
	}

	public int length() {
		int length = 0;
		Node currentNode = head;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.nextNode;
		}
		return length;
	}

	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}

}

class Node {

	int data;
	Node nextNode;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}