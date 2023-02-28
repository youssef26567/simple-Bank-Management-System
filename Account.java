/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Youssef
 */
public class Account {

    static Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final long Accountnum;
    protected float Balance=0;
    private Iterable<customers> custmer;

    public Account(long Accountnum, float Balance) {
        this.Accountnum = Accountnum;
        this.Balance = Balance;
    }

    public long getAccountnum() {
        return Accountnum;
    }

    public float getBalance() {
        return Balance;
    }

   int privouse_transition =0;

    public int getPrivouse_transition() {
        return privouse_transition;
    }
   public long   num(){
       
       long xx=Accountnum*95842;
       
       return xx;
   }
   
    
    @Override
 public String toString(){
    String Statment="your Balance :  "+Balance+"$";
     
     return Statment;
}
}
