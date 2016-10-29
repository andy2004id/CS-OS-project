package cs3103;



public class OSProject {
	
	public static void main(String args[]){
		
	/*
        Directly use Input file 1 setting for testing, not gonna do the file I/O first
            */
        int M=5,T_d=3,T_w=3,T_b=3,T_in=1,T_out=1; //Threads,Time(deposit, withdrawal, check bal., in, out)
        int T; //current time
        Company[] acc = new Company[2];//balance of company[n]
        Thread[] staff = new Thread[M];
        acc[0] = new Company(10000,1);
        acc[1]=  new Company(100,2);
                
        staff[0] = new Thread( new Operation(1, acc[0], 100) ); 
        staff[0].start();
        //locking test
        
        staff[1] = new Thread( new Operation(0, acc[0], 100) ); 
        staff[1].start();
        
                
        
	}

}
