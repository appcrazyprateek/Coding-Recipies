package blog.bt.topview;

import blog.node.Node;

public class TopView {
	
	static int rMax=-1;
	static int lMax=1;
	public static void printTopView(int curr, Node root){
		if(root==null)
			return ;

		if(rMax < curr)
		{
			rMax =curr;
			System.out.println(root.data);
		}
			
		 if(lMax > curr)
		{
			lMax =curr;
			System.out.println(root.data);
		}
		
		printTopView( curr-1, root.left);
		printTopView( curr+1, root.right);
	}
	

	public static void main(String[] args) {
		
		 Node root = new Node(1) ;
	        root.left= new Node(2) ;
	        root.right= new Node(3) ;
	        /*root.left.left= new Node(4) ;
	        root.left.right= new Node(5) ;
	        root.right.left= new Node(6) ;
	        root.right.right= new Node(7) ;*/
	        root.left.right=new Node(4);
	        root.left.right.right=new Node(5);
	        root.left.right.right.right=new Node(6);
	        
	        TopView topview = new TopView();
	        topview.printTopView( 0, root);
	}
	
	
}
