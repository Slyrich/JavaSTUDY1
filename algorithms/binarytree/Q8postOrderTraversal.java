package binarytree;

import java.util.ArrayList;

import binarytree.Binarytree;
import binarytree.Binarytree.Node;

public class Q8postOrderTraversal{
	
	public static ArrayList<Integer> newPostOrderTraversal(ArrayList<Integer> result, Node root){
	Node thisNode = root;
		if(thisNode != null){
			newPostOrderTraversal(result, thisNode.leftChild);
			newPostOrderTraversal(result, thisNode.rightChild);
			result.add(thisNode.key);
		}
		return result;
	}
	
	public static void compareResults(int[] input, ArrayList<Integer> result){
		if(input.length != result.size()){
			System.out.println("The input doesn't match the post order traversal result");
		return;
		}
		for(int i = 0; i < input.length; i++){
			if(input[i] != result.get(i)){
				System.out.println("The input doesn't match the post order traversal result");
			return;
			}
		}
		System.out.println("The input matches the post order traversal result");
	}
	
	public static void main(String[] args){
		Binarytree newTree = new Binarytree();
		newTree.addNode(30, "President");
		newTree.addNode(15, "Vice President");
		newTree.addNode(20, "the Secretary of State");
		newTree.addNode(40, "Chief Commander");
		newTree.addNode(50, "Army Commander");
		newTree.addNode(48, "Navy");
		newTree.addNode(54, "Airforce");
		
		int[] input = {20,15,48,54,50,40,30};
		int[] input2 = {20,15,48,54,50,40,31};
		int[] input3 = {20,15,48,54,50,40};
		ArrayList<Integer> result = new ArrayList<>();
		result = newPostOrderTraversal(result, newTree.root);
		compareResults(input, result);
		compareResults(input2, result);
		compareResults(input3, result);
	
		}
	}