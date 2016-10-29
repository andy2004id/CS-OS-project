/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3103;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 *
 * @author admin
 */
public class Company {
    private int bal, id;
    ReadWriteLock RWlock = new ReentrantReadWriteLock();  
    
   public Company(int balance, int id){
       this.bal=balance;
       this.id=id;
   }
   public int getId(){
       return id;
   }
   public int checkBal(){
       return bal;
   }
   public void deposit(int val){
       bal+=val;
   }
   public void withdrawal(int val){
       bal-=val;
   }
   public void RLock(){
       RWlock.readLock().lock();
   }
   public void RUnlock(){
       RWlock.readLock().unlock();
   }
   public void WLock(){
       RWlock.writeLock().lock();
   }
   public void WUnlock(){
       RWlock.writeLock().unlock();
   }
}
