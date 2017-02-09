// reference taken form topcoder

import java.util.*;

class Node{
	int words;
	int prefixes;
	Node edges[]=new Node[26];
		
	Node(){
		words=0;
		prefixes=0;
		for(int i=0;i<26;i++){
			edges[i]=null;
		}
	}
}

class MyTree{
	Node root;
	
	MyTree(){
		root=new Node();
	}

	void addWord(Node temp,String str){
		//System.out.println("executing for "+str);
		if(str.length()<1){
			temp.words+=1;
		}
		else{
			temp.prefixes+=1;
			int index=Character.getNumericValue(str.charAt(0));
			//System.out.println(str.charAt(0));
			//System.out.println(Character.getNumericValue(str.charAt(0)));			
			if(temp.edges[index-10]==null){
				temp.edges[index-10]=new Node();
			}
			Node p=temp.edges[index-10];
			addWord(p,str.substring(1));
			

		}		
	}
	
	int countPrefixes(Node temp,String str){
		if(str.length()<1){
			return temp.prefixes;
		}
		int index=Character.getNumericValue(str.charAt(0));
		if(temp.edges[index-10]==null){
			return 0;
		}
		else{
			Node p=temp.edges[index-10];
			return countPrefixes(p,str.substring(1));
		}			
	}
	
	int countWords(Node temp,String str){
		if(str.length()<1){
			return temp.words;
		}
		int index=Character.getNumericValue(str.charAt(0));
		if(temp.edges[index-10]==null){
			return 0;
		}
		else{
			Node p=temp.edges[index-10];
			return countWords(p,str.substring(1));
		}			
	}




}

class Main{


public static void main(String args[]){


	//System.out.println(Character.getNumericValue('a'));			

	MyTree t=new MyTree();

	String temp="tree";
	t.addWord(t.root,temp);
	temp="trie";
	t.addWord(t.root,temp);
	temp="algo";
	t.addWord(t.root,temp);
	temp="assoc";
	t.addWord(t.root,temp);
	temp="all";
	t.addWord(t.root,temp);
	temp="also";
	t.addWord(t.root,temp);
	
	System.out.println(t.countPrefixes(t.root,"al"));

	System.out.println(t.countWords(t.root,"all"));

	//System.out.println(str.charAt(0));
	//System.out.println(str.substrig(1));
	//m.fun(temp);

}
}
