package Q3subarray;

public class subarray{

	public static int returnValue(int[] input){
		int b = 0, sum = 0;
		for (int i : input){
			b = b<=0 ? i : b + i;
			sum = sum > b ? sum : b;			
		}
		return sum;
	}
	
	public static void main(String[] args){
		int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(returnValue(input));
	}
	
}