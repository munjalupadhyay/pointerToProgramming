/*

Note : In AVL tree , after inserting the node , if the unbalanced is created then we need to fix the height at the Ancestor of the tree , for once only . and after applying rotations on the  ancestors we need not check for the height again for the rest of the tree because the rotation process will take care that the height of the entire tree is balanced after applying perticular rotations... 

Well , in case of delete this is not the case...
In delete , aven after applying  the perticular rotations we need to check if the tree is balanced or not.

*/

/*

// having the problem in deleting node : changing the height of the node...
// you think that applying updateHeight() parent.parent will set the height in delete operation , but it won't.
// idea : apply updateHeight() on parent of  predesessor of the node you are gonna delete. (think about all the case and do.)
// Done : problem solved :-)

*/

// problem :: go to AVL class insert() method. you don't know how to figure out child and GC of Ancestor retuned by isHeightBalanced() metod !!!!


import java.util.*;

class Node{
int data;
int height;
Node left;
Node right;
Node parent;

Node(int data , Node left , Node right,Node parent){
this.data=data;
this.left=left;
this.right=right;
this.parent=parent;
this.height=0;
}

}

class BST{

Node root=null;

Node findMin(Node p){	
	
	if(p==null){
		System.out.println("node is null here , unable to find min");
		return null;
	}
	while(p.left != null){
		p=p.left;
	}
	return p;
}

Node findMax(Node p){	
	
	if(p==null){
		System.out.println("node is null here , unable to find max");
		return null;
	}
	while(p.right != null){
		p=p.right;
	}
	return p;
}

Node findSuccessor(Node p){			// O(h) time
	if(p.right!=null){
		return findMin(p.right);
	}
	else{
		Node y=p.parent;
		Node cur=p;
		while(y!=null && y.left!=cur){
			cur=y;
			y=y.parent;
		} 
		return y;
	}
}

void insert(int data){

	//System.out.println("inserting "+data);
	if(root==null){
		root=new Node(data,null,null,null);
		return;
	}
		
	Node temp=root;
	//Node parent=null;
	while(true){
		if(temp.data>data){
			if(temp.left==null){
				temp.left=new Node(data,null,null,temp);
				//System.out.println("before updating height of "+temp.data+" hight :"+temp.height);
				updateHeight(temp);
				//System.out.println("after updating height of "+temp.data+" hight :"+temp.height);	

				return;
			}
			else{
				temp=temp.left;
				//parent=temp;
			}
		}
		else{
			if(temp.right==null){
				temp.right=new Node(data,null,null,temp);
				//System.out.println("before updating height of "+temp.data+" hight :"+temp.height);
				updateHeight(temp);
				//System.out.println("after updating height of "+temp.data+" hight :"+temp.height);
				return;
			}
			else{
				temp=temp.right;
				//parent=temp;
			}
		}		
		
	}

}

int delete(Node ptr){		// give pointer to the node to be deleted
	//Node ptr=search(int data);

	// case 1 : ptr has no children
	if(ptr.left == null && ptr.right == null){
	
		//System.out.println( " in case 1 : deleting "+ptr.data );	

		if(ptr.parent.left == ptr){		// which side either left or right the ptr exists to to parent of ptr
			int data=ptr.parent.left.data;
			
			Node ptrParent=ptr.parent;
			//ptr.parent.height=ptr.parent.height - 1;  // update ptr's parent height
			//updateHeight(ptr.parent.parent);

			ptr.parent.left=null;
			ptr.parent=null;
			ptr=null;
			
			updateHeight(ptrParent);

			return data;
		}
		else{
			int data=ptr.parent.right.data;

			Node ptrParent=ptr.parent;
			//ptr.parent.height=ptr.parent.height - 1;  // update ptr's parent height
			//updateHeight(ptr.parent.parent);

			ptr.parent.right=null;
			ptr.parent=null;
			ptr=null;

			updateHeight(ptrParent);			

			return data;
		}
	}
 
	// case 3 : ptr has two children
	else if(ptr.left != null && ptr.right !=null){
		//System.out.println( " in case 3 : deleting "+ptr.data );	
		Node successorNode=findSuccessor(ptr);
		if (successorNode == null){
			System.out.println("successor of the node do not exists , so unable to delete");
		}		

		// swap contents of ptr and successor of ptr
		int tempD=successorNode.data;
		successorNode.data=ptr.data;
		ptr.data=tempD;

		//int tempH=successorNode.height;
		//successorNode.height=ptr.height;
		//ptr.height=tempH;

		// delete successor of ptr
		return delete(successorNode);
		
	
	}

 	// case 2 : ptr has one child 
	else if(ptr.left != null || ptr.right !=null){
		
		//System.out.println( " in case 2 : deleting "+ptr.data );	

		if(ptr.right !=null){				// which side of ptr the node exists ?

			if(ptr.parent == null){  		// attempting to delete root node
				int data=ptr.data;
				root=ptr.right;
				ptr=null;
				return data;
			}
			if (ptr.parent.left == ptr){			// which side ptr is to the parent of ptr ?
				Node ptrParent=ptr.parent;
				int data=ptr.parent.left.data;
				ptr.parent.left=ptr.right;
				ptr.right.parent=ptr.parent;

				//ptr.parent.height = ptr.parent.height -1;  // updating ptr's parent height
				//updateHeight(ptr.parent.parent);
				
				ptr.right=null;
				ptr=null;


				updateHeight(ptrParent);

				return data;
			}
			else{
				Node ptrParent=ptr.parent;
				int data=ptr.parent.right.data;
				ptr.parent.right=ptr.right;
				ptr.right.parent=ptr.parent;

				//ptr.parent.height = ptr.parent.height -1;  // updating ptr's parent height
				//updateHeight(ptr.parent.parent);
				
				ptr.right=null;
				ptr=null;
			
				updateHeight(ptrParent);

				return data;
			}
		}
		else{
			if(ptr.parent == null){ // attempting to delete root node
				int data=ptr.data;
				root=ptr.left;
				ptr=null;
				return data;
			}

			if (ptr.parent.left == ptr){
				Node ptrParent=ptr.parent;
				int data=ptr.parent.left.data;			
				ptr.parent.left=ptr.left;
				ptr.left.parent=ptr.parent;

				//ptr.parent.height = ptr.parent.height -1;  // updating ptr's parent height
				//updateHeight(ptr.parent);

				ptr.left=null;
				ptr=null;

				updateHeight(ptrParent);		

				return data;
			}
			else{
				Node ptrParent=ptr.parent;
				int data=ptr.parent.right.data;
				ptr.parent.right=ptr.left;
				ptr.left.parent=ptr.parent;

				ptr.parent.height = ptr.parent.height -1;  // updating ptr's parent height
				updateHeight(ptr.parent);

				ptr.left=null;
				ptr=null;
	
				updateHeight(ptrParent);

				return data;
			}

		}
	}
	return 0;
}

Node search(int data){
	if(root==null){
		return null;
	}
	
	Node ptr=root;
	while(ptr!=null){
		if(ptr.data==data){
			return ptr;
		}
		if (ptr.data > data){ // search in LST
			ptr=ptr.left;
		}
		else{
			ptr=ptr.right;
		}
	}
	
	return null;
}

void printInorder(){
	printIn(root);
	System.out.println();
}

void printIn(Node p){
	if(p!=null){

		printIn(p.left);
		System.out.print("-"+p.data+"("+p.height+")");
		printIn(p.right);

	}	
}

void updateHeight(Node ptr){
		

	while(ptr!=null){
		
		if(ptr.left != null && ptr.right != null){			

			//System.out.println("It's having two child");
			//System.out.println("inside,, updating height of :"+ptr.data);
										// node having two children
			if(ptr.left.height == ptr.right.height){		// no need to continue, 
				return;		
			}
			
			ptr.height=MAX(ptr.left.height + 1, ptr.right.height + 1);
			//updateHeight(ptr.parent);
			//return;

		}
	
		else if( ptr.left != null ||  ptr.right != null){				// node having one children
			//System.out.println("It's having one child");
			if(ptr.left != null){
				ptr.height=MAX(ptr.left.height,0)+1;
				//updateHeight(ptr.parent);
				//return;
			}	
			else{
				ptr.height=MAX(ptr.right.height,0)+1;
				//updateHeight(ptr.parent);
				//return;
			}
		}

		else if(ptr.left == null ||  ptr.left == null){			
			//System.out.println("It's having zero child");		
									//// it's leaf node, so no need to change height
			//updateHeight(ptr.parent);
			//return;
			
		}
	
		ptr=ptr.parent;
	}
	
}

int MAX(int a , int b){
	if(a>b){
		return a;
	}
	return b;	
}

}


