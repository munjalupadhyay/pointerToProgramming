// problem statement : http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
// let me know if any bug in code.

class Node{
int data;
Node left;
Node right;
Node(int data){
this.data=data;
this.left=null;
this.right=null;
}

}

class DeleteBSTOutOfGivenRange{


// This is just helper function I created to delete an entire tree rooted at given t.
void deleteTree(Node t){
	if(t==null){
		return;
	}

	deleteTree(t.left);
	deleteTree(t.right);
	t=null;//free(t);

}

// this is actual function
Node deleteBSTOutOfGivenRange(Node t,int min,int max){

	Node ret=null;
	if(t==null){
		return null;
	}
	// node is in range...
	if(t.data > min && t.data < max){
		t.left=deleteBSTOutOfGivenRange(t.left,min,max);
		t.right=deleteBSTOutOfGivenRange(t.right,min,max);
		//return t;
		ret=t;
	}
	else{// we have something to delete.

		// when t.data < min , it means entire left tree is of no use , because all the values in left to t are less than min only.
		if(t.data < min){
			deleteTree(t.left);
			Node temp=deleteBSTOutOfGivenRange(t.right,min,max); 
			// in C , write free(t);
			ret=temp;
		}
	
		//
		else{
			deleteTree(t.right);
			Node temp=deleteBSTOutOfGivenRange(t.left,min,max); 
			// in C , write free(t);
			ret=temp;
		}

	}

	return ret;

}

// creates just a tree.
Node createTree(){

	Node t=new Node(6);
	t.left=new Node(-13);
	t.right=new Node(14);
	
	t.left.right=new Node(-8);
	
	t.right.left=new Node(12);
	t.right.right=new Node(15);

	t.right.left.left=new Node(7);

	return t;
}


void printTree(Node t){

if(t==null){
	return;
}

printTree(t.left);
System.out.print(" "+t.data);
printTree(t.right);

}

public static void main(String args[]){

DeleteBSTOutOfGivenRange obj=new DeleteBSTOutOfGivenRange();

Node t=obj.createTree();

obj.printTree(t);
obj.deleteBSTOutOfGivenRange(t,-10,13);
System.out.println("\n");

obj.printTree(t);


}

}




