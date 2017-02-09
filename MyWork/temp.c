#include <stdio.h>
#include <time.h>

// lets say I run for 15 kmps speed and I want to note time after each second (not logical ofcourse  , but important thing is it notes time in excell sheet after each second  :)  ).


int main (void)
{
  time_t rawtime;
  struct tm * timeinfo;
  int i=0;
  int m=5;  // I will continue this process for 5 seconds.
  time_t mytime;

 FILE *fp;
 fp=fopen("myData.csv","w+");

 for(i=0;i<m;i++){
 
    fprintf(fp,"%d",i+1);
    sleep(1);
    mytime = time(NULL);
    fprintf(fp,",%s",ctime(&mytime));
 
   
    }
 
 fclose(fp);
 


  return 0;
}
