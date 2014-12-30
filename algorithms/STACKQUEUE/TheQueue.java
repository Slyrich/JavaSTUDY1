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
	
	public void priorityInsert(String input){
		int i;
		if(numberOfItems==0){
			insert(input);
		}else{
			for(i = rear; i>=0; i--){
				if(Integer.parseInt(input)>Integer.parseInt(queueArray[i])){
					queueArray[i+1]=queueArray[i];
				}else break;

			}
			queueArray[i+1]=input;
			System.out.println("INSERT " + queueArray[i+1]);
			rear++;
			numberOfItems++;
			
		}
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
		System.out.println();
		System.out.println("======================");
		for(int i = 0; i <=rear; i++){
			if(queueArray[i].equals("-1")) System.out.print("   ");
			else System.out.print(queueArray[i] + " ");
		}
		System.out.println();
		System.out.println("======================");
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		theQueue queue = new theQueue(10);
		queue.displayQueue();
		queue.insert("2");
		queue.insert("7");
		queue.insert("6");
		queue.insert("8");
		queue.insert("4");
		queue.insert("3");
		queue.displayQueue();
		queue.remove();
		queue.displayQueue();
		queue.remove();
		queue.displayQueue();
		queue.remove();
		queue.displayQueue();
		queue.insert("4");
		queue.displayQueue();
		queue.priorityInsert("1");
		queue.displayQueue();
		queue.priorityInsert("5");
		queue.displayQueue();
	}
}