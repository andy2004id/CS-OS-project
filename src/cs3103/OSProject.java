package cs3103;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


//May have to create a new class
public class OSProject {
    
        
    
	public static void main(String args[]){
            
            
        final int M=5,T_d=3,T_w=3,T_b=3,T_in=1,T_out=1; //Threads,Time(deposit, withdrawal, check bal., in, out)
        int T=0; //current time    
	Company[] acc = new Company[2];//balance of company[n]
        
        Staff[] staff = new Staff[M];
        for(int i=0;i<M;i++){                   //Init staff, assign staff Id
            staff[i] = new Staff(i);
        }
        
        acc[0] = new Company(10000,1);
        acc[1]=  new Company(100,2);
        Queue<Integer> queue = new LinkedList<Integer>();
	/*
        Directly use Input file 1 setting for testing, not gonna do the file I/O at this time
            */
        
        //Sample use of threads
        int pos=0;
        
        while(staff[pos].getLockState()==0){
            pos=(pos+1)%M;
        }
        staff[pos]=new Staff(pos);
        staff[pos].lock();
        staff[pos].setOpt(acc[0], 1, 100 ); 
        staff[pos].start();

        //locking test
        
        while(staff[pos].getLockState()==0){
            pos=(pos+1)%M;
        }
        staff[pos].lock();
        staff[pos]=new Staff(pos);
        staff[pos].setOpt(acc[0], 2, 100 ); 
        staff[pos].start();
                
        
	}

}
