import java.util.*;

class Main{

int partition(int arr[],int start,int end){
	int pivot=arr[end];
	int pIndex=start;
	for(int i=start ; i<=end-1;i++){
		if(arr[i]<=pivot){
			int temp=arr[i];
			arr[i]=arr[pIndex];
			arr[pIndex]=temp;
			pIndex+=1;
		}
	}

	int temp=arr[pIndex];
	arr[pIndex]=arr[end];
	arr[end]=temp;
	
	return pIndex;

}

void quickSort(int arr[],int start,int end){
	//System.out.println("");
	if(start<end){
		//int mid=end/2;
		int pIndex=partition(arr,start,end);
		
			quickSort(arr,start,pIndex-1);
		
		
			quickSort(arr,pIndex+1,end);	
		
	}
}

public static void main(String args[]){
	int arr[]=new int[]{3,4,7,1,8,10,2};
	Main m=new Main();
	m.quickSort(arr,0,(arr.length)-1);

	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}	

}
}
