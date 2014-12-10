package Q5minKNos;

import java.util.Random;

public class Kmin{
	
	public static int[] Kmins(int[] inputArr, int k){
		//insert first k elements to the heap
		if(k <= 0){
			System.out.println("a non positive k is not allowed");
			return null;
		}
		
		int[] heap = new int[k];
		for(int i = 0; i<k; i++ ){
			heap[i] = inputArr[i];
		}
		//build max heap
		for(int i = heap.length / 2; i >= 0; i--){
			maxheapify(heap, i);
		}
		//insert the rest elements to the heap to get the k minimum elements
		for(int j = k; j<inputArr.length; j++){
			if(inputArr[j]<heap[0]){
				heap[0] = inputArr[j];
				maxheapify(heap, 0);
			}
		}
		return heap;
	}
	
	public static void maxheapify(int[] heap, int node){
		int largest = node;
		int leftChild = 2 * node + 1;
		int rightChild = 2 * node + 2;
		largest = leftChild < heap.length&&heap[leftChild] > heap[node] ? leftChild : node; 
		largest = rightChild < heap.length&&heap[rightChild] > heap[largest] ? rightChild : largest;
		if(largest != node){
			int temp = heap[node];
			heap[node] = heap[largest];
			heap[largest] = temp;
			maxheapify(heap, largest);
		}
	}
	

	
	public static int[] randomize(int[] input){
		Random random = new Random();
		for(int i =0; i < input.length; i++){
			int i2 = random.nextInt(input.length-1);
			int temp = input[i];
			input[i] = input[i2];
			input[i2] = temp;			
		}
		return input;
	}
	
	public static void main(String[] args){
		int[] input = {7, 6, 11, 13, 3, 5, 9, 17};
		for(int i : input){
			System.out.print(i+", ");			
		}
		System.out.println();
		
		int[] input2 = randomize(input);
		for(int i : input2){
			System.out.print(i+", ");			
		}

		int[] heap = Kmins(input2, 7);
		System.out.println();
		System.out.println("+++++++++++++++++++++++++华丽丽的分割线+++++++++++++++++++++++");
		for(int i : heap){
			System.out.print(i+", ");			
		}
	}

}