import java.util.Scanner;
import java.lang.*;

class spoj 
{


void primeFactorization(int n){

	int b=2;
	int p=0;

	while(n!=1 || b<=((int)Math.sqrt(n))){

		if((n%b)==0){

			while(true){
				if(n%b==0){
					n=n/b;
					p=p+1;
				}
				else{
		
					System.out.println(b+"^"+p);	
					p=0;	
					break;
				}

			}

		}

		else{
			b=b+1;
		}


	}

}

public static void main(String args[])
{

	Scanner s=new Scanner(System.in);
	int n=0;
	int sum=0;	
	int i=0;
	int val=s.nextInt();
	spoj sp=new spoj();
	sp.primeFactorization(val);
	
	

	


}
}
