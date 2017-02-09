import java.util.*;
class swapProblem{

void swap(Node arr[],int ind1,int ind2){
	Node temp;	
	temp=arr[ind1];
	arr[ind1]=arr[ind2];
	arr[ind2]=temp;
}

void print(Node arr[]){
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i].str);
	}
	System.out.println();
}

public static void main(String args[]){

Node arr[]=new Node[5];
Scanner sc=new Scanner(System.in);

for(int i=0;i<arr.length;i++){
	arr[i]=new Node();
	arr[i].str=sc.next();
}

swapProblem sp=new swapProblem();
sp.print(arr);
sp.swap(arr,0 , 3);
sp.print(arr);


}
}

class Node{
String str;
}
