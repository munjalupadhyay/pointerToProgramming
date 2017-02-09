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


void printInTreeWOStack(Node t){
	while(true){
		if(t==null && (st.empty()) ){
			break;
		}
		if(t==null && (!(st.empty())) ){
			t=st.pop();
		}

		if(t.left == null && t.right == null){
			System.out.println(" "+t.data);
			t.isVisited=true;
			t=st.pop();
			continue;
		}
		if(t.left != null && t.left.isVisited == false){
			t.left.isVisited=true ;
			st.push(t);
			t=t.left;
			continue;
		}

		if(t.left != null && t.left.isVisited == true){
			System.out.println(" "+t.data);
				st.push(t);
				t=t.right;
				continue;
			
		}

		if(t.right != null && t.right.isVisited == false){
			t.right.isVisited=true;
			st.push(t);
			t=t.right;
			continue;
		}

		if(t.right != null && t.right.isVisited == true){
			System.out.println(" "+t.data);
			t=st.pop();
		}		
		

	}

}


public static void main(String args[]){

Main m=new Main();

Node root=m.buildTree(0,m.pre.length-1);
System.out.println(root.data);
//m.printInTree(root);
m.printInTreeWOStack(root);

}
}
