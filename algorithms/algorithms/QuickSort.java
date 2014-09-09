package algorithms;



public class QuickSort{
	
	
	private static int[] theArray;// try to delete static
	
	private static int arraySize;
	
	QuickSort(int newArraySize){
		
		arraySize = newArraySize;
		
		theArray = new int[arraySize];
		
		getRandomArray();
	}
	
	
		public void quickSort(int p, int r){
			
		
		if(p<r){
			System.out.println("Left Pointer: " + theArray[p]+" Right Pointer: "+ theArray[r]);
			int q = partitionArray(p, r);
			printArray();
			quickSort(p, q - 1);
			quickSort(q+1, r);			
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
	
	
	private int partitionArray(int p, int r){
	
		int pivot = (int)(Math.random() * (r-p)+p);
		System.out.println("The pivot is number "+ pivot +" of the array: "+ theArray[pivot]);
		swapValues(pivot, r);
		printArray();
		
		int i = p - 1;
		for(int j = p; j < r; j++){
			if(theArray[j] <= theArray[r]){
				i++;
				swapValues(i, j);
				System.out.println(theArray[i]+" will be swapped with "+theArray[j]);
				printArray();
			}
			
		}
		swapValues(i+1, r);
		return i+1;
	}
	
	private void swapValues(int int1, int int2){
		int temp = 0; 
		temp = theArray[int1];
		theArray[int1] = theArray[int2];
		theArray[int2] = temp;
	}
	
	
	
	public void getRandomArray(){
		for (int i = 0; i < arraySize; i++){
			theArray[i] = (int)(Math.random() * 20) ;
		}
    }
	
	
	public static void main(String[] args){
		
		QuickSort theSort = new QuickSort(10);
		theSort.printArray();
		theSort.quickSort(0, arraySize-1);
		
		
	
	}
	
}