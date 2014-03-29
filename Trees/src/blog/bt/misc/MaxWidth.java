package blog.bt.misc;

import blog.node.Node;

public class MaxWidth {

	public void maxWith(Node root) {

		int level=2;
		int curLevel=1;
		int maxLevel=0;

		while(curLevel > 0)
		{
			curLevel = width(root, level++);
			max(curLevel, maxLevel) ;
		}


	}

	private int max(int curLevel, int maxLevel) {
		return curLevel > maxLevel ? curLevel : maxLevel ;
	}

	private int width(Node root , int level ) {

		if(root == null)
			return 0;

		if(level==1)
			return 1;

		return width(root.left , level-1) + width(root.right , level-1) ; 
	}
}
