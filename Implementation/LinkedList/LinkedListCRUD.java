package linkedlist;

public class LinkedListCRUD {

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		
		System.out.println("Inserting at begining");
		list.insertBegining(new Node(5));
		list.insertBegining(new Node(6));
		list.insertBegining(new Node(7));
		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Inserting at end");
		list.insertEnd(new Node(8));
		list.insertEnd(new Node(11));
		list.insertEnd(new Node(12));
		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Inserting at position 3");
		
		list.insertPosition(3, new Node(100));		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Deleting first Node");
		
		list.deleteFirstNode();
		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Deleting last node");
		
		list.deleteLastNode();
		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Deleting position 2 node");
		
		list.deleteAtPosition(2);
		
		list.printList();
		System.out.println("Length : "+list.length());
		
		System.out.println("Clearing Complete List");
		list.clearList();
		System.out.println("Length : "+list.length());
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
		if(position<0) {
			position=0;
		}
		int length=length();
		if(position>length) {
			position=length;
		}
		
		if(head==null) {
			head=node;
		}else if(position==0) {
			node.nextNode=head;
			head=node;
		}else {
			Node temp=head;
			for(int i=1;i<position;i++) {
				temp=temp.nextNode;
			}
			node.nextNode=temp.nextNode;
			temp.nextNode=node;
			
		}
		
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
	
	public void deleteFirstNode() {
		if(head.nextNode!=null) {
		head=head.nextNode;
		}else if(head!=null) {
			head=null;
		}
	}
	
	public void deleteLastNode() {
		if(head==null)
			return;
		if(head.nextNode==null) {
			head=null;
			return;
		}
		
		Node currentNode=head;
		while(currentNode.nextNode.nextNode!=null) {
			currentNode=currentNode.nextNode;
		}
		currentNode.nextNode=null;
	}
	
	public void deleteAtPosition(int position) {
		if(position<0) {
			position=0;
		}
		int length=length();
		if(position>=length) {
			position=length-1;
		}
		if(head==null)
			return;
		if(position==0) {
			head=head.nextNode;
		}else {
			Node temp=head;
			for(int i=1;i<position;i++) {
				temp=temp.nextNode;
			}
			temp.nextNode=temp.nextNode.nextNode;
			
		}
		
		
	}
	
	public int length() {
		int length=0;
		Node currentNode=head;
		while(currentNode!=null) {
			length++;
			currentNode=currentNode.nextNode;
		}
		return length;
	}
	
	public void printList() {
		Node currentNode=head;
		while(currentNode!=null) {
			System.out.print(currentNode.getData()+" ");
			currentNode=currentNode.nextNode;
		}
		System.out.println();
	}
	
	public void clearList() {
		head=null;
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
