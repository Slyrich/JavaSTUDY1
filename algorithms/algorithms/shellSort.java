package algorithms;

public class shellSort{
	private int[] theArray ;
	
	private int arraySize ;
	
	shellSort(int arraySize){
		
		this.arraySize = arraySize;
		
		theArray = new int[arraySize];
	}
	
	public void getRandomArray(){
		for (int i = 0; i < arraySize; i++){
			theArray[i] = (int)(Math.random() * 20) ;
		}
		
	}
	
	public void printArray(){
		System.out.println("====================");
		for(int i = 0; i < arraySize; i++){
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
		System.out.println("====================");		
	}
	
	public void shellsort(){
		
		int interval = Math.round(arraySize/2);
		
		while(interval > 0){
			for (int i = interval; i < arraySize; i++){

				int j = i;
				int temp = theArray[j];

				while(j >= interval && temp < theArray[j - interval]){
					
					theArray[j] = theArray[j - interval];
					j = j -interval;
					
				}
				theArray[j] = temp;
			}
			
			interval = Math.round(interval/2);
		}
	}
	
	public static void main(String[] args){
		
		shellSort SS = new shellSort(10);
		
		SS.getRandomArray();
		
		SS.printArray();
		
		SS.shellsort();
		
		SS.printArray();
		
	}
	
}
	
