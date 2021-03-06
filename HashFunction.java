package test;
import java.util.Arrays;

public class HashFunction {
	String[] theArray;
	int arraySize;
	int ItemsInArray=0;
	
	public static void main(String[] args){
		HashFunction Func1 = new HashFunction(60);
		String [] abc = {"5","4","22","6","24","56","44","15","0"};
		String [] abc2 = {"236","6666","1098","2","4677","65432","1001","817","18","82","71","99","109","152","111","100","8282","104","45"};
		Func1.hashFunction1(abc, Func1.theArray);
		Func1.displayTheStack();
        Func1.hashFunction2(abc2, Func1.theArray);
        Func1.displayTheStack();
        
        Func1.findKey("44");
        Func1.findKey("1");
        Func1.findKey("236");
        
		
		
	}

	public void hashFunction1(String[] stringForArray, String[] theArray){
		for(int i=0;i<stringForArray.length;i++){
			String newElement = stringForArray[i];
			theArray[Integer.parseInt(newElement)]= newElement;
		}
	}
	
	public void hashFunction2(String[] stringForArray, String[] theArray){
		for(int i=0;i<stringForArray.length;i++){
			String newElement = stringForArray[i];
			int num = Integer.parseInt(newElement) % arraySize;
			System.out.println("Modulus Index =" + num );
			while(!(theArray[num]=="-1")){
				num +=1;
				System.out.println(num-1 + " has a collsion, try " + num);
			}
			theArray[num] = newElement;
		}
	}
	
	public String findKey(String key){
		int index = Integer.parseInt(key)%arraySize;
		while((theArray[index]!="-1")){
			if(theArray[index]==key){
				System.out.println(key + " was found in" + index);
				return theArray[index];
			}
			index++;
			System.out.println("try another one: " + index);
			index %= arraySize;
			
			}
		return null;
	}
			
	
	
    HashFunction(int size){
	    arraySize = size;
	    theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }
    
    public void displayTheStack() {
   	 
        int increment = 0;
 
        for (int m = 0; m < 6; m++) {
 
            increment += 10;
 
            for (int n = 0; n < 71; n++)
                System.out.print("-");
 
            System.out.println();
 
            for (int n = increment - 10; n < increment; n++) {
 
                System.out.format("| %3s " + " ", n);
 
            }
 
            System.out.println("|");
 
            for (int n = 0; n < 71; n++)
                System.out.print("-");
 
            System.out.println();
 
            for (int n = increment - 10; n < increment; n++) {
 
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
 
                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));
 
            }
 
            System.out.println("|");
 
            for (int n = 0; n < 71; n++)
                System.out.print("-");
 
            System.out.println();
 
        }


}
}