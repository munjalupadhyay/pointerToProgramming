// Implementation of basic graph with linked list representation.
// The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array.


import java.util.*;

class Vertex{
	String name;
	Neighbor adjList;
	
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
			System.out.print("||");
			Neighbor temp=verList[i].adjList;
			while(temp!=null){
				System.out.print("||");
				System.out.print("-->"+verList[temp.vertexNum].name);
				System.out.print("||");
				temp=temp.link;
			}			

			System.out.println();
		}
	}

}

class Main{
public static void main(String args[]){
	
	MyGraph g=new MyGraph();

	g.print();
	


}
}
