

public class MyThreads {
    
    
    public static boolean isPrime(int num){
        if(num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i<num;i++){
            if (num %i  == 0) return false;
        }
        
        return true;
    }
    
    static class printPrimes implements Runnable{
        private int upper;
        private int lower;
        
        //constructor
         public printPrimes(int lower, int upper){
             this.upper = upper;
             this.lower = lower;
         }
         
         public void run(){
                
             for(int i = lower;i<upper;i++){
                    if (isPrime(i)) System.out.print(" "+i+" ");
                }
         }
        
    }
    
    public static void main(String[] args){
    
        //determine the amount of threads and max number
        int numThreads, maxNum, start, intervalSize;
        maxNum =  Integer.parseInt(args[0]);
        numThreads= Integer.parseInt(args[1]);
        
        //determine the size of each interval
        intervalSize = maxNum/numThreads;
        start = 1;
        
        int[][] interval = new int[numThreads][2];
        
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
