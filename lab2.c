#include <stdio.h>
#include <pthread.h>


enum bool { false, true};
typedef enum bool bool ;
// divides numbers 2 - (num-1) into num to determine if it is a prime number

int i = 0;
int j = 0;

bool isPrime(int num){
	
	if(num == 1)return true;
	if(num == 2)return false;
	for (i = 2;i<num;i++){
		if(num%i == 0) return false;
	}

return true;
}

void printPrimes(int max){
	for (j = 2; j<max ;j++){
		if (isPrime(j)) printf(" %d ",j);
	}
}


int main(int argc, char *argv[]){
printPrimes(21);
printf( "\n %d \n",isPrime(2));
printf( " %d \n",isPrime(1));

return 0;
}




