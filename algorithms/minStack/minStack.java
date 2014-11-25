package minStack;

import java.util.List;

public class minStack{
	private List<Integer> Stack;
	private List<Integer> minPos;
	
	public void push(int input){
		Stack.add(input);
		if(isEmpty()){
			minPos.add(Stack.size()-1);
		}else{
			if(input < Stack.get(minPos.get(minPos.size()-1))){
				minPos.add(Stack.size()-1);
			}else{
				minPos.add(minPos.get(minPos.size())-1);
			}
			
		}
	}
	
	public void pop(){
		if(!isEmpty()){
			Stack.remove(Stack.size()-1);
			minPos.remove(minPos.size()-1);			
		}else{
			System.out.println("The stack is empty!");
		}
		
	}
	
	public boolean isEmpty(){
		return Stack.size()==0 ;
	}
	
}