import java.util.ArrayList;
import java.util.Iterator;

class spoj{
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

	
	

	
}
}
