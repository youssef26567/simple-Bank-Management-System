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
public class customers {
    
     private final String name;
    private final int age;
   private final long id;
    private final String address;
      private ArrayList<Account>account;

  
    public customers(String name, int age, long id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
      
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
    
     @Override
    public String toString(){

    
        String Statment= "Name  "+name+"   "+"age  "+age+"   "+"id  "+id+"   "+"Address  "+address;
        

        return Statment;
    }


    void bookAppointment(Appointment p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

        


