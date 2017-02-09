// Implementation of basic graph with linked list representation.


import java.util.*;

class Vertex{
	String name;
	Neighbor adjList;
	// for bfs operations , as per COREMAN book.
	String status;
	int parentIndex;
	int d;		// discovered time
	int f;		// finish time
	
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
	int time;	// global variable time

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
			System.out.print(verList[i].d);
			System.out.print(verList[i].f);
			//System.out.print(verList[i].parentIndex);
			System.out.print(verList[i].status);
			System.out.print("||");
			Neighbor temp=verList[i].adjList;
			while(temp!=null){
				System.out.print("||");
				System.out.print("-->"+verList[temp.vertexNum].name);
				System.out.print(verList[temp.vertexNum].d);
				System.out.print(verList[temp.vertexNum].f);
				//System.out.print(verList[temp.vertexNum].parentIndex);
				System.out.print(verList[temp.vertexNum].status);
				System.out.print("||");
				temp=temp.link;
			}			

			System.out.println();
		}
	}
		
	void dfs(){
		
		//LinkedList<String> stack=new LinkedList<String>();		
	
		for(int i=0;i<verList.length;i++){
			verList[i].status="white";
			verList[i].d=0;
			verList[i].f=0;
			//verList[i].parentIndex=0;			
		}

		int time=0;
		for(int i=0;i<verList.length;i++){
			if(verList[i].status=="white"){
				dfsVisit(i);
			}
		}
	}// end of dfs

	void dfsVisit(int index){
			time+=1;
			verList[index].status="gray";
			verList[index].d=time;				
			//verList[i].parentIndex=-1;

			// for each vertex v adjacent to verList[i]
			Neighbor neighbor=verList[index].adjList;
			while(neighbor!=null){

				if(verList[neighbor.vertexNum].status=="white"){
					
					dfsVisit(neighbor.vertexNum);
					
				}
				neighbor=neighbor.link;

			}

			verList[index].status="black";
			time+=1;
			verList[index].f=time;
	}
				

	


}

class Main{
public static void main(String args[]){
	
	MyGraph g=new MyGraph();
	
	g.dfs();

	g.print();
	
	

}
}
