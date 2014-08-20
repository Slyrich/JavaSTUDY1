package algorithms;
public class ArrayStructures{
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void getRandomArray(){
		for(int i = 0; i < arraySize; i++){
			theArray[i] = (int)(Math.random() * 10);
		}		
	}
	
	public void printArray(){
		System.out.println("==========");
		for(int i = 0; i < arraySize; i++){
			System.out.print(theArray[i]);
		}
		System.out.println();
		System.out.println("==========");		
	}
	
	public int getValueAtIndex(int index){
		if(index < arraySize){
			return theArray[index];
		}
		return 0;
		
		
	}
	
	public boolean searchValue(int value){
		
		for(int i = 0; i < arraySize; i++){
			if(theArray[i] == value){
				return true;
			}
		}
		return false;
	}
	
	public void delete(int index){
		for (int i = index; i < arraySize - 1; i++){
			theArray[i] = theArray[i + 1];
		}
	    arraySize--;
	}
	
	public void insert(int index, int value){
		arraySize++;
		for (int i = arraySize; i > index; i-- ){
		theArray[i] = theArray[i - 1];	
		}
		theArray[index] = value;
	}
	
	public String linearSearch(int value){
		boolean result = false;
		String indexWithValue = "";
		
		for(int i = 0; i < arraySize; i++){
			if(value == theArray[i]){
				result = true;
				indexWithValue += i + " ";
			}
		}
		
		if(result){
			System.out.println("The value " + value + " was found in: " + indexWithValue);
			return indexWithValue;
		}
		System.out.println("The value " + value + " was not found");
		return indexWithValue;
	}
	
	public void binarySearch(int value){
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex){
			int middleIndex = (highIndex + lowIndex) / 2;
			lowIndex = theArray[middleIndex] <= value ? middleIndex : lowIndex;
			highIndex = theArray[middleIndex] >= value ? middleIndex : highIndex;
			if(lowIndex == highIndex){
				System.out.println("\nFound a match for " + value + " at index: " + middleIndex);
			    lowIndex = highIndex + 1;
			
			}
			else if(theArray[lowIndex] == value){
				System.out.println("\nFound a match for " + value + " at index: " + lowIndex);
			    lowIndex = arraySize + 1;
				
			}
			else if(theArray[highIndex] == value){
				System.out.println("\nFound a match for " + value + " at index: " + highIndex);
			    lowIndex = arraySize + 1;
				
			}
			else if(lowIndex == highIndex - 1){
				System.out.println(value + " is not found in the array");
				lowIndex = highIndex + 2;
			}

		}
	}
	
	public void bubbleSort(){
		for(int i = arraySize - 1; i>1; i--){
			for (int j = 0; j < i; j++){
				if(theArray[j] > theArray[j+1]){
					swap(j, j + 1);
				}
			}
		}
	}
	
	public void selectionSort(){
		for (int x = 0; x < arraySize; x++){
			int min = x;
			for (int y = x; y < arraySize; y++){
				if(theArray[y] < theArray[min]){
					min = y;
				}
			}
		swap(x, min);
		printArray();
		}
		
	}
	
	public void insertionSort(){
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];
			while(j > 0 && theArray[j - 1] > toInsert){
				theArray[j] = theArray[j - 1];
				j--;
			}
			theArray[j] = toInsert;
			
		}
	}
	
	public void swap(int value1, int value2){
		int temp = theArray[value1];
		theArray[value1] = theArray[value2];
		theArray[value2] = temp;
	}
	
	public static void main(String[] args){
		
		ArrayStructures A1 = new ArrayStructures();
		A1.getRandomArray();
		A1.printArray();
		System.out.println(A1.getValueAtIndex(4));
		System.out.println(A1.searchValue(8));
		A1.delete(1);
		A1.printArray();
		A1.insert(6,-5);
		A1.printArray();
		A1.linearSearch(0);
		A1.linearSearch(81);
		//A1.bubbleSort();
		//A1.selectionSort();
		A1.insertionSort();
		A1.printArray();
		//A1.binarySearch(-5);
		
	}
	
	
}