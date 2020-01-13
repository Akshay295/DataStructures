package linkedlist;

public class LinkedListCRUD {

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		list.insertBegining(new Node(5));
		list.insertBegining(new Node(6));
		list.insertBegining(new Node(7));
		
		list.insertEnd(new Node(8));
		list.insertEnd(new Node(11));
		list.insertEnd(new Node(12));
		
		list.insertPosition(1, new Node(100));		
		list.printList();
		list.length();
		
	}

}

class LinkedList{
	Node head;
	
	
	public Node insertEnd(Node node) {
		Node currentNode=head;
		if(currentNode==null) {
			head=node;
			return node;
		}
			
		while(currentNode.nextNode!=null) {
			currentNode=currentNode.nextNode;
		}
		currentNode.nextNode=node;
		return node;
	}
	
	public Node insertPosition(int position,Node node) {
		Node currentNode=head;
		Node prevNode=head;
		int currentPosition=0;
		while(currentPosition!=position) {
			currentPosition++;
			prevNode=currentNode;
			currentNode=currentNode.nextNode;
		}
		prevNode.nextNode=node;
		node.nextNode=currentNode;
		
		return node;
	}
	
	public Node insertBegining(Node node) {
		if(head==null) {
			head=node;
		}else {
			node.nextNode=head;
			head=node;
		}
		return node;
	}
	
	public int length() {
		int length=0;
		Node currentNode=head;
		while(currentNode!=null) {
			length++;
			currentNode=currentNode.nextNode;
		}
		System.out.println("Length : "+length);
		return length;
	}
	
	public void printList() {
		Node currentNode=head;
		while(currentNode!=null) {
			System.out.println(currentNode.getData());
			currentNode=currentNode.nextNode;
		}
	}
	
	
}


class Node{
	
	int data;
	Node nextNode;
	
	public Node(int data) {
		this.data=data;
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
