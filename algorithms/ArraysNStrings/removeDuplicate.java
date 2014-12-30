package ArraysNStrings;
	
public class removeDuplicate{
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		if (str.length < 2) return;

		for (int i = 1; i < str.length; i++) {
			for (int j = 0; j < i; j++) {
				if (str[i] == str[j])	str[i] = 0;
			}
		}

	}
	
	public static void main(String[] args){
		char[] input1 = {'a','a','b','c','d','d','e'};
		char[] input2 = {'a','b','c','d','e'};
		removeDuplicates(input1);
		removeDuplicates(input2);
		System.out.println(input1);
		System.out.println(input2);
	}
}