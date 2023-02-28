/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.hours;
import javax.swing.JOptionPane;

/**
 *
 * @author Youssef
 */
public final class Bankk extends Thread{

    private ArrayList<employees> employee;
    private ArrayList<customers> custmer;
    private ArrayList<Account> account;

    private final Owner owner;
    private final String name, address;
   

    public Bankk(Owner owner)  {
        this.owner = owner;
        name = "Hope";
        address = "Alexandria";
       
        try {

             setemployee();
          setcustmer();
            setaccount();
        } catch (IOException e) {
            System.err.println("Error Occured" + e.getMessage());
        }
    }

    private boolean AddHistory(long code) throws IOException { //creat file add add the employee history in it
        boolean added = false;
        File file;
        FileWriter writer = null;
        for (employees e : employee) {
            if (code == e.getCode()) {
                try {
                    file = new File("employee\\" + e.getName() + "-" + e.getCode() + ".txt");
                    writer = new FileWriter(file);
                    if (file.canWrite()) {
                        writer.append(e.toString()+e.calcsalary());
                        added = true;
                        break;
                    }
                } catch (IOException s) {
                    System.err.println("Error while writing");
                } finally {
                    writer.close();
                }
                break;
            }
        }
    return added;
    }
   
     
    private Boolean Addfile(long id) throws IOException{
        boolean add=false; 
        File folder;
        FileWriter fw=null;
        for(customers cu:custmer){
      
            if(id==cu.getId()){
        try{
            folder=new File("custmer"+cu.getName()+".txt");
            fw=new FileWriter(folder);
            if(folder.canWrite()){
                fw.append(cu.toString());
       
                add=true;
                break;
                
            }
        }
        catch(IOException s){
            
         System.err.println("Error while writing");
                } finally {
                    fw.close();
                }
                break;
        
    }
        }
     
        return add;
       
        
    }
    
    
    private void setemployee() throws IOException {
        employees p1 = new salared_employe("youssef", 21, 500, "alexandria");
        employees p2 = new salared_employe("mai", 22, 501, "alexandria");
        employees p3 = new hourly_employee("ahmed", 23, 502, "Alexandria", 240);
        employees p4 = new salared_employe("mazen", 24, 503, "alexandria");
        employees p5 = new hourly_employee("moustafa", 25, 504, "alexandria", 175);
        employee = new ArrayList() {

            {
                add(p1);
                add(p2);
                add(p3);
                add(p4);
                add(p5);
            }

        };

        AddHistory(p1.getCode());
        AddHistory(p2.getCode());
        AddHistory(p3.getCode());
        AddHistory(p4.getCode());
        AddHistory(p5.getCode());

    }

    public void AddEmployee(String name, int age, String Address, String type,int hours) throws IOException {
        long code;
        code = (employee.get(employee.size() - 1).getCode()) + 1;
        employees e = null;
        if (type.equalsIgnoreCase("salared")) {
            e = new salared_employe(name, age, code, Address);
        } else if (type.equalsIgnoreCase("hourly")) {
            e = new hourly_employee(name, age, code, Address, hours);
        }
        AddEmployee(e);
        AddHistory(code);
    }

    private void AddEmployee(employees e) {
        employee.add(e);
    }
    
    
    
    

    public void Addcustmer(String name, int age, String Address, String type,long id) throws IOException {
        
       customers c=null;
        if (type.equalsIgnoreCase("clasic")) {
           c=new clasic(name, age, id, Address);
            Addaccount(id);
            Addfile(id);
          
        } else if (type.equalsIgnoreCase("vip")) {
            c = new vip(name, age, id, Address);
           Addaccount(id);
        }
        Addcustmer(c);
        Addfile(id);
    }
    
    private void Addcustmer(customers c) {
        custmer.add(c);

    }

    private void Addaccount(long id ) throws IOException {

        Account a=null;
       a=new Account((long) id, 0);
        Addaccount(a);
        AddHistory(id);
      
    }
    
    private void Addaccount(Account a) {
        account.add(a);

    }

    public void employeeSalary(long id) { //to calculate the salary of employee by its id
        double salary = 0;
        for (employees d : employee) {
            if (id == d.getCode()) {
                if (d instanceof salared_employe) {
                    System.out.println("Salary is $" + d.calcsalary());
                    break;
                } else {
                    if (d instanceof hourly_employee) {
                        System.out.println("Salary is $" + d.calcsalary());
                        break;
                    }
                }
            }
        }

    }

    public void employeelist() {
        employee.stream().forEach((emp) -> {
            if (emp instanceof salared_employe) {
                System.out.println(" name  " + emp.getName() + "   " + "id  " + emp.getCode() + "    age    " + emp.getAge());
            } else if (emp instanceof hourly_employee) {
                System.out.println(" name  " + emp.getName() + "   " + "id  " + emp.getCode() + "    age    " + emp.getAge());
            }
        });

    }

    public void setcustmer() throws IOException {
        customers c1 = new vip("youssef", 56, 20211, "cario");
        customers c2 = new clasic("aymen", 75, 30211, "cario");
        customers c3 = new vip("mansour", 51, 40211, "cario");
        customers c4 = new clasic("doha", 26, 50211, "cario");

        custmer = new ArrayList() {

            {
                add(c1);
                add(c2);
                add(c3);
                add(c4);
            }
        };
        
        Addfile(c1.getId());
        Addfile(c2.getId());
        Addfile(c3.getId());
        Addfile(c4.getId());
    }
//
    public void setaccount() throws IOException {
        Account a1 = new Account(20211, 20);
        Account a2 = new Account(30211, 60);
        Account a3 = new Account(40211, 80);
        Account a4 = new Account(50211, 1000);
     

        account = new ArrayList() {

            {
                add(a1);
                add(a2);
                add(a3);
                add(a4);
            }
        }; 
        AddHistory(a1.getAccountnum());
        AddHistory(a3.getAccountnum());
    }

    
    public void accountinfo(int id) {  // give specific account by its id 
        for (Account a : account) {
            for (customers c : custmer) {
                if (id == a.getAccountnum()&&(id == c.getId())) {
                
                 //   System.out.println(a.getBalance()+" $");

                    System.out.println(" name  " + c.getName() + "   " + "id  " + c.getId() + "    age    " + c.getAge() + "    Balance " + a.getBalance() + "$" +"  Account number is "+a.num());

                    break;
                }
            }
//    
//        else 
//        
//                System.err.println("invalid id");
        }
    }

    public void transition(int id1, int id2, float amount) {
        for (Account a : account) {
            if (id1 == a.getAccountnum()) {
                if(a.getBalance() - amount<0){
                    System.err.println("there is no enough money to transfer ");
                    break;
                }
                else{
                a.Balance = a.getBalance() - amount;  
                a.privouse_transition=(int) (a.getPrivouse_transition()-amount);
            if (id2 == a.getAccountnum()) {
                a.Balance = a.getBalance() + amount;
      a.privouse_transition=(int) (a.getPrivouse_transition()+amount);
            }

        }
        
        }
    }
    }
    public void addmoney(int id, float money) {
        for (Account a : account) {
            if (id == a.getAccountnum()) {
                a.Balance = a.getBalance() + money;
                System.out.println("Done !");
                  a.privouse_transition=(int) (a.getPrivouse_transition()+money);
            }
        }
    }

    public void withdraw_money(int id, float money) {  
        for (Account a : account) {
            if (id == a.getAccountnum()) {
                a.Balance = a.getBalance() - money;
                System.out.println("Done !");
                  a.privouse_transition=(int) (a.getPrivouse_transition()-money);
            }
        }
    }

    public void custmerlist() {
        
        custmer.stream().forEach((emp) -> {
            if (emp instanceof vip) {
                System.out.println(" name  " + emp.getName() + "   " + "id  " + emp.getId() + "    age    " + emp.getAge() + "   ");

            } else if (emp instanceof clasic) {
                System.out.println(" name  " + emp.getName() + "   " + "id  " + emp.getId() + "    age    " + emp.getAge());
            }
        });

    }

    public void accounts_details() {  //show all detalis of custmers and their accounts
         for(int i=0;i<=0;i++){
        for (Account a : account) {
            for (customers c : custmer) {
                if (a.getAccountnum() == c.getId()) {
                   
                    System.out.println(" name  " + c.getName() + "   " + "id  " + c.getId() + "    age    " + c.getAge() + "    Balance " + a.getBalance() + "$"+"  Account number is  "+a.num());
                       try {
                 sleep(1000);
                
             } catch (InterruptedException ex) {
                
                    }
                
                }

            }

        }

    }
    }
    
    
    private double x;                                             // x is the amount of bank rate  in year
    public  void calc_invesment( int id ,int Years){
         for (Account a : account) {
            if(Years==1){
                 x= 0.14;
            }
            else
                if(Years==2){
                x= 0.18;    
                }
             else
                if(Years==3){
                 x= 0.20;    
                }
                if (a.getAccountnum() == id) {
                  a.Balance=((float) (a.getBalance()*x*Years)+a.getBalance());
                    System.out.println("your money will be  "+a.Balance+"$");
                
                
                }
                
         }
                    
                    
                }
   
//    
//    public boolean bookAppointment(String CName, int age, String add, String type, String EName) {
//        boolean booked = false;
//        DateTimeFormatter dtf;
//        LocalDate now, SessionDate;
//        String date = null;
//        Appointment p = null;
//        try {
//            dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            now = LocalDate.now();
//            SessionDate = now.plusDays(7);
//            date = dtf.format(SessionDate);
//            p = new Appointment(date);
//            for (employees d : employee) {
//                if (EName.equalsIgnoreCase(d.getName())) {
//                    Addcustmer(name, age, address, type, age);
//                    d.AddSession(p);
//                    for (customers c : custmer) {
//                        if (CName.equalsIgnoreCase(c.getName())) {
//                            addSession(c.getId(), p);
//                            booked = true;
//                            break;
//                        }
//                    }
//                }
//                break;
//            }
//        } catch (IOException ex) {
//            System.err.println("Error  Occured");
//            booked = false;
//        } catch (ParseException e) {
//            System.err.println("Error Occured");
//            booked = false;
//        } catch (NullPointerException e) {
//            System.err.println("An UnExpected Error Occured");
//            booked = false;
//        }
//     if (!booked) {
//            JOptionPane.showMessageDialog(null, "Hello Mr/Mrs  "+CName+":"+ "\n  the Appointment has been booked!\n it will be on " + date +"with "+EName+"    ", "Booked Succesfully", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "An Error Occured", "Please Try Again!", JOptionPane.ERROR_MESSAGE);
//        }
//       return booked;
//    }
//
//    private void addSession(long id, Appointment p) {
//    for (customers c : custmer) {
//            if (id == c.getId()) {
//                c.bookAppointment(p);
//                break;
//            }
//        }
//    
//    }

    public  void take_loan(long id,double money,int Years){    // x is the amount of bank rate  in year
        
         for (Account a : account) {
               for (customers c : custmer) {
            if(Years==1){
                 x= 0.18;
            }
            else
                if(Years==2){
                x= 0.20;    
                }
             else
                if(Years==3){
                 x= 0.25;    
                }
                if (a.getAccountnum() == id&&c.getId()==id) {
                  a.Balance=(float) (((float) (money*x*Years)+money))+a.getBalance();
                   
            JOptionPane.showMessageDialog(null, "Hello Mr/Mrs  "+c.getName()+":"+ " \n  The loan is under review  \n it will be Right soon \n the Bank investment is: "+(((float) (money*x*Years)+money))+" in "+Years+" Years \n so you will pay in month"+(a.Balance/(Years*12))+" Dollar", "the loan is Booked Succesfully", JOptionPane.INFORMATION_MESSAGE);
        
                
                }
                
         }
                    
    }
    }
    
    
    

    }


