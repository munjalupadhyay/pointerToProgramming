import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class LinkedListEx{
public static void main(String args[]){

LinkedList<String> ll=new LinkedList<String>();
	
ll.add("thore");
ll.add("C America");
ll.add(1,"lockey");
// add elements to begining of the list;
// addFirst(): Inserts the specified element at the beginning of this list.
// offerFirst(): Inserts the specified element at the front of this list.
ll.offerFirst("tony");
ll.addFirst("munjal");

// add elementat last position in linked list
//addLast(): Appends the specified element to the end of this list.
//offerLast(): Inserts the specified element at the end of this list.
//offer(): Adds the specified element as the tail (last element) of this list.
ll.addLast("hulk");

System.out.println(ll);
System.out.println(ll.isEmpty());	
System.out.println(ll.contains("lockey"));
System.out.println("size of linked list is :"+ll.size());

// Traverse list using iterator.

Iterator<String> it=ll.iterator();
while(it.hasNext()){

System.out.println(it.next());
}

// How to iterate through LinkedList in reverse order? 

Iterator<String> rit = ll.descendingIterator();
System.out.println();
while(rit.hasNext()){

System.out.println(rit.next());
}
  


// to copy or clone the linked list
// this will givve you one warning
//LinkedList<String> copy=(LinkedList<String>)ll.clone();
//System.out.println(copy);

// add all the element of List to LinkedList.
List<String> l=new ArrayList<String>();
l.add("munjal");
l.add("thore");

ll.addAll(l);
System.out.println(ll);

// How to find does LinkedList contains all list elements or not?
System.out.println(ll.containsAll(l));

// copy LinkedList to array.
String strArr[]=new String[ll.size()];
ll.toArray(strArr);

// get sublist from linked list.
List<String> lll=ll.subList(2,4);
System.out.println(lll);

// reverse linked list .

Collections.reverse(ll);
System.out.println(ll);

// swap two elements in list

Collections.swap(ll,2,4);
System.out.println(ll);




// How to read first element from LinkedList?
/*
element(): Retrieves, but does not remove, the head (first element) of this list.
getFirst(): Returns the first element in this list. don't remove the first element ofcourse
peek(): Retrieves, but does not remove, the head (first element) of this list.
peekFirst(): Retrieves, but does not remove, the first element of this list, or returns null if this list is empty. 
*/

System.out.println(ll.getFirst());
System.out.println(ll);

// How to read last element from LinkedList?
/*
getLast(): Returns the last element in this list. don't remove the last element ofcourse
peekLast(): Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
*/

System.out.println(ll.getLast());

//remove element from linked list.

/*
remove(): Removes and returns the head (first element) of this list.
remove(index): Removes and returns the element at the specified position in this list.
remove(object): Removes the first occurrence of the specified element from this list, if it is present. returns true or false.
removeFirst(): Removes and returns the first element from this list.
removeFirstOccurrence(object): Removes the first occurrence of the specified element in this list (when traversing the list from head to tail). It 					returns true or false.
removeLast(): Removes and returns the last element from this list.
removeLastOccurrence(object): Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).It 				returns true or false.
*/

System.out.println(ll.remove("menbrain"));
//System.out.println(ll.removeFirstOccurrence("thore"));
System.out.println(ll);

// get rid of Comparators , it is KILLING me.


}
}
