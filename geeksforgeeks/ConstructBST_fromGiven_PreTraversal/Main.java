class Node{
int data;
Node left;
Node right;
Node(int data){
	this.data=data;
}
}

class BST{

Node createTree(int arr[],int low,int high)
{

	if(low>high)
	{
		return null;
	}	
	else
	{
		Node t=new Node(arr[low]);
		int lastLow=low;
		lastLow=searchLow(arr,low,high);
		t.left=createTree(arr,low+1,lastLow);
		t.right=createTree(arr,lastLow+1,high);
		return t;
	}

}

int searchLow(int arr[],int low,int high)
{
	int target=arr[low];
	int preI=low;
	for(int i=low+1;i<=high;i++){
		if(arr[i]>target){
			return preI;
		}
		else{
			preI=i;
		}
	}
	return high;

}

void printIn(Node root){
	if(root==null){
		return;
	}
	printIn(root.left);
	System.out.print("-"+root.data);
	printIn(root.right);

}


}

class Main{
public static void main(String args[]){

	int arr[]={9,4,1,3,2,5,7,6,8,10};
	BST bst=new BST();
	Node root=bst.createTree(arr,0,arr.length-1);
	bst.printIn(root);
}

}
