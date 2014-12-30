package Q11maxDistance;

import java.util.Stack;

class Node{
	int maxLeft = 0;
	int maxRight = 0;
	Node left = null;
	Node right = null;
	boolean visited = false;
}

public class maxDistance{
	int maxDistance = 0;
	public void recursiveMaxDistance(Node root){
		if(root == null){
			return;
		}
		if(root.left != null){
			recursiveMaxDistance(root.left);
			root.maxLeft = Math.max(root.left.maxLeft, root.left.maxRight) + 1;
		}
		if(root.right != null){
			recursiveMaxDistance(root.right);
			root.maxRight = Math.max(root.right.maxLeft, root.right.maxRight) + 1;
		}
		if(root.maxLeft + root.maxRight > maxDistance)
			maxDistance = root.maxLeft + root.maxRight;
		}
	
	
	public static Stack<Node> stack = new Stack<Node>();
	public int nonRecursiveMaxDistance(Node root){
		if(root == null){
			return 0;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			Node cur = stack.pop();
			if(cur.left != null){
				if(cur.left.visited){
					cur.maxLeft = Math.max(cur.left.maxLeft, cur.left.maxRight)+1;
				}else{
					stack.push(cur.left);
					continue;
				}
			}
			if(cur.right != null){
				if(cur.right.visited){
					cur.maxRight = Math.max(cur.right.maxLeft, cur.right.maxRight)+1;
				}else{
					stack.push(cur.right);
					continue;
				}
			}
			if(cur.maxLeft + cur.maxRight > maxDistance){
				maxDistance = cur.maxLeft + cur.maxRight;
			}
			cur.visited = true;
			
		}
		return maxDistance;
		
	}
	
	
}