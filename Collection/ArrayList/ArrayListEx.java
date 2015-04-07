// Java ArrayList class uses a dynamic array for storing the elements.It extends AbstractList class and implements List interface.
// Java ArrayList class can contain duplicate elements.
// Java ArrayList class maintains insertion order.
// Java ArrayList class is non synchronized.
// Java ArrayList allows random access because array works at the index basis.
// In Java ArrayList class, manipulation is slow because a lot of shifting needs to be occurred if any element is removed from the array list.


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

class ArrayListEx{
public static void main(String args[]){

	ArrayList<String> al=new ArrayList<String>();

	// add the element.
	al.add("munjal");		
	al.add("kunjal");
	al.add("gunjal");
	al.add(2,"ganesha");
	al.add(1,"shiva");
	
	System.out.println(al);

	// Edit the element
	al.set(2,"at"); 
	
	System.out.println(al);

	// remove all elements.
	//al.clear();

	// Removing elements
        // removing the element in index 0

	al.remove("enjoying"); 
	System.out.println(al);
	al.remove(2);
	System.out.println(al);	

	
	// Checking if array list is empty
        boolean check = al.isEmpty();

	// retriving an element 
	String str=al.get(0);
	System.out.println(str);


	// traverse all the elements using for loop
	for(int i=0;i<al.size();i++){
		System.out.println(al.get(i));
	}

	System.out.println();

	// traverse all the element using foreach loop 
	for(String st : al){
		System.out.println(st);
	}	

	System.out.println();

	//  traverse all the element using iterator.

	Iterator<String> it=al.iterator();	
	while(it.hasNext()){
		System.out.println(it.next());
	}
	
	// Converting ArrayList to Array
	String strArray[]=al.toArray(new String[al.size()]);

	// add all the eleemnt of List to ArrayList

	List<String> l=new ArrayList<String>();
	l.add("lela");
	l.add("majanu");
	al.addAll(l);
	System.out.println(al);

	// Get sub List from ArrayList.

	List<String> subL=al.subList(2,4);
	System.out.println(subL);

	// How to sort ArrayList using Comparator? : another class is proviede to explain it.

	// How to reverse ArrayList content? 
	Collections.reverse(al);
	System.out.println(al);	

}
}
