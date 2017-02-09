import java.util.*;

class spoj{

void mergeSort(int arr[]){
	int length=arr.length;
	if(length<2){
		return;
	}
	
	int mid=length/2;
	int first[]=new int[mid];
	int second[]=new int[length-mid];	
	
	for(int i=0;i<first.length;i++){
		first[i]=arr[i];
	}
	for(int i=0;i<second.length;i++){
		second[i]=arr[mid+i];
	}	
/*
	for(int i=0;i<first.length;i++){
//		System.out.println(first[i]);
	}
	
	System.out.println();
	System.out.println();

	for(int i=0;i<second.length;i++){
		System.out.println(second[i]);
	}
*/
	mergeSort(first);
	mergeSort(second);
	merge(first,second,arr);

	
	

}


void merge(int first[],int second[],int result[]){
	int i=0,j=0,k=0;
	while(i<first.length && j<second.length){
		if(first[i]>second[j]){
			result[k]=second[j];
			k++;
			j++;
		}
		else{
			result[k]=first[i];
			i++;
			k++;
		}
	}

	while(i<first.length){
		result[k]=first[i];
		i++;
		k++;
	}
	while(j<second.length){
		result[k]=second[j];
		j++;
		k++;
	}
}


public static void main(String args[]){

	spoj sp=new spoj();
	int arr[]=new int[]{1,3,20,5,9,6,4,7};
	sp.mergeSort(arr);

	
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}

}
}
