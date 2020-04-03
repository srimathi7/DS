//02-04-2020

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrderTraversal {

//Each node of tree has left and right pointers with value
	static class Node{
		int data;
		Node left,right;
		
		Node(int k)
		{
			data = k;
			left=right=null;
		}
	}
	
  //Create BinaryTree class with root node
	static class BinaryTree{
		Node root;
		BinaryTree(int k)
		{
			root = new Node(k);
			
		}
		BinaryTree()
		{
			root = null;
		}
	}
	
  //HeightOfBinaryTree
	static int height(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			int l = height(root.left);
			int r = height(root.right);
			
			if(l>r)
			{
				return(l+1);
			}
			else
			{
				return(r+1);
			}
		}
	}
	
  //PrintBinaryTree
	static void printList(Node bt) {
		
		if(bt==null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(bt);
		
		while(true) {
			int c = q.size();
			if(c==0)
			{
				break;
			}
			
			while(c>0) {
				Node node = q.peek();
				System.out.print(node.data);
				q.remove();
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
				c--;
			}
			System.out.println();
		}
		
	}
	
  //InOrderTraversalBinaryTree
	static List inOrder(Node root) {
		Stack<Node> st = new Stack();
		List al = new ArrayList();
		Node bt = root;
		while(bt!=null || !st.isEmpty())
		{
			while(bt!=null){
				st.add(bt);
				bt = bt.left;
			}
			bt = st.pop();
			al.add(bt.data);
			bt = bt.right;
		}
		return al;
	}
	
  //PreOrderTraversalBinaryTree
	static List preOrder(Node root) {
		Stack<Node> st = new Stack();
		List al = new ArrayList();
		st.add(root);
		while(!st.isEmpty())
		{
			Node current = st.pop();
			al.add(current.data);
			if(current.right!=null) {
			   st.add(current.right);
			}
			if(current.left!=null) {
				st.add(current.left);
		  }
		}
		return al;
	}
	
  //PostOrderTraversalBinaryTree
	static List postOrder(Node root) {
		Stack<Node> st = new Stack();
		List al = new ArrayList();
		Node curr = root;
		st.add(curr);
		while(curr!=null &&  !st.isEmpty())
		{
			curr = st.peek();
			if(curr.left==null && curr.right==null)
			{
				Node c = st.pop();
				al.add(c.data);
			}
			if(curr.right!=null)
			{
				st.add(curr.right);
				curr.right=null;
			}
			if(curr.left!=null)
			{
				st.add(curr.left);
				curr.left=null;
			}
			
		}
		return al;
	}
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.left.right = new Node(7);
		int h = height(bt.root);
		System.out.println(h);
		printList(bt.root);
		List op = inOrder(bt.root);
		System.out.println(op);
		List op2 = preOrder(bt.root);
		System.out.println(op2);
		List op3 = postOrder(bt.root);
		System.out.println(op3);
	}
}
