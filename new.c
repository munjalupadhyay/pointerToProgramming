#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *link;
};


struct node * insertAtEnd(struct node *head,int data)
{
	if(head==NULL)
	{
		struct node *n1;
		n1=(struct node *)malloc(sizeof(struct node));
		n1->data=data;		
		n1->link=NULL;		

		head=n1;
		
		
	}
	else
	{
	struct node *n1;
	n1=(struct node *)malloc(sizeof(struct node));
	n1->data=data;
	n1->link=NULL;

	// traverse to the end of the list.
	
	struct node *temp;
	temp=head;	
	while((temp->link)!=NULL)
	{
		temp=temp->link;
	}
	
	temp->link=n1;
	}

	return head;	
}


void printList(struct node *head)
{
	if(head==NULL)
	{
		printf("no element in list");
	}
	else
	{
		struct node *temp;
		temp=head;
		while(temp!=NULL)
		{
			printf("--%d--",(temp->data));
			temp=temp->link;
		}
			
		printf("\n\n");
	}


}






struct node * reverse(struct node *p1,struct node * p22)
{
	struct node * temp=NULL,*p0=NULL,*p2=NULL;
	
	temp=p1;
	p2=p1->link;

	while(1)
	{
		if(p0==NULL)
		{
			p1->link=p22;
			p0=p1;
			p1=p2;
			p2=p2->link;
		}
		else
		{
			p1->link=p0;
			p0=p1;
			p1=p2;
			p2=p2->link;
		
		}
		if(p2==NULL)
		{
			p1->link=p0;
			break;
			
		}


	}


	//temp->link=p22;
	return p1;

}


int main(void)
{

struct node *head=NULL;
struct node *p1,*p2,*temp=NULL;
int count=1;
struct node *temp1=head,*temp2=NULL;

head=insertAtEnd(head,1);
head=insertAtEnd(head,2);

head=insertAtEnd(head,3);

head=insertAtEnd(head,4);
head=insertAtEnd(head,5);

head=insertAtEnd(head,6);

head=insertAtEnd(head,7);
head=insertAtEnd(head,8);
head=insertAtEnd(head,9);
head=insertAtEnd(head,10);
head=insertAtEnd(head,11);
head=insertAtEnd(head,12);

printList(head);


p1=head;
temp1=head;
temp=head;

while(1)
{
	if(count!=4)
	{
		p1=p1->link;
		temp1=p1;
		temp2=p1->link;
		count++;
	}
	else
	{
		if(temp==head)
		{
			head=reverse(head,temp2);
			count=1;
			p1=temp2;
			temp1=temp;
			
		}
		else
		{
			//temp1=temp;
			temp=temp1->link;
			
			temp1->link=reverse(temp1->link,temp2);
			count=1;
			p1=temp2;
			temp1=temp;

		}

	}	

	if(temp2==NULL)
	{
		break;

	}

	printList(head);


}

//p1->link=reverse(p1->link,temp);


printList(head);


//deleteList(head);

return 0;
}



