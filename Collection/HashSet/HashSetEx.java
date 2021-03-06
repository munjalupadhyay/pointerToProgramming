import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

class HashSetEx{

public static void main(String args[]){

	HashSet<String> hs=new HashSet<String>();
	
	// adding elements to HashSet
	hs.add("First");
	hs.add("Second");
	hs.add("Third");
	hs.add("Fourth");
	hs.add("Fifth");

	// If you try to add duplicated elements then add() will return false
	System.out.println(hs.add("Fifth"));
	
	System.out.println(hs);

	System.out.println("Is hashset empty ? :"+hs.isEmpty());


	// remove elements.
	hs.remove("Second");

	System.out.println(hs);

	// size of hashset
	System.out.println(hs.size());

	// to check whether object exists or not.
	System.out.println(hs.contains("First"));
	
	// iterate through all the elements in hashset
	Iterator<String> it=hs.iterator();

	while(it.hasNext()){
		System.out.println(it.next());
	}
		

	// Copy another collection object to hashSet object.
	Collection<String> c=new ArrayList<String>();
	c.add("munjal");
	c.add("First");
	c.add("munjal");
	c.add("hulk");
	c.add("spiderMan");

	System.out.println(c);
	hs.addAll(c);
	System.out.println(hs);

	// delete all the elements from hashset ?
	// hs.clear();

	// Copy all the element to array

	//String arr[]=new String[hs.size()];
	//hs.toArray(arr);
	//for(String str : arr){
	//	System.out.println("("+str+")");
	//}	


	// How to compare two sets and retain elements which are same on both sets? 
	HashSet<String> subset=new HashSet<String>();
	subset.add("First");
	subset.add("Second");
	subset.add("Third");
	subset.add("Fourth");
	subset.add("Fifth");
	subset.add("Sixth");

	hs.retainAll(subset);	

	System.out.println(hs);

	// How to eliminate duplicate user defined objects from HashSet?
	// How to find user defined objects from HashSet?
	// How to delete user defined objects from HashSet?

	// A selerate program is given for all the above questions in samne folder.

	
	

}


	 
}
