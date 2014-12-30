package Q13kthlastpointer;

public class kthLastPointer{
	Node pointer1 ;
	Node pointer2 ;
	
	public int findKthLastPointer(linkList list, int k){
		pointer1 = list.head;
		pointer2 = list.head;
		
		for(int i = 0; i <= k; i++){
			pointer1 = pointer1.next;
		}
		while(pointer1 != list.tail){
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer2.key;
		
	}
	
}

class Node{
	int key;
	Node next;
	public Node(int key){
		this.key = key;
	}
	
}

class linkList{
	Node head;
	Node tail;
	public void add(int i){
		Node newNode = new Node(i);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}
	}
}