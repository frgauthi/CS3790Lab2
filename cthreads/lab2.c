// Author: Frankie Gauthier
// 
// A program to compute the primes up to a maximum number
//
//   /lab2.c <max number> <# of threads>
// EG /lab2.c 15 3 in the console will create 3 threads to compute the primes up to 15
// 


#include <stdio.h>
#include <pthread.h>


// nake a bool type
enum bool { false, true};
typedef enum bool bool ;


// loop indexes
unsigned int i = 0, j = 0;


//function prototypes
void *sieve(void *param[]);




//checks if the value is prime by bruteforce division
bool isPrime(unsigned int num){
	
	if(num == 1)return false;
	if(num == 2)return true;
	for (i = 2;i<num;i++){
	if(num%i == 0) return false;
	}

return true;
}



// checks integers up to the number passed to it for primality and prints the prime ones
void *sieve(void *param[]){
	
	int lower = (int)param[0];
	int upper = (int)param[1];
	
	for (j = lower; j<upper;j++){
	
		if (isPrime(j)){
	
			 printf(" %u ",j);
			
		 
		}
	}
}




int main(int argc, char *argv[]){

// set users 2 parpameter to the number of threads to create
int numThreads=(int)*argv[2], start = 1;
// set users 1 parameter to the number to find primes up until
int size = (int)*argv[1]; 

// find the number of intervals and init the pointer array with it
int sizeOfInterval = size/numThreads;
int *interval[numThreads][2];


//thread identifier array
pthread_t tid[numThreads];

for (i = 0;i<=numThreads; i++){
	// for each thread pass the sieve up/low bounds for each interval
	*interval[i][0] = start;
	*interval[i][1] = start + (sizeOfInterval);
	start += sizeOfInterval;
	//create and wait for thread to finish
	pthread_create (&tid[i], NULL,sieve,(void *)interval[i]);
	pthread_join(tid[i],NULL);
}



return 0;
}




