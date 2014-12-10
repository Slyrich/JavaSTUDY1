package Q10reverseString;

import java.util.StringTokenizer;

public class reverseString{
	public static void main(String[] args){
		String input = "Guo guo shi ge da bai chi";
		String output = "";
		StringTokenizer tokenizer = new StringTokenizer(input);
		
		while(tokenizer.hasMoreTokens()){
			output = tokenizer.nextToken() + " " + output;
		}
		System.out.println("The input was: " + input);
		System.out.println("The output was: " + output);
	}
	
	
}