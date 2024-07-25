import java.util.*;
public class simple{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinarySearchTree bst = new BinarySearchTree();
    String ch="";
    do{
	    System.out.println("Enter the element to be inserted in the tree");
        int n=sc.nextInt();
        sc.nextLine();
        //Fill your code here
        bst.insert(n);
        System.out.println("Do you want to insert another element?");
        ch = sc.nextLine();
     }while(ch.equals("yes"));
     bst.display();
     bst.count();

     //Fill your code here
}
}  


 class BinarySearchTree{
	Node root;

	class Node{
		int data;
			Node left;
	Node right;
		Node(int data)
		{
			this.data=data;
		}

	}

 	/* create Node class, it containing left and right child of current node and key value */

	public void insert(int data)
	{
	/* Fill your code here */
	root=insertRec(root,data);
	}

	public Node insertRec(Node root,int data)
	{
	/* Fill your code here */
	if(root==null)
	{
		return root=new Node(data);
	}
	if(root.data>data)
	{
		 root.left=insertRec(root.left,data);
	}
	else
	{
		root.right=insertRec(root.right,data);
	}
	return root;

	}

	public void display()
	{
	 display(root);
	}

	public void display(Node root)
	{
	 /* Fill your code here */
	 if(root!=null)
	 {
		 display(root.left);
		 System.out.print(root.data+" ");
		 display(root.right);
	 }

	}

	public int count()
    	{

        /* Fill your code here */
	return  count(root);

    	}

    	public int count(Node root)
    	{
        /* Fill your code here */
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		return count(root.left)+count(root.right);



    	}

}




