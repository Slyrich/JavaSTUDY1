package hastable;
import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction2 {
	String[] theArray;
	int arraySize;
	int ItemsInArray=0;
	
	public static void main(String[] args){
		HashFunction2 Func1 = new HashFunction2(60);
		String [] abc = {"5","4","22","6","24","56","44","15","0"};
		String [] abc2 = {"236","6666","1098","2","4677","65432","1001","817","18","82","71","99","109","152","111","100","8282","104","45"};
		String [] abc3 = {"1","10","30","28","26","333","971","31","14","15","39","240","250","8411"};
		Func1.hashFunction1(abc, Func1.theArray);
		Func1.displayTheStack();
        Func1.hashFunction2(abc2, Func1.theArray);
        Func1.displayTheStack();
        //Func1.increaseArraySize(70);
        //Func1.displayTheStack();
        Func1.hashFunction3(abc3, Func1.theArray);
        Func1.displayTheStack();

        Func1.findKey("44");
        Func1.findKey("1");
        Func1.findKey("82");
        Func1.findKey("240");
        Func1.findKey2("240");
        

        System.out.println(Func1.theArray.length);
		
		
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
			System.out.println("Modulus Index of " + newElement + " = " + num );
			while(!(theArray[num]=="-1")){
				num +=1;
				System.out.println(num-1 + " has a collsion, try " + num);
			}
			theArray[num] = newElement;
		}
	}

	public void hashFunction3(String[] stringForArray, String[] theArray){
		for(int i=0;i<stringForArray.length;i++){
			String newElement = stringForArray[i];
			int num = Integer.parseInt(newElement) % arraySize;
			System.out.println("Modulus Index of " + newElement + " = " + num );
			while(!(theArray[num]=="-1")){
				int num1 = num;
				num = num + (7 - Integer.parseInt(newElement) % 7);
				System.out.println(num1 + " has a collsion, try " + num);
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

	public String findKey2(String key){
		int index = Integer.parseInt(key)%arraySize;
		while((theArray[index]!="-1")){
			if(theArray[index]==key){
				System.out.println(key + " was found in" + index);
				return theArray[index];
			}
			index = index + (7 - Integer.parseInt(key) % 7);
			System.out.println("try another one: " + index);
			
			}
		return null;
	}
	
	public boolean isPrime(int number)
	{
		if(number % 2 ==0)
			return false;
		for(int i=3; i*i<=number; i+=2){
			if(number % i == 0)
			return false;
			
		}
		return true;
	}
			
	public int getNextPrime(int numberChecked){
		for(int i=numberChecked; true; i++)
			if(isPrime(i))
				return i;
	}
	
	public void increaseArraySize(int arraySize1)
	{
		int newArraySize = getNextPrime(arraySize1);
		moveOldArray(newArraySize);
	    
	}
	
	public void moveOldArray(int newArraySize){
		String[] cleanArray = removeEmptySpacesInArray(theArray);
		theArray = new String[newArraySize];
		arraySize = newArraySize;
		Arrays.fill(theArray, "-1");
        hashFunction2(cleanArray,theArray);		
	}
	
	public String[] removeEmptySpacesInArray(String[] arrayToClean){
		ArrayList<String> stringList = new ArrayList<String>();
		for (String theString : arrayToClean){
			if(!theString.equals("-1")&&!theString.equals(""))
				stringList.add(theString);
		}
	   
		return stringList.toArray(new String[stringList.size()]);
		}
		
	
    HashFunction2(int size){
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