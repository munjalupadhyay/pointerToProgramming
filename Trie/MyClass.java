class Node{
	int words;
	int prefixes;
	Node link[]=new Node[26];
}

class Trie{

 Node createNode(){
	Node p=null;
	p=new Node();
	return p;
}

 void initialize(Node p){
	p.words=0;
	p.prefixes=0;
	for(int i=0;i<26;i++){
		p.link[i]=null;
	}
}

void addWord(Node p,String s){
	//System.out.println("executing for "+s);
	if(s.length()==0){
		p.words+=1;
		return;
	}
	else{
		int charVal=(int)s.charAt(0);
		if(charVal>90){
			charVal-=32;
		}
		charVal-=65;
		p.prefixes+=1;
		if(p.link[charVal]==null){
			p.link[charVal]=new Node();
			initialize(p.link[charVal]);
		}
		addWord(p.link[charVal],s.substring(1));

	}
}

int countPrefixes(Node p,String prefix){   // return the number of words with word "prefix"
	if(prefix.length()==0){
		return p.prefixes;
	}
	else{
		int charVal=(int)prefix.charAt(0);
		if(charVal>90){
			charVal-=32;
		}
		charVal-=65;
		if(p.link[charVal]==null){
			return 0;
		}
		else{
			return countPrefixes(p.link[charVal],prefix.substring(1));
		}
	
	}

}

}

class MyClass{
public static void main(String args[]){

	Node root=null;
	Trie t=new Trie();
	root=t.createNode();
	
	t.addWord(root,"tree");
	t.addWord(root,"trie");	
	t.addWord(root,"algo");
	t.addWord(root,"assoc");
	t.addWord(root,"all");
	t.addWord(root,"also");

	System.out.println(t.countPrefixes(root,"tr"));

}
}
