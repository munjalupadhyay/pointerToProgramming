class Node{
Node lLink;
int data;
Node rLink;

Node(){
lLink=null;
data=0;
rLink=null;
}
Node(int data){
	this.data=data;
	lLink=null;
	rLink=null;

}
}

class BST{

	Node root=null;
	void add(int data){
		if(root==null){
			root=new Node(data);
		}
		else{
			Node p=root;
			while(true){
				if(data<p.data){
					if(p.lLink==null){
						p.lLink=new Node(data);
						break;
					}
					p=p.lLink;
				}
				else{
					if(p.rLink==null){
						p.rLink=new Node(data);
						break;
					}
					p=p.rLink;
				}

			}
		}
	}


void inPrint(Node root){
	if(root.lLink!=null){
		inPrint(root.lLink);
	}
	System.out.print(root.data+" ");
	if(root.rLink!=null){	
		inPrint(root.rLink);
	}
}

void prePrint(Node root){

	System.out.print(root.data+" ");

	if(root.lLink!=null){
		prePrint(root.lLink);
	}

	if(root.rLink!=null){	
		prePrint(root.rLink);
	}
}

void postPrint(Node root){

	if(root.lLink!=null){
		inPrint(root.lLink);
	}

	if(root.rLink!=null){	
		inPrint(root.rLink);
	}

	System.out.println(root.data+" ");
}

int sizee(Node root){
	if(root!=null){
		return 1+sizee(root.lLink)+sizee(root.rLink);
	}
	return 0;
}

boolean compare(Node p1,Node p2){		// return 0 means same tree structure.
	if(p1==null && p2==null){
		return true;
	}
	else if(p1!=null && p2!=null){
		
		return  ((p1.data==p2.data) && compare(p1.lLink,p2.lLink) && compare(p1.rLink,p2.rLink));
		
		
	}
	else{
		return false;
	}		

}


// Write an Efficient C Function to Convert a Binary Tree into its Mirror Tree
void makeMirror(Node p){	
	if(p!=null){
		Node temp=p.lLink;
		p.lLink=p.rLink;
		p.rLink=temp;
		makeMirror(p.rLink);
		makeMirror(p.lLink);
	}
}


// Program to count leaf nodes in a binary tree
int leafCount(Node p){
	if(p==null){
		return 0;
	}
	else{
		if(p.lLink==null && p.rLink==null){
			return 1;
		}
		else{
			return leafCount(p.lLink)+leafCount(p.rLink);
		}
	}
}


int size(){
	return sizee(root);
}

void printTree(){
	//inPrint(root);
	prePrint(root);
	//postPrint(root);
}

}

class Main{
	public static void main(String args[]){
		BST bt=new BST();
		bt.add(7);
		bt.add(3);
		bt.add(15);
		bt.add(18);
		bt.add(16);		
		bt.add(50);
		bt.add(6);	
		bt.add(5);
		bt.printTree();
		System.out.println("size is"+bt.size());
	
		bt.makeMirror(bt.root);	
		bt.printTree();
		System.out.println();		
		System.out.println(bt.leafCount(bt.root));

	}
}


