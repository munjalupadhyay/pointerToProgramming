import java.util.*;

class Heap{    // Remember : in Heap we store the edges not vertices.

Vertex arr[];
int heapSize=0;

Heap(int vertexCount){
	arr=new Vertex[vertexCount];

}

int parent(int i){
	if(i==0){
		return -1;
	}
	if(i%2==0){
		if(i/2==0){
			return 0;
		}
		return (i/2)-1;
	}
	else{
		return i/2;
	}
}
int left(int i){
	return (2*i)+1;
}
int right(int i){
	return (2*i)+2;
}

boolean isEmpty(){
	if(heapSize==0){
		return true;
	}
	return false;
}


void insertVertex(Vertex v){
	arr[heapSize]=v;
	v.heapIndex=heapSize;
	heapSize++;
	heapify(heapSize-1);
}

Vertex deleteMin(){
	Vertex temp=arr[0];
	//System.out.println("element at arr[0] is "+arr[0].name+" before deletion");
	swap(0,heapSize-1);	
	heapSize--;
	heapify(0);
	temp.heapIndex=-1;
	//System.out.println("element at arr[0] is "+arr[0].name+" after deletion");
	return temp;
}

void decreaseP(Vertex v,int pri){
	int index=v.heapIndex;
	v.label=pri;
	//heapify(index);

	while(index>0 && (arr[parent(index)].compareTo(arr[index])>0) ){
		swap(index,parent(index));
		index=parent(index);
	}	
	
}

void heapify(int index){
	//System.out.println("heapifying on index "+index);
	//System.out.println("before heapify");
	printHeap();
	int minIndex=index;
	int lIndex=left(index);
	int rIndex=right(index);
	if(lIndex < heapSize){
		if(arr[lIndex].compareTo(arr[index]) < 0){
			minIndex=left(index);
		}
	}
	if(rIndex < heapSize){
		if(arr[rIndex].compareTo(arr[minIndex]) < 0){
			minIndex=right(index);
		}		
	}
	
	if(minIndex != index){
		swap(index,minIndex);
		//System.out.println("after heapify");
		printHeap();
		heapify(minIndex);
	}
	
	

}

void swap(int ind1,int ind2){
	Vertex temp=arr[ind1];
	arr[ind1]=arr[ind2];
	arr[ind2]=temp;
	arr[ind1].heapIndex=ind1;
	arr[ind2].heapIndex=ind2;
}

void printHeap(){
	/*for(int i=0;i<heapSize;i++){
		System.out.print(" Name: "+arr[i].name+" label: "+arr[i].label+" index= "+arr[i].heapIndex);
	}	
	System.out.println("\n");*/
}

}

class Vertex implements Comparable<Vertex>{
	String name;
	boolean isInSetS;
	int label;
	Edge adjList;
	int heapIndex;
	Vertex(String name,boolean isInSetS,Edge edgeList){
		this.name=name;
		this.isInSetS=isInSetS;
		this.adjList=adjList;
		this.label=100000;
		this.heapIndex=-1;
	}
	
	public int compareTo(Vertex e){
		if(this.label > e.label){
			return 1;
		}
		else if(this.label < e.label){
			return -1;
		}
		else{
			return 0;
		}
	}

}

class Edge {
	int dest;
	int weight;
	Edge link;
	Edge(int dest,int weight,Edge link){
		this.dest=dest;
		this.weight=weight;
		this.link=link;	
	}

}

class Graph{

Vertex verList[];
int nodeCount;
int edgeCount;

void createGraph(Scanner sc){
	
		
	// scan number of nodes and their names
	nodeCount=sc.nextInt();
	verList=new Vertex[nodeCount];
	for(int i=0;i<nodeCount;i++){
		verList[i]=new Vertex(sc.next(),false,null);
	}	

	// scan number of edges and their names.
	edgeCount=sc.nextInt();
	for(int i=0;i<edgeCount;i++){
		int source=indexOf(sc.next());
		int destination=indexOf(sc.next());
		int weight=sc.nextInt();

		createEdges(source,destination,weight);
		createEdges(destination,source,weight);
	}

}

private void createEdges(int source , int destination , int weight){
	if(verList[source].adjList==null){
		verList[source].adjList=new Edge(destination,weight,null);
	}
	else{
		Edge temp=verList[source].adjList;
		while(temp.link != null){
			temp=temp.link;
		}
		temp.link=new Edge(destination,weight,null);
	}
}

private int indexOf(String s){
	for(int i=0;i<nodeCount;i++){
		if(verList[i].name.equals(s)){
			return i;
		}
	}

	return -1;
}

void prims(Heap heap,String source){
	// add all the vertices to the Set S-complement
	for(int i=0;i<nodeCount;i++){
		heap.insertVertex(verList[i]);
	}	
	heap.printHeap();
	heap.decreaseP(verList[indexOf(source)],0);
	heap.printHeap();

	while(!(heap.isEmpty())){

		Vertex minVertex=heap.deleteMin();
		System.out.println(minVertex.name+" is selected to moved to set S with label "+minVertex.label);
		// for all the vertices adj to minVertex
		Edge temp=minVertex.adjList;
		while(temp!=null){
			if(!(verList[temp.dest].isInSetS)){
				if(verList[temp.dest].label > temp.weight){
					//System.out.println("updating "+verList[temp.dest].name+" label with value "+temp.weight);
					verList[temp.dest].label=temp.weight;
					heap.printHeap();
					heap.decreaseP(verList[temp.dest],temp.weight);
					heap.printHeap();
				}
			}
			temp=temp.link;
		}		
		minVertex.isInSetS=true;
		//System.out.println(minVertex.name+" is moved to set S with label "+minVertex.label);
	}
}

}

class Main{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);

Graph graph=new Graph();
graph.createGraph(sc);
Heap heap=new Heap(graph.nodeCount);

graph.prims(heap,sc.next());

}
}
