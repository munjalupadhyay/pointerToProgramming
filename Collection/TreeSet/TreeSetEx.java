import java.util.*;

class TreeSetEx
{
public static void main(String args[])
{

	TreeSet<String> ts=new TreeSet<String>();
	
	ts.add("first");
	ts.add("second");
	ts.add("third");
	ts.add("fourth");
	ts.add("fifth");	

	System.out.println(ts);

	// all the methods like isEmpty() , size() , clear() are same as of other collection classes.
	
	// How to create a TreeSet with a List?
	
	List< String> list = new ArrayList<String>();
	list.add("first");
	list.add("second");
	list.add("third");
	list.add("fourth");
	list.add("fifth");
		
	System.out.println(list);
	TreeSet<String> tl=new TreeSet<String>(list);
	System.out.println(tl);
		
	// read objects from a treeset using iterator.
	// same as of other collection class.

	// remove duplicate entries from an array ?

	String[] strArr = {"one","two","three","four","four","five"};
	List<String> tmpList=Arrays.asList(strArr);

	TreeSet<String> unique=new TreeSet<String>(tmpList);
	System.out.println(tmpList);
	System.out.println(unique);

	// Create TreeSet with comparator by user define objects.
	// A seperate program is given.

	// How to get least value element from a set?
	System.out.println(ts.first());
	// How to get highest value element from a set?
	System.out.println(ts.last());	
	



}
}
