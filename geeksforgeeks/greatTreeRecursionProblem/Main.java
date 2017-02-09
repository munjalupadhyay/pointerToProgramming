import java.util.*;

class Node{
String data;
Node left;
Node right;
boolean isVisited;
Node(String data,Node left,Node right){
	this.data=data;
	this.left=left;
	this.right=right;
	this.isVisited=false;
}
}


class LL{
Node head;
Node tail;
}

class Main{

Stack<Node> st = new Stack<Node>();
int pIndex=0;
String pre[]={"A","B","D","E","F","C","G","H"};
String in[]={"D","B","F","E","A","C","H","G"};

Node buildTree(int start , int end){
	if(start>end){
		return null;
	}
	
	Node t=new Node(pre[pIndex],null,null);

	pIndex++;
	int iIndex=search(t.data);

	if(start == end){
		t.left=null;
		t.right=null;
	}
	else{
		t.left=buildTree(start,iIndex-1);
		t.right=buildTree(iIndex+1,end);
	}
		
	return t;
}

int search(String str){
	for(int i=0;i<in.length;i++){
		if(in[i] == str){
			return i;
		}
	}
	return -1;
}

void printInTree(Node t){
	if(t!=null){
		printInTree(t.left);
		System.out.print(" "+t.data);
		printInTree(t.right);
	}
}


LL fun(Node root,LL linkedList){
	//System.out.println("doing for "+root.data);


	if(root == null){
		linkedList.head=null;
		linkedList.tail=null;
		return null;
	}
	
	if (root.left == null && root.right == null){
		linkedList.head=root;
		linkedList.tail=root;
		return linkedList;
	}	
	
	if(root.left != null){
		//System.out.println("checking left of "+root.data);
		LL linkedList1=new LL();
		linkedList1.head=null;	
		linkedList1.tail=null;

		
		fun(root.left,linkedList1);

		/*if(linkedList1.head != null){
			System.out.println("after returning form left of "+root.data +"the values of head1 is "+linkedList1.head.data);
		}
		else{
			System.out.println("after returning form right of "+root.data +"the values of head1 is NULL");
		}
		if(linkedList1.tail != null){
			System.out.println("after returning form left of "+root.data+ " the values of tail1 is "+linkedList1.tail.data);
		}
		else{
			System.out.println("after returning form right of "+root.data +"the values of tail1 is NULL");
		}

		printLL(linkedList1);
		*/

		root.left=linkedList1.tail;
		root.left.right=root;
		linkedList.head=linkedList1.head;
		//linkedList.head=linkedList1.head;
	}

	if(root.right != null){
		LL linkedList2=new LL();
		linkedList2.head=null;	
		linkedList2.tail=null;

		fun(root.right,linkedList2);

		/*if(linkedList2.head != null){
			System.out.println("after returning form right of "+root.data +"the values of head2 is "+linkedList2.head.data);
		}
		else{
			System.out.println("after returning form right of "+root.data +"the values of head2 is NULL");
		}
		if(linkedList2.tail != null){
			System.out.println("after returning form right of "+root.data+ " the values of tail2 is "+linkedList2.tail.data);
		}
		else{
			System.out.println("after returning form right of "+root.data +"the values of tail2 is NULL");
		}
		printLL(linkedList2);
		*/

		root.right=linkedList2.head;
		root.right.left=root;

		linkedList.tail=linkedList2.tail;
				
		
		//linkedList.tail=linkedList2.tail;

	}
	
	if(linkedList.head != null && linkedList.tail ==null){ //
 		linkedList.tail=root;
	}
	if(linkedList.head == null && linkedList.tail !=null){
		linkedList.head=root;
	}

	return linkedList;

}

void printLL(LL linkedList){
	Node head=linkedList.head;
	Node tail=linkedList.tail;

	while(head!=tail){
		System.out.print("-"+head.data);			
	
		head=head.right;	
	}
	
	if(head!=null){
		System.out.print("-"+head.data);
	}
	
}

public static void main(String args[]){

Main m=new Main();

Node root=m.buildTree(0,m.pre.length-1);
System.out.println(root.data);
//m.printInTree(root);
//m.printInTreeWOStack(root);

LL linkedList=new LL();
linkedList.head=null;
linkedList.tail=null;

LL t=m.fun(root,linkedList);
System.out.println();
System.out.println();
m.printLL(linkedList);
System.out.println();


}
}
