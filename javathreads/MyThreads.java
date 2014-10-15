import java.lang.String;



public class MyThreads {

static int threadCount = 0;    
    
    // function recieves and int and returns a boolean true if the value is prime otherwise false
    public static boolean isPrime(int num){
        if(num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i<num;i++){
            if (num %i  == 0) return false;
        }
        
        return true;
    }
  
  
    static class printPrimes implements Runnable{
        //bounds for the interval 
	private int upper;
        private int lower;
        
        //constructor
         public printPrimes(int lower, int upper){
             this.upper = upper;
             this.lower = lower;
         }
         // print the primes between upper and lower
         public void run(){
	        
		threadCount++;
		System.out.print("Thread " + threadCount + " found: ");
             
		for(int i = lower;i<upper;i++){
                    if (isPrime(i)) System.out.print(" " +  i +  " ");
                }
		
		System.out.println();
		
         }
        
    }

    
    public static void main(String[] args){
    
	
        //determine the amount of threads and max number from first 2 arguments
        int numThreads, maxNum, start, intervalSize;
        maxNum =  Integer.parseInt(args[0]);
        numThreads= Integer.parseInt(args[1]);
        
        //determine the size of each interval
        intervalSize = maxNum/numThreads;
        start = 1;
        
        
        // create thread array
        Thread thrd[] = new Thread[numThreads];
        
        
        
        for(int i = 0; i<numThreads; i++)
        {   
            
            //create threads, start and join them
            thrd[i] = (new Thread (new printPrimes (start,start+intervalSize)) );
            start += intervalSize;
            thrd[i].start();
        
            try{
            thrd[i].join();
            }catch(InterruptedException ie){}
        
            
        }
    }
}
