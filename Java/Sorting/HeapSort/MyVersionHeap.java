class MyVersionHeap{

int PARENT(int i){
	if(i%2==0){
		return (i/2)-1;
	}
	else{
		return i/2;
	}

}

int LEFT(int i){
return 2*i+1;
}

int RIGHT(int i){
return 2*i+2;
}

/* 
	In HeapSort() , we put one element at its right place at every iteration. But, and MaxHeapify() process need not be done on that element anymore because it's been already sorted. so to we decrease the lenght of the array logically after every iteration of HeapSort().

*/

void MaxHeapify(int arr[],int index , int length){

/* in Max Heapify process , we assumes that the tree at left of index and
   the right of index are already a Max Heap. */	

   	// we can not apply Max Heapify process on leaf nodes.
	if(index >= length/2){
		return;
	}
	
	int temp=index;

	if( LEFT(index)<=(length-1) &&
		arr[temp]<arr[LEFT(index)]){
		temp=LEFT(index);
	}
	
	if( RIGHT(index)<=(length-1) && 
		arr[temp]<arr[RIGHT(index)]){
		temp=RIGHT(index);
	}

	if(temp!=index){
		int value=arr[index];
		arr[index]=arr[temp];;
		arr[temp]=value;
		MaxHeapify(arr,temp,length);
	}
} // end of MaxHeapify()

void MaxHeap(int arr[]){
	int length=arr.length;
	for(int i=(length/2)-1; i>=0;i--){
		MaxHeapify(arr,i,length);
	}

}

void HeapSort(int arr[]){
	MaxHeap(arr);	
	int length=arr.length;
	for(int i=length-1 ; i>=1 ; i--){
		int value=arr[i];
		arr[i]=arr[0];
		arr[0]=value;
		length--;
		MaxHeapify(arr,0,length);
	}

}

public  static void main(String args[]){

	int arr[]={16,14,10,8,7,9,3,2,4,1};
	MyVersionHeap mc=new MyVersionHeap();
	mc.HeapSort(arr);
	
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}


}
}
