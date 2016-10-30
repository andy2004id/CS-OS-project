/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3103;

import java.util.concurrent.Semaphore;

/**
 *
 * @author admin
 */
public class Staff extends Thread{
    
    private int id;//staff id
    private int opt,value; //opt may change to string
    private Company c;
    private final Semaphore mutex = new Semaphore(1, true);
    
    public Staff(int id){
        super();
        this.id=id;
        }
    //getter & setter
    
    public void setOpt(Company c, int opt, int v){
        this.c=c;//company to handle
        this.opt=opt;//operation
        this.value=v;//amount
    }
    
    //Don't use getId() as it's been used by parent Thread object
    public int getStaffId(){
        return id;
    }
    
    //mutex lock
    public void lock(){
        try{
            mutex.acquire();
        }catch(InterruptedException e){}
    }
    public void unlock(){
            mutex.release();
    }
    public int getLockState(){
        return mutex.availablePermits();
    }
    //Run the thread
    public void run(){
        System.out.print("Operation: "+opt+"\n");
        switch(opt){
            case 0://deposit
                c.WLock();
                c.deposit(value);
                System.out.print("Staff "+id+" is serving"+"\n");
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.WUnlock();
                break;
            case 1://withdrawal
                c.WLock();
                c.withdrawal(value);
                System.out.print("Staff "+id+" is serving"+"\n");
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.WUnlock();
                break;
            case 2://check balance
                c.RLock();
                System.out.print("Staff "+id+" is serving"+"\n");
                System.out.print("Balance of company "+c.getId()+" : "+c.checkBal()+"\n");
                c.RUnlock();
                break;
        }
        mutex.release();
        
    }
    
    
}
