package Linklist;
class Neighbor {
	public String homeOwnerName;
	public int houseNumber;
	
	public Neighbor next;
	public Neighbor previous;
	
	public Neighbor(String homeOwnerName, int houseNumber){
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}
	
	public void display(){
		System.out.println(homeOwnerName + " : " + houseNumber + " Private Drive");
		
	}
	
	public String toString(){
		return homeOwnerName;
	}
}

class NeighborIterator{
	Neighbor currentNeighbor;
	Neighbor previousNeighbor;
	
	DoubleEndedLinkList theNeighbors;
	
	NeighborIterator(DoubleEndedLinkList theNeighbors){
		this.theNeighbors = theNeighbors;
		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;
		
	}
	
	public boolean hasNext(){
		if (currentNeighbor.next != null){
			return true;
		}
		return false;
	}

	public Neighbor next(){
		if(hasNext()){
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
			
			return currentNeighbor.next;
		}
		return null;
	}
	
	public void remove(){
		if(currentNeighbor == theNeighbors.firstLink){
			theNeighbors.firstLink = currentNeighbor.next;			
		}
		else{
			previousNeighbor.next = currentNeighbor.next;
			if(currentNeighbor.next == null){
				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;
				
			}else{
				currentNeighbor = currentNeighbor.next;
			}
		}
	}
}

public class DoubleEndedLinkList{
	Neighbor firstLink;
	Neighbor lastLink;
	
	
	public void insertFirstPosition(String homeOwnerName, int houseNumber){
	
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		if(isEmpty()){
			lastLink = theNewLink;
		}else{
			firstLink.previous = theNewLink;
		}
		
		theNewLink.next = firstLink;
		firstLink = theNewLink;
		
	}
	
	public void insertLastPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		
		if(isEmpty()){
			firstLink = theNewLink;
			lastLink = theNewLink;
		}else{
			
			lastLink.next = theNewLink;
			theNewLink.previous = lastLink;
		}
		
		lastLink = theNewLink;
		
	}
	
	public boolean isEmpty(){
		if(firstLink == null){
			return true;
		}
		return false;
	}
	
	public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		Neighbor currentNeighbor = firstLink;
		
		while(currentNeighbor.houseNumber != key){
			currentNeighbor = currentNeighbor.next;
			
			if(currentNeighbor == null){
				return false;
			}
			
		}
		
		if(currentNeighbor == lastLink){
			lastLink.next = theNewLink;
			theNewLink.previous = lastLink;
			lastLink = theNewLink;
			theNewLink.next = null;
		}else{
			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;
		}
		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;
		
		
		
	}

	public void insertInOrder(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		Neighbor currentNeighbor = firstLink;
		Neighbor previousNeighbor = null;
		
		while((currentNeighbor != null)&&(currentNeighbor.houseNumber < houseNumber)){
		previousNeighbor = currentNeighbor;
		currentNeighbor = currentNeighbor.next;
		
		}
		
		if(previousNeighbor == null){
			firstLink = theNewLink;
			
		}
		else{
			previousNeighbor.next = theNewLink;
			theNewLink.previous = previousNeighbor;
		
		}
		theNewLink.next = currentNeighbor;
		currentNeighbor.previous = theNewLink;
	}

	
	public static void main(String[] args){
		DoubleEndedLinkList theLinkList = new DoubleEndedLinkList();
		theLinkList.insertFirstPosition("Mark Evans", 7);
		theLinkList.insertFirstPosition("Jim Green", 2);
		theLinkList.insertLastPosition("Star War", 9);
		theLinkList.insertLastPosition("Han Meimei", 3);
		theLinkList.insertInOrder("Mark Willams", 1);
		theLinkList.insertInOrder("Tim Curry", 5);
		theLinkList.insertAfterKey("Jackie Chan", 20, 9);
		
		theLinkList.display();
		
		
		System.out.println();
		System.out.println();
		
		NeighborIterator neighbors = new NeighborIterator(theLinkList);
		neighbors.currentNeighbor.display();
		
		System.out.println(neighbors.hasNext());
		
		neighbors.next();
		
		neighbors.currentNeighbor.display();
		
		neighbors.remove();
		
		neighbors.currentNeighbor.display();
		
		theLinkList.display();

		neighbors.next();
		neighbors.next();
		neighbors.next();
		neighbors.next();
		neighbors.currentNeighbor.display();	
		neighbors.next();
		neighbors.currentNeighbor.display();
		neighbors.remove();
		neighbors.currentNeighbor.display();
		theLinkList.display();
		
		
	}
	
	public void display(){
		Neighbor theLink = firstLink;
		while(theLink != null){
			
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			System.out.println("Previous Link: " + theLink.previous);
			theLink = theLink.next;
		
			System.out.println();
		}
	}
} 