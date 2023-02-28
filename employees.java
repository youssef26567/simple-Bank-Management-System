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
public  abstract class employees {

    private final String name;
    private final int age;
    private final long code;
    private final String address;
   

    public employees(String name, int age, long code, String address) {
        this.name = name;
        this.age = age;
        this.code = code;
        this.address = address;
       
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public long getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }
    
    public  abstract double calcsalary();
        
    
    @Override
    public String toString(){
    String Statment="  Name :  " + name + "  Age =  " + age + "  ,Lives in   " + address;
return  Statment;
}

    void AddAppointment(Appointment p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void AddSession(Appointment s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