class AVL{
	
Node root=null;
BST bst;
AVL(){
	bst=new BST();
	this.root=bst.root;
}

void insert(int data){
	bst.insert(data);
	// search for if the imbalance is created. if so call makeTreeBalanced.
	Node temp=bst.search(data);		// you can maintain a pointer to the newly inserted node in the BST class to save search here.
	Node isTreeBalanced=isHeightBalanced(temp);
	if(isTreeBalanced != null){
		makeTreeBalanced();
	}
}

int delete(int data){
	Node ptr=bst.search(data);
	int data1=bst.delete(ptr);
	// search for if the imbalance is created. if so call makeTreeBalanced.
	return data1;
}

Node search(int data){
	return bst.search(data);
}

void makeTreeBalanced(Node ancestor , Node ancestorChild , Node ancestorGChild){		// Ancestor means where the imbalance is created.
	if(ancestor.left == ancestorChild){	// ancestorChild is to the left of ancestor (L_ imbalance) 
		if(ancestorChild.left == ancestorGChild){	// (LL imbalance)
			LL_Imbalance(ancestor);
		}
		else{						// (LR imbalance)
			LR_Imbalance(ancestor);
		}
	}
	else{					// ancestorChild is to the right of ancestor (R_ imbalance)
		if(ancestorChild.left == ancestorGChild){	// (RL imbalance)
			RL_Imbalance(ancestor);
		}
		else{						// (RR imbalance)
			RR_Imbalance(ancestor);
		}
	}

}

void LL_Imbalance(Node ancestor){

}

void LR_Imbalance(Node ancestor){

}

void RR_Imbalance(Node ancestor){

}

void RL_Imbalance(Node ancestor){

}


// this function will check if their is any Ancestor exists or not in the tree. If the Ancestor exissts then return Ancestor or return null.

Node isHeightBalanced(Node ptr){
	while(ptr!=null){
		int Hl=ptr.left.height;
		int Hr=ptr.right.height;
		int diff=Hl-Hr;
		if( Hl != Hr){

			if(diff<-1){
				return ptr;
			}
			else if(diff>1){
				return ptr;
			}

		}

		ptr=ptr.parent;
	}	
	
	return null;
}

}

class Main{
public static void main(String args[]){
	
	BST bst=new BST();	

	int arr[]={9,3,5,7,1,4,6,8,2,10};
	for(int i=0;i<arr.length;i++){
		bst.insert(arr[i]);
	}

	bst.printInorder();

	//System.out.println(bst.root.left);
	System.out.println(bst.delete(bst.root.left));

	//System.out.println(bst.root);
	//System.out.println(bst.delete(bst.root));

	
	//System.out.println(bst.root);
	//System.out.println(bst.delete(bst.root));

	bst.printInorder();
	
	
}
}
