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
	private int thread;
        
        //constructor
         public printPrimes(int lower, int upper, int thread){
             this.upper = upper;
             this.lower = lower;
	     this.thread = thread;
         }
         // print the primes between upper and lower
         public void run(){
	        
		
		//System.out.print("Thread " + thread + " found: ");
             
		for(int i = lower;i<upper;i++){
                    if (isPrime(i)) System.out.print("Thread #" + (thread+1) +  " found: " + i + "\n");
                }
		
		
		
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
            thrd[i] = (new Thread (new printPrimes (start, start+intervalSize, i)) );
            start += intervalSize;
            thrd[i].start();                   
        }

	// join each thread after creating them	
	for (int i =0; i<numThreads; i++){
		
		try{
			thrd[i].join();
		} catch(InterruptedException ie){}
	
	}
    }
}
