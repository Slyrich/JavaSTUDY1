package STACKQUEUE;
import java.util.Arrays;

public class TheStack{
	
	private String[] stackArray;
	
	private int stackSize;
	
	private int topOfStack = -1;
	
	TheStack(int size){
		
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input){
		if(topOfStack + 1 < stackSize){
			topOfStack++;
			stackArray[topOfStack] = input;
			System.out.println(input + " is successfully pushed into the stack");
		}
		else System.out.println("Stack is full");
		
		displayTheStack();
	
	}
	
	public void pushMany(String input){
		String [] temp = input.split(" ");
		for(int i = 0; i < temp.length; i++){
				push(temp[i]);
			}

	}
	
	public String pop(){
		if(topOfStack > -1){
			displayTheStack();
			System.out.println("POP " + stackArray[topOfStack] + " out of the stack");
			stackArray[topOfStack] = "-1";
			topOfStack--;
			return stackArray[topOfStack + 1];
		}
		else{ 
			System.out.println("Stack is empty");
			return "-1";
		}
	}

	public void popAll(){
		for(int i = topOfStack; i >= 0; i--){
			pop();
		}
		
	}
	public String peak(){
		displayTheStack();
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the Top of the stack");
		return stackArray[topOfStack];
	}
	
	public void displayTheStack(){
		System.out.println();
		System.out.println("======================");
		for(int i = 0; i <= topOfStack; i++){
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
		System.out.println("======================");
		System.out.println();
	}

	
	
	public static void main(String[] args){
		
		TheStack stack = new TheStack(10);
		stack.push("abc");	
		stack.push("-15");	
		stack.pushMany("20 99 45");
		stack.displayTheStack();
		stack.pop();
		stack.displayTheStack();
		stack.popAll();
		stack.displayTheStack();
	}
}