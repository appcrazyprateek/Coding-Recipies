package com.test;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	public Node left;
	public Node right;
	public int data ;
	public Node mid;
	
	public Node(int data) {
		this.data= data;
	}
	
	@Override
	public String toString() {
		return data+"";
	}
}

public class Test {

	private static Node connectPeers(Node root) {

		if(root==null)
			return root;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty())
		{
			Node item = queue.poll();
			
			if(item==null)
			{
				if(queue.isEmpty())
					break;
				queue.offer(null);
				continue;
			}
				
			
			item.mid=queue.peek();
			if(item.left!=null)
				queue.offer(item.left);

			if(item.right!=null)
				queue.offer(item.right);
			
		}
		return root;
	}
	
	
	public static Node display(Node root)
	{
		if(root==null)
			return root;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		boolean flag = false;
		while(!queue.isEmpty())
		{
			Node item = queue.poll();
			
			if(item==null)
			{
				flag = true;
				continue;
			}
			
			if(item.left!=null)
				queue.offer(item.left);

			if(item.right!=null)
				queue.offer(item.right);
			
			if(!flag)
				continue;
			
			Node temp = item;
			while(temp!=null)
			{
				
				System.out.print(temp+"-->");
				temp =temp.mid;
			}
			System.out.println();
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10=new Node(10);

		root.left=n2;
		root.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		
		n4.left=n8;
		n5.right=n9;
		
		n7.right=n10;
		
		connectPeers(root);
	display(root);
		
	}
}
