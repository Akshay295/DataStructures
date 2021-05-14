package linkedlist.two;

public class MiddleNode {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		System.out.println("Inserting at end");
		list.insertEnd(new Node(5));
		list.insertEnd(new Node(6));
		list.insertEnd(new Node(101));
		list.insertEnd(new Node(2));
		list.insertEnd(new Node(55));
		list.insertEnd(new Node(67));
		list.insertEnd(new Node(77));
		list.insertEnd(new Node(9));
		list.insertEnd(new Node(90));

		list.printList();
		System.out.println("Length : " + list.length());

		int result = list.findMiddleNode();
		System.out.println("Middle Element : " + result);

	}

}

class LinkedList {
	Node head;

	public int findMiddleNode() {

		if (head != null) {
			Node slowPointer = head;
			Node fastPointer = head;
			while (fastPointer != null && fastPointer.nextNode != null) {
				slowPointer = slowPointer.nextNode;
				fastPointer = fastPointer.nextNode.nextNode;
			}
			return slowPointer.data;
		} else {
			return 0;
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