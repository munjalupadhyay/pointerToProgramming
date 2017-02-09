// Remenber in heap sort there is no tree exists , it is out assumptions that tree is their.
// and all the operation is made on array only.
// heapSize argument is added to the function because , in Sorting process , we need to decrement the size of array by one in every iteration ,
// and the n we need to apply MaxHeapify process on that reduced size array.

class HeapSort{


int parent(int i){
	if(i%2==0){
		return (i/2)-1;
	}

	
	return (i/2);
}

int left(int i){
	return (2*i)+1;
}

int right(int i){
	return (2*i)+2;
}

void MaxHeapify(int arr[],int index,int heapSize){
	int l=left(index);
	int r=right(index);

	int max;
	
	if(l<heapSize && arr[l]>arr[index] ){
		max=l;
	}
	else{
		max=index;
	}

	if(r<heapSize && arr[r]>arr[max] ){
		max=r;
	}
	
	if(max!=index){
		int temp=arr[max];
		arr[max]=arr[index];
		arr[index]=temp;
		MaxHeapify(arr,max,heapSize);

	}

}


void buildMaxHeap(int arr[]){
	for(int i=((arr.length/2)-1);i>=0;i--){
			MaxHeapify(arr,i,arr.length);
	}
}

void sort(int arr[]){
	buildMaxHeap(arr);
	int length=arr.length-1;
	for(int i=length;i>0;i--){
		int temp=arr[i];
		arr[i]=arr[0];
		arr[0]=temp;
		length--;
		MaxHeapify(arr,0,length);
	}
	
	
}

public static void main(String args[]){

	int arr[]=new int[]{4,1,3,2,16,9,10,14,8,7};
	HeapSort sp=new HeapSort();	
	sp.sort(arr);

	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}
	
	
	
}
}
