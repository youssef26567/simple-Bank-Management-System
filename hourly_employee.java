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
public class hourly_employee  extends employees{
    private int hours;
    public hourly_employee(String name, int age, long code, String address,int hours) {
        super(name, age, code, address);
        this.hours=hours;
    }

    @Override
    public double calcsalary() {
Double    salary_per_hour=85.0;
    double salary=salary_per_hour*hours*0.14;
    
    return salary ;
    }
      
    @Override
    public String toString(){
    String Statment="  Name :  " + getName() + "  Age =  " + getAge() + "  ,Lives in   " + getAddress()+ "    salary  "+calcsalary();
return  Statment;
}

    
}
