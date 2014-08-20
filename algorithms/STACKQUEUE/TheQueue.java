package STACKQUEUE;

import java.util.Arrays;

public class theQueue{
	
	private String[] queueArray;
	private int queueSize;
	private int front, rear, numberOfItems = 0;
	
	theQueue(int size){
		queueSize = size;
		queueArray = new String[size];
		
		Arrays.fill(queueArray,"-1");

	}
	
	public void insert(String input){
		if(numberOfItems + 1 <= queueSize){
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			System.out.println("INSERT " + queueArray[rear - 1] + " was added");
		}
		else System.out.println("Sorry, the queue is full");
	}
	
	public void remove(){
		if(numberOfItems > 0){
			System.out.println("REMOVE " + queueArray[front]);
			queueArray[front] = "-1";
			front++;
			numberOfItems--;
			

		}
		else System.out.println("Sorry, the queue is empty");
	}
	
	public void peak(){
		
		System.out.println(queueArray[front]);
	}

	public void displayQueue(){
		for(int i= front; i <= rear; i++)
	}
	
	
	
	public static void main(String[] args){
		theQueue queue = new theQueue(10);
		queue.insert("8");
		queue.insert("7");
		queue.insert("6");
		queue.insert("5");
		queue.insert("4");
		queue.insert("3");
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
	}
}