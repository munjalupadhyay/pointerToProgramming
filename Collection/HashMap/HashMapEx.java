import java.util.*;

class HashMapEx{
public static void main(String args[]){

HashMap<String,String> hm=new HashMap<String,String>();

// add elements to HashMap.

hm.put("first","FIRST ELEMENT");
hm.put("second","SECOND ELEMENT");
hm.put("third","THIRD ELEMENT");

System.out.println(hm);

// get values for given key.
System.out.println(hm.get("second"));

// remove element from HashMap.
hm.remove("third");

System.out.println(hm);

System.out.println("Is HashMap empty? "+hm.isEmpty());
System.out.println("Size of the HashMap: "+hm.size());

// Iterate through HashMap
// The method keySet() returns all key entries as a set object. Iterating through each key, we can get corresponding value object.

Set<String> set=hm.keySet();
for(String str : set){
	System.out.println("value of "+str+" is "+hm.get(str));
}


// Copy Map content to another HashMap.

HashMap<String,String> hm2=new HashMap<String,String>();
hm2.put("s1", "S1 VALUE");
hm2.put("s2", "S2 VALUE");

hm.putAll(hm2);

System.out.println(hm);

// How to search a key in HashMap?
System.out.println(hm.containsKey("s1"));

// How to search a value in HashMap?
System.out.println(hm.containsValue("S1 VALUE"));

//How to get all keys from HashMap?
Set<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println(key);
        }

// How to get entry set from HashMap?

// Delete all the elments ...
// hm.clear();

// eliminate user defined object from HashMap
// delete user defined objects from HashMap.




}
}
