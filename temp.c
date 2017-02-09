#include<stdio.h>
#include<stdlib.h>
struct Book{
int pages;
char *name;
};

int main(void){

struct Book book={100,"munjal"};

printf("%d\n",book.pages);
printf("%s\n",book.name);

struct Book *pBook=(struct Book*)malloc(sizeof(struct Book));
pBook->pages=50;
pBook->name="devaki";
printf("%d\n",pBook->pages);
printf("%s\n",pBook->name);

return 0;
}
