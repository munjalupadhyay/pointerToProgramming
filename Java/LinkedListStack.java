class LinkedListStack{

private MyLinkedList ll=new MyLinkedList();

public void push(Object data){
	ll.addFirst(data);
}

public Object pop(){
	return ll.deleteFirst();
}

public String toString(){
	return ll.toString();
}

}
