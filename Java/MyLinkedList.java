class Node{
private Object data;
private Node link;


Node(){
	this.data=0;
	this.link=null;		
}

Node(Object data){
	this.data=data;
	this.link=null;
}

Node(Object data,Node link){
	this.data=data;
	this.link=link;
}

void setData(Object data){
	this.data=data;
}
void setLink(Node link){
	this.link=link;
}

Object getData(){
	return data;
}
Node getLink(){
	return link;
}


}

class MyLinkedList{

public Node head;


MyLinkedList(){
	head=null;
}

public void add(Object data){
	Node p=new Node(data,null);
	if(head==null){
		head=p;
	}
	else{
		(linkToLastNode()).setLink(p);	
	}

}

public void addFirst(Object data){
	Node p=new Node(data,head);
	if(head==null){
		head=p;
	}
	else{
		
		head =p;	
	}

}

public Object deleteFirst(){
	Object data=head.getData();
	head=head.getLink();
	return data;
}


private Node linkToLastNode(){
	if(head==null){
		return null;
	}
	else{
		Node temp=head;
		while((temp.getLink())!=null){
			temp=temp.getLink();
		}
		return temp;
	}
}

public String toString(){
	Node temp= head;
	if(temp==null){
		return "";
	}
	else{
		StringBuilder sb=new StringBuilder(" ") ;
		while(temp!=null){
			sb.append(temp.getData());
			sb.append(" ");		
			temp=temp.getLink();
		}
		return sb.toString();
	}
}


}




