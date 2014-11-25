package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Binarytree{
	Node root;
	Node head, tail;
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		
		if(root == null){
			root = newNode;
		}else{
			Node focusNode = root;
			Node parent;
			
			while(true){
				parent = focusNode;
				if(key <= focusNode.key){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
					
				}else {
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
		
	}
	public void changeNode(Node focusNode){
		
		if(focusNode != null){
			changeNode(focusNode.leftChild);
			if(head == null){
				head = focusNode;
				tail = focusNode;	
			}else{
				focusNode.leftChild = tail;
				tail.rightChild = focusNode;
				tail = focusNode;
				}
			changeNode(focusNode.rightChild);			
		}
	}
	public void readListHead(){
		while(head != null){
			System.out.println(head);
			head = head.rightChild;
		}
	}

	public void readListTail(){
		while(tail != null){
			System.out.println(tail);
			tail = tail.leftChild;
		}
	}
	public void preOrderTraversal(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
	}
	
	public void inOrderTraversal(Node focusNode){
		if(focusNode != null){
			inOrderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	public void postOrderTraversal(Node focusNode){
		if(focusNode != null){
			postOrderTraversal(focusNode.leftChild);			
			postOrderTraversal(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}	
	
	public void breathFirstTraversal(Node focusNode){
		Queue<Node> q = new LinkedList<Node>();
		q.add(focusNode);
		while(q.peek() != null){
			Node temp = q.remove();
			System.out.println(temp);
			if(temp.leftChild != null)
				q.add(temp.leftChild);
			if(temp.rightChild != null)
				q.add(temp.rightChild);
		}
		
		
	}
	
	public Node findNode(int key){
		Node focusNode = root;
		while(focusNode.key != key){
			if(key < focusNode.key)
				focusNode = focusNode.leftChild;			
			else{
				focusNode = focusNode.rightChild;		
			}
	
			if(focusNode == null){
				return null;
			}

		}
		return focusNode;
		
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
		newTree.breathFirstTraversal(newTree.root);
		System.out.println();
		newTree.preOrderTraversal(newTree.root);
		System.out.println();
		System.out.println(newTree.findNode(20));
		newTree.changeNode(newTree.root);
		System.out.println();
		System.out.println();
		newTree.readListHead();
		System.out.println();
		System.out.println();
		newTree.readListTail();

	}
	
	class Node{
		int key;
		String name;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name){
			this.key = key;
			this.name = name;
		}
		
		public String toString(){
			return name + " has a key " + key;
		}
	}
}