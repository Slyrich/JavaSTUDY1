package hired;

import java.util.Stack;

public class MyClass {
    public static void check_braces(String[] expressions) {
        for(int i = 0; i < expressions.length; i++){
            String in = expressions[i];
            Stack record = new Stack();
            char[] input = in.toCharArray();
            int result = 1;
            for(char c : input){
                switch(c){
                case '(':
                    record.push('(');
                    break;
                case '[':
                    record.push('[');
                    break;
                case '{':
                    record.push('{');
                    break;
                case ')':
                    if((char)record.peek() != '('){
                    	result = 0;
                    	break;
                    }
                    record.pop();
                    break;
                case ']':
                    if((char)record.peek() != '['){
                    	result = 0;
                    	break;
                    }
                    record.pop();
                    break;
                case '}':
                    if((char)record.peek() != '{'){
                    	result = 0;
                    	break;
                    }
                    record.pop();
                    break;
                }
            }
            if(!record.isEmpty()) result = 0;

            System.out.println(result);
        }// Write your code here
        // To print results to the standard output you can use System.out.println()
        // Example: System.out.println("Hello world!");
        
    }
	public static void main(String[] args){
	String[] expression = {"[[)]]","{[xy]}","([)]", "(([{}]))" };
	check_braces(expression);
	}
}