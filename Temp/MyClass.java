import java.util.*;

class Node{
String name;
boolean visited;
Neighbour adjList;

Node(String name,Neighbour adjList){
this.name=name;
this.adjList=adjList;
}

}

class Neighbour{
int index;
Neighbour link;
Neighbour(int index,Neighbour link){
this.index=index;
this.link=link;
}
}



class Graph{

	Node[] vertexList;
	Scanner scan=new Scanner(System.in);

	Graph(int vertexCount,String names[]){
		vertexList=new Node[vertexCount];
		for(int i=0;i<vertexList.length;i++){
			vertexList[i]=new Node(names[i],null);
		}		
	}


	void addEdge(String name1,String name2){
		int name1Index=indexOf(name1);
		int name2Index=indexOf(name2);
	
		if(vertexList[name1Index].adjList==null){
			vertexList[name1Index].adjList=new Neighbour(name2Index,null);
		}
		else{
			// traverse till the last node in the linked list of Neighbour. 
			Neighbour temp;
			temp=vertexList[name1Index].adjList;
			while(temp.link!=null){
				temp=temp.link;
			}
			temp.link=new Neighbour(name2Index,null);
		}

	}

	int indexOf(String str){
		for(int i=0;i<vertexList.length;i++){
			if(vertexList[i].name.equals(str)){
				return i;
			}
		}
		return -1;

	}


	void printGraph(){
		for(int i=0;i<vertexList.length;i++){
			System.out.print(vertexList[i].name);
			Neighbour temp=vertexList[i].adjList;
			
			while(temp!=null){
				System.out.print("-->"+vertexList[temp.index].name);
				temp=temp.link;
			}

			System.out.println();
		}
	}

	// related to BFS
	LinkedList<String> Q=new LinkedList<String>();
	
	void enQueue(String str){
		Q.add(str);
	}
	
	String deQueue(){
		return Q.removeFirst();
	}

	void printBFS(String source){
		enQueue(source);
		vertexList[indexOf(source)].visited=true;
		while(Q.size()!=0){
			String u=deQueue();
			Neighbour neb=vertexList[indexOf(u)].adjList;
			while(neb!=null){
				int index=neb.index;
				if(vertexList[index].visited!=true){
					vertexList[index].visited=true;
					enQueue(vertexList[index].name);
				}
				neb=neb.link;
			}

			System.out.print("-"+u+"-");				
			
		}
		System.out.println();
	}

	// implementation of stack.	
	LinkedList<String> stack=new LinkedList<String>();	

	void DFS(String u){
		int index=indexOf(u);
		if(vertexList[index].visited!=true){
			vertexList[index].visited=true;
			System.out.print("="+vertexList[index].name+"=");

			Neighbour neb=vertexList[index].adjList;
			while(neb!=null){
				stack.add(vertexList[neb.index].name);
				DFS(vertexList[neb.index].name);
				neb=neb.link;
			}			
			
		}
		stack.removeLast();
		
	}

	void printDFS(String source){
		int index=indexOf(source);
		stack.add(vertexList[index].name);
		DFS(source);
	}

	void printStack(){
		System.out.println(stack);
	}


}

class MyClass{


public static void main(String args[]){

	String arr[]={"A","B","C","D","E","F","G","H"};
	Graph graph=new Graph(arr.length,arr);
	graph.addEdge("A","B");
	graph.addEdge("A","C");
	graph.addEdge("B","D");
	graph.addEdge("B","E");
	graph.addEdge("C","F");
	graph.addEdge("C","G");
	graph.addEdge("D","H");	
	graph.addEdge("E","H");	
	graph.addEdge("F","H");	
	graph.addEdge("G","H");	

	// make the edges both the way(i.e. making graph undirectional)
	graph.addEdge("H","D");	
	graph.addEdge("H","E");
	graph.addEdge("H","F");
	graph.addEdge("H","G");			
	graph.addEdge("D","B");
	graph.addEdge("E","B");		
	graph.addEdge("F","C");	
	graph.addEdge("G","C");
	graph.addEdge("B","A");	
	graph.addEdge("C","A");		

	//graph.printGraph();
	//graph.printBFS("G");
	graph.printDFS("A");
	System.out.println();
	graph.printStack();


}
}
