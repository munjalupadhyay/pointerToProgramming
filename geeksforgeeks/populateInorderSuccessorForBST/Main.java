import java.util.*;

class Node{
String data;
Node left;
Node right;
Node next;
boolean isVisited;
Node(String data,Node left,Node right){
	this.data=data;
	this.left=left;
	this.right=right;
	this.isVisited=false;
	this.next=null;
}
}

class TempNode{
Node head;
Node tail;
TempNode(){
	this.head=null;
	this.tail=null;
}
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
		if(t.next != null){
			System.out.println(" "+t.data+ " next is "+t.next.data);
		}
		else{
			System.out.println(" "+t.data+ " next is null");
		}
		printInTree(t.right);
	}
}


TempNode populateInorderSucc(Node t,TempNode temp){
	System.out.println("doing it for "+t.data);
	if(t == null){
		return temp ;
	}

	if(t.left == null && t.right == null){
		temp.head=t;
		temp.tail=t;

	}	

	if(t.left != null){
		TempNode temp1=new TempNode();	
		populateInorderSucc(t.left,temp1);  // return tail
		temp.head=temp1.head; // update tail pointer of temp
		
		temp1.tail.next=t;
		temp.tail=t;
	
	}

	if(t.right != null){
		TempNode temp1=new TempNode();
		populateInorderSucc(t.right,temp1);  // return head
		temp.tail=temp1.tail;
		t.next=temp1.head;
		if(temp.head == null){
			temp.head=t;
		}
	
	}

	return temp;

}


void printpopulateInorderSucc(Node t){
	// go to left most..
	

}

public static void main(String args[]){

Main m=new Main();

Node root=m.buildTree(0,m.pre.length-1);
System.out.println(root.data);
m.printInTree(root);
TempNode temp=new TempNode();
m.populateInorderSucc(root,temp);
m.printInTree(root);


}
}
