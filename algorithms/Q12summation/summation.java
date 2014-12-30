package Q12summation;
//There must be more than one solution
public class summation{
	public static int summation(int n){
		int sum = 0;
		boolean flag = (n > 0)&&((sum = n + summation(n-1))>0);
		return sum;			
	}

	public static void main(String[] args) { 
		System.out.println(summation(10));
	}	
}
