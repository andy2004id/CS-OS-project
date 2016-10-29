/*
    class for implement all operation done by threads
*/

package cs3103;


public class Operation implements Runnable{
    int opt=2, value;
    Company c;
    
    
    public Operation(int opt, Company c, int val){
        this.opt=opt;
        this.c=c;
        value=val;
    }
    public void run(){
        System.out.print("Operation: "+opt+"\n");
        switch(opt){
            case 0://deposit
                c.WLock();
                c.deposit(value);
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.WUnlock();
                break;
            case 1://withdrawal
                c.WLock();
                c.withdrawal(value);
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.WUnlock();
                break;
            case 2://check balance
                c.RLock();
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.RUnlock();
                break;
        }
    }
}
