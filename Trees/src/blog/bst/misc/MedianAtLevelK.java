package blog.bst.misc;

import java.util.ArrayList;
import java.util.List;

import blog.node.Node;
/**
 * Find median at a given Level in a Binary Tree
 * @author Prateek
 */
public class MedianAtLevelK {

	/**
	 * Subroutine to calculate median
	 * @param level : Given level
	 * @return : median
	 */
	public Node medianAtLevelK(Node root, int level){
		List<Node> list = itemsAtLevelK(root,level,new ArrayList<Node>());
		Node median = list.get(list.size()/2);
		System.out.println("Available Nodes @ given Level : " + list);
		System.out.println("Median : " +median);
		return median;
	}

	/**
	 * Fills the list with items at given level
	 * @return list filled with nodes at the prescibed level
	 */
	public List<Node> itemsAtLevelK(Node root,int level, List<Node> list){
		if(root == null)
			return list;

		if(level == 1)
			list.add(root);

		list=itemsAtLevelK(root.left, level-1,list);
		list=itemsAtLevelK(root.right, level-1,list);

		return list;
	}

	public static void main(String[] args) {
		/*Node root = new Node(1) ;
		root.left= new Node(2) ;
		root.right= new Node(3) ;
		root.left.left= new Node(4) ;
		root.left.right= new Node(5) ;  	
		root.right.left= new Node(6) ;
		root.right.right= new Node(7) ;  
		root.left.right.left= new Node(8) ;  
		root.left.right.right= new Node(9) ;
		root.left.right.left.right= new Node(10) ;  */

		Node root = new Node(1) ;
		root.left= new Node(2) ;
		root.right= new Node(3) ;
		root.left.left= new Node(4) ;
		root.left.right= new Node(5) ;  	
		root.right.left= new Node(6) ;
		root.right.right= new Node(7) ; 


		root.left.left.right= new Node(8) ;  
		root.left.left.right.left= new Node(9) ;

		MedianAtLevelK obj= new MedianAtLevelK();
		obj.medianAtLevelK(root,3);
	}
}
