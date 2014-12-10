package Q7linkedListIntersection;
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//ONLY can determine if the two linkedLists are intersected. Cannot return 
//the intersect points.
//main function was not created; how to use insert to create a loop remains
//a problem.
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class linkedListIntersection{
	public linkedList list1;
	public linkedList list2;
	
	public linkedListIntersection(linkedList list1, linkedList list2){
		this.list1 = list1;
		this.list2 = list2;
	}
	
public boolean checkIntersection(){
		Node thisNode = list1.head;
		Node thisNode2 = list2.head;
		
		if(list1.hasLoop()&&list2.hasLoop()){
			thisNode = list1.LoopOrigin();
			thisNode2 = list2.LoopOrigin();
			while(thisNode.next != list1.LoopOrigin()){
				thisNode = thisNode.next;
			}
			while(thisNode2.next != list2.LoopOrigin()){
				thisNode2 = thisNode2.next;
			}
			return thisNode == thisNode2;
		}
		else if(list1.hasLoop()||list2.hasLoop()){
			return false;
		}
		else{
			while(thisNode.next != null){
				thisNode = thisNode.next;
			}
			while(thisNode2.next != null){
				thisNode2 = thisNode2.next;
			}
			return thisNode == thisNode2;
		}
	
	
}

class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
	}
	
	
}

class linkedList{
	public Node head;
	public linkedList(){
		this.head = null;
	}
	public void insert(int value){
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
				
		}
	
	public void display(){
		Node theNode = head;
		while(theNode != null){
			System.out.print(theNode+" ");
		}
	}
	
	public boolean hasLoop(){
		Node pSlow = head;
		Node pFast = head;
		while(pFast.next != null && pFast.next.next != null){
			pSlow = pSlow.next;
			pFast = pFast.next.next;
			if(pSlow == pFast) break;
		}
		return !(pSlow==null||pFast==null);
	}
	
	public Node LoopOrigin(){
		Node pSlow = head;
		Node pFast = head;
		Node pOrigin = head;
		while(pFast.next != null && pFast.next.next != null){
			pSlow = pSlow.next;
			pFast = pFast.next.next;
			if(pSlow == pFast)break;
		}
		while(pOrigin != pSlow){
			pSlow = pSlow.next;
			pOrigin = pOrigin.next;
		}
		return pOrigin;
			
		
	}
}}

	
	
