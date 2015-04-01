class Node{

	private Object data;
	private Node link; 

	Node(Object d){
		this(d,null);
	}

	Node(Object d, Node l){
		data=d;
		link=l;
	}

	/* getter setter method for this class */
	
	public Object getData(){
		return data;
	}
	
	public void setData(Object d){
		data=d;
	}

	public Node getLink(){
		return link;
	}

	public void setLink(Node l){
		link=l;
	}

}

class LinkedList{
	public Node start=null;
	int nodeCount=0;

	public void insertAtBegin(Object data){
		Node p=new Node(data,null);
		
		if(start==null){
			start=p;
			nodeCount++;
		}

		else{
			p.setLink(start);
			start=p;
			nodeCount++;
		}


	}


	public void insertAtEnd(Object data){

		Node p=new Node(data,null);
		
		if(start==null){
			start=p;
			nodeCount++;
		}
		else{
			Node temp=start;
			while(temp.getLink()!=null){
				temp=temp.getLink();
			}

			temp.setLink(p);
			nodeCount++;
		}
	}

	public void deleteFromBegin(){

		if(nodeCount==0){
			System.out.println("LL is emply");
		}
		else{
			start=start.getLink();
			nodeCount--;

		}

	}

	public void deleteFromEnd(){

		/* find the last LL node*/
		Node p=start;
		if(nodeCount==0){
			System.out.println("LL is empty");
		}
		else if(nodeCount==1){
			start=null;
			nodeCount--;
		}
		else{
	
			while(p.getLink().getLink()!=null){ /* In C it works , but I wonder how this worked in java*/
				p=p.getLink();
	
			}
			p.setLink(null);
			nodeCount--;
		}
	}

	public void printList(){
		
		Node temp=start;
		while(temp!=null){
			System.out.print("--"+temp.getData());
			temp=temp.getLink();
		}
		System.out.println("");


	}


	public String toString() {
		String list = "";
		list += "[" + this.start.getData() + "]";

		Node curr = start.getLink();
		while (curr != null){
			list += "[" + curr.getData() + "]";
		curr = curr.getLink();
	}

    return list;

}
	
}


class Sll{

public static void main(String args[]){

	LinkedList sl=new LinkedList();
	sl.insertAtEnd(1);
	sl.insertAtEnd(2);
	sl.insertAtEnd(3);
	sl.insertAtEnd(4);
	sl.insertAtEnd(5.5);

	sl.printList();

	sl.deleteFromEnd();

	sl.printList();

	sl.deleteFromBegin();

	sl.printList();

	System.out.println(sl);
}

}
