package linkedlist.one;

public class NthNodeFromEnd {

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

		list.printList();
		System.out.println("Length : " + list.length());

		int result = list.findNthNodefromEnd(3);
		System.out.println("Result : " + result);

	}

}

class LinkedList {
	Node head;

	public int findNthNodefromEnd(int n) {
		if (n < 0) {
			n = 1;
		}
		int length = length();
		if (n > length) {
			n = length;
		}

		Node slowPointer = head;
		Node fastPointer = head;
		int count = 0;
		while (fastPointer.nextNode != null) {
			count++;
			if (count >= n) {
				slowPointer = slowPointer.nextNode;
			}
			fastPointer = fastPointer.nextNode;
		}
		return slowPointer.data;

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