package Linklist;
public class Link{
	public String bookName;
	public int millionsSold;
	
	public Link next;
	
	public Link(String bookName, int millionsSold){
		this.bookName=bookName;
		this.millionsSold=millionsSold;
	}
	
	public void display(){
		System.out.println(bookName + " : " + millionsSold);

	}
	
	public String toString(){
		return bookName;
	}
	
	public static void main(String[] args){
		 Linklist theLinkedList = new Linklist();
		 	         
		 	        // Insert Link and add a reference to the book Link added just prior
		 	        // to the field next
		 	         
		 	        theLinkedList.insertFirstLink("Don Quixote", 500);
		 	        theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		 	        theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		 	        theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
		 	         
		 	        theLinkedList.displayLinkList();
		 	         
		 	        System.out.println("Value of first in LinkedList " + theLinkedList.firstLink + "\n");
		 	         
		 	        // Removes the last Link entered
		 	         
		 	        theLinkedList.removeFirstLink();
		 	         
		 	        theLinkedList.displayLinkList();
		 	         
		 	        System.out.println(theLinkedList.search("A Tale of Two Cities").bookName + " Was Found");
		 	         
		 	        theLinkedList.removeLink("A Tale of Two Cities");
		 	         
		 	        System.out.println("\nA Tale of Two Cities Removed\n");
		 	         
		 	        theLinkedList.displayLinkList();
		 	         
		 	        theLinkedList.search("A Tale of Two Cities");
		 	        
   		 	        theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
   		 	        
   		 	        theLinkedList.removeLink("The Lord of the Rings");
   		 	        
   		 	        theLinkedList.displayLinkList();
		 	    
	}
		 	     
		 

	}
	

class Linklist{
	public Link firstLink;
	Linklist(){
		firstLink=null;
		
	}
	
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	public void insertFirstLink(String bookName, int millionsSold){
		
		Link newLink = new Link(bookName, millionsSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirstLink(){
		Link linkReference = firstLink;
		if(!isEmpty()){
			 firstLink = firstLink.next;
			
		}else{
			System.out.println("The linklist is empty");
		}
		
		return linkReference;
	}
	
	public void displayLinkList(){
		Link theLink = firstLink;
		
		while(theLink != null){
			theLink.display();
			
			System.out.println("NextLink: " + theLink.next);
			
			theLink = theLink.next;
			
			System.out.println();
		}
	}
	
	public Link search(String bookName){
		Link theLink = firstLink;
		
		while(theLink.bookName != bookName && theLink.next != null){
			
			theLink = theLink.next;
		}
		
		if (theLink.bookName == bookName){
			theLink.display();			
			return theLink;
		}else{
			System.out.println("Cannot find the book: " + bookName);			
			return null;
		}
		
	}
	
	public Link removeLink(String bookName){
		Link theLink = firstLink;
		Link previousLink = firstLink;
		
		while(theLink.bookName != bookName && theLink.next!= null){
			previousLink = theLink;
			theLink = theLink.next;
		}
		
		if(theLink == firstLink){
			removeFirstLink();
		}else if(theLink.bookName == bookName){
			previousLink.next = theLink.next;
		}
		
		return theLink;
		
	}
}