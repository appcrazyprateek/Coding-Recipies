package blog.bt.bttodll;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Node Structre
 * @author Prateek
 */
class Node {
	Node left;
	int data;
	Node right ;
	
	public Node(int val){
		this.data=val;
	}
	
	public String toString(){
		return this.data + "";
	}
}

/**
 * Binary Tree to DLL conversion
 * @author Prateek
 */
public class BinaryToDLink {

	/**
	 * Binary Tree to DLL (using QUeue)
	 * @param root
	 */
	public void changeToDLL(Node root){
            
              if(root==null)
            	  return;
              
              Queue<Node> queue= new LinkedList<Node>();
              
              queue.offer(root);  //push 1st element
              
              Node parent =null;
              Node child =null;
              
              while(!queue.isEmpty()){
            	  
            	  Node popedItem = queue.poll();
            	  child = popedItem;
            	  
            	if(child.left!=null)
            	 queue.offer(child.left) ;
            	if(child.right!=null) 
            	queue.offer(child.right) ;
            	 
            	 child.right = queue.peek();
            	
            	 child.left = parent;
            	 parent = child;
              }
              
              printList(parent) ;
	}
	
	public void printList(Node last){
		Node temp=last;
		while(temp!=null){
			System.out.print("  <---" +temp.data);
			temp=temp.left;
		}
	}

	public static void main(String[] args) {
        Node root = new Node(1) ;
        root.left= new Node(2) ;
        root.right= new Node(3) ;
        root.left.left= new Node(4) ;
        root.left.right= new Node(5) ;

     BinaryToDLink obj=  new BinaryToDLink();
     obj.changeToDLL(root);
	}
	
	
}
