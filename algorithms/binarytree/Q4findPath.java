package binarytree;

import java.util.ArrayList;
import binarytree.Binarytree;

public class Q4findPath{
	
	public static void main(String[] args){
		Binarytree newTree = new Binarytree();
		newTree.addNode(30, "President");
		newTree.addNode(15, "Vice President");
		newTree.addNode(20, "the Secretary of State");
		newTree.addNode(40, "Chief Commander");
		newTree.addNode(50, "Army Commander");
		newTree.addNode(48, "Navy");
		newTree.addNode(54, "Airforce");
		ArrayList<Integer> path = new ArrayList<Integer>() ;
		
		findPath(newTree.root, 168, path);
	}
		
		
	
public static void findPath(binarytree.Binarytree.Node root2, int SumResidual, ArrayList<Integer> path){
	
	path.add(root2.key);
	SumResidual -= root2.key;
	
	if((root2.leftChild == null)&&(root2.rightChild == null)){
		if(SumResidual == 0){
			System.out.print("[");
			for(int i : path){
				System.out.print(i+", ");
			}
			System.out.print("]");
		}
	}else{
		if(root2.leftChild != null){
			findPath(root2.leftChild, SumResidual, path);
		}
		if(root2.rightChild != null){
			findPath(root2.rightChild, SumResidual, path);
		}
	}
	path.remove(path.size()-1);
	}

}

