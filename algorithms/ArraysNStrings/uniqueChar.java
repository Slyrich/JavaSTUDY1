package ArraysNStrings;

public class uniqueChar{
	public static boolean uniqueTest(String input){
		for(int i = 0; i < input.length(); i++){
			for(int j = 0; j < input.length(); j++){
				if(input.charAt(i) == input.charAt(j)&&i!=j) return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args){
		
		String input1 = "alcohol";
		String input2 = "waze";
		
		if(uniqueTest(input1)){
			System.out.println("for string: " + input1 + ", it is unique");
		}else{
			System.out.println("for string: " + input1 + ", it is not unique");
		}
		
		if(uniqueTest(input2)){
			System.out.println("for string: " + input2 + ", it is unique");
		}else{
			System.out.println("for string: " + input2 + ", it is not unique");
		}
	}

}