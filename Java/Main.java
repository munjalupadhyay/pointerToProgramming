import java.util.*;

class Main{
public static void main(String args[]){

Scanner s =new Scanner(System.in);
String st=s.next();

int arr[]=new int[26];
for(int i=0;i<=25;i++){
	arr[i]=0;
}

for(int i=0;i<st.length();i++){
	int j=(int)st.charAt(i);
	arr[j-97]+=1;
}

for(int i=0;i<26;i++){
	if(arr[i]>1){
		System.out.println(((char) (i+97))+" count : "+arr[i]);
	}

}


}
}





