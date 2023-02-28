/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Youssef
 */
public class salared_employe extends employees{
    
    public salared_employe(String name, int age, long code, String address) {
        super(name, age, code, address);
    }

    @Override
    public double calcsalary() {
        double salary=8000;
    salary=salary*0.14;
    return salary;
    }
    

    @Override
    public String toString(){
    String Statment="  Name :  " + getName() + "  Age =  " + getAge() + "  ,Lives in   " + getAddress()+ "    salary  "+calcsalary();
return  Statment;
}

    
    
}
