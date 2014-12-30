package ArraysNStrings;

public class replaceSpaces{
	public static String replacespaces(String Input){
		StringBuffer Output = new StringBuffer();
		for(int i = 0; i < Input.length(); i++){
			if(Input.charAt(i) != ' '){
				Output.append(Input.charAt(i));
			}else{
				Output.append("%20");
			}
		}
		String Output1 = Output.toString();
		return Output1;
	}
	
	public static void main(String[] args){
		String input = "I want to be signaficant";
		System.out.println(replacespaces(input));
	}

}