package blog.bt.misc;

import blog.node.Node;

public class TestMirrorTrees {

	//Write a program that finds whether the two binary trees are mirror image of each other?
	boolean tree_compare(Node t1, Node t2){
		if(t1==null && t2 == null) return true;
		if(t1 ==null || t2 == null) return false;
		return (t1.data == t2.data) && tree_compare(t1.left, t2.right) && tree_compare(t1.right, t2.left);
	}

}