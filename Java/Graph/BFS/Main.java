// Implementation of basic graph with linked list representation.


import java.util.*;

class Vertex{
	String name;
	Neighbor adjList;
	// for bfs operations , as per COREMAN book.
	String status;
	int parentIndex;
	int distance;
	
	Vertex(String name ,Neighbor adjList){
		this.name=name;
		this.adjList=adjList;
	}
}

class Neighbor{
	int vertexNum;
	Neighbor link;

	Neighbor(int vertexNum,Neighbor link){
		this.vertexNum=vertexNum;
		this.link=link;
	}
}

class MyGraph{
	
	Vertex verList[];
	
	MyGraph(){
		Scanner sc=new Scanner(System.in);
		int vertexCount=sc.nextInt();
		verList=new Vertex[vertexCount];

		int i=0;
		while(i<vertexCount){
			verList[i]=new Vertex(sc.next(),null);
			i++;
		}
		
		// extract adges
		while(sc.hasNext()){
			int v1=indexOf(sc.next());
			int v2=indexOf(sc.next());

			verList[v1].adjList=new Neighbor(v2,verList[v1].adjList);

		}
		

	}

	int indexOf(String str){
		for(int i=0;i<verList.length;i++){
			if(str.equals(verList[i].name)){
				return i;
			}	
		}
		
		return -1;
	}


	void print(){
		for(int i=0;i<verList.length;i++){
			System.out.print("||");
			System.out.print(verList[i].name);
			System.out.print(verList[i].parentIndex);
			System.out.print(verList[i].distance);
			System.out.print(verList[i].status);
			System.out.print("||");
			Neighbor temp=verList[i].adjList;
			while(temp!=null){
				System.out.print("||");
				System.out.print("-->"+verList[temp.vertexNum].name);
				System.out.print(verList[temp.vertexNum].parentIndex);
				System.out.print(verList[temp.vertexNum].distance);
				System.out.print(verList[temp.vertexNum].status);
				System.out.print("||");
				temp=temp.link;
			}			

			System.out.println();
		}
	}
		
	void enQueue(LinkedList<String> Q,String ele){
		Q.add(ele);
	}

	String deQueue(LinkedList<String> Q){
		return Q.removeFirst();
	}

	void bfs(String source){
		
		for(int i=0;i<verList.length;i++){
			verList[i].status="white";
			verList[i].distance=0;
			verList[i].parentIndex=0;			
		}

		LinkedList<String> Q=new LinkedList<String>();	
		verList[indexOf(source)].status="gray";
		verList[indexOf(source)].distance=0;
		verList[indexOf(source)].parentIndex=-1;
		enQueue(Q,source);

		while(!Q.isEmpty()){
			String ele=deQueue(Q);

			// for each element adjcent to ele.
			int eleIndex=indexOf(ele);
			Neighbor neighbors=verList[eleIndex].adjList;

			while(neighbors!=null){
				if(verList[neighbors.vertexNum].status=="white"){
					verList[neighbors.vertexNum].status="gray";
					verList[neighbors.vertexNum].distance=verList[eleIndex].distance+1;
					verList[neighbors.vertexNum].parentIndex=eleIndex;					
					enQueue(Q,verList[neighbors.vertexNum].name);

				}
				neighbors=neighbors.link;

			}
			
			verList[eleIndex].status="black";

		}
		
		
		

	}



}

class Main{
public static void main(String args[]){
	
	MyGraph g=new MyGraph();
	
	g.bfs("D");

	g.print();
	


}
}
