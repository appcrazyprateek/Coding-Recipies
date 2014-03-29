package blog.bt.misc;

import blog.node.Node;

public class LeafNodes {

	/**
	 * Check if Binary tree has all nodes at the same level
	 * @param root: root node
	 * @param previousLevel : level of 1st leaf encoutered , initial value = 0 passed
	 * @param currentLevel : level of any current node , initial value = 0 passed
	 * @return true , iff all nodes are at same level
	 */
	public boolean isLevelSame(Node root , int previousLevel , int currentLevel ) {

		if(root==null)
			return true;

		if(root.left == null && root.right == null) {
			// First Leaf Encoutered , saved the level of 1st leaf 
			if(previousLevel == 0) {
				previousLevel = currentLevel ;
				return true ;
			}
			// all Subsequent leaves should be equal to the first leaf encoutered
			return (previousLevel == currentLevel) ;
		}

		// checking for left and right sub tree of every node
		return  isLevelSame(root.left , previousLevel  , currentLevel + 1) && 
				   isLevelSame(root.right , previousLevel  , currentLevel + 1) ;
	}

}
