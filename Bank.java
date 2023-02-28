/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;

/**
 *
 * @author Youssef
 */
public class Bank {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Owner owner = new Owner();
        Bankk b = new Bankk(owner);

        //  b.employeeSalary(501);
          b.AddEmployee("monir", 22, "alex", "Salared", 0);
        b.AddEmployee("monir", 22, "alex", "hourly", 60);
          b.Addcustmer("mousa",28,"alex","vip",60211);
           b.Addcustmer("maged",35,"alex","vip",70211);
       //   b.Addcustmer("mafed",35,"alex","vip",70000211);
         // b.Addcustmer("nour", 45, "asute", "clasic", 529161);
    //   b.employeelist();
        // b.employeelist();
//         b.custmerlist();
       // b.bookAppointment("mousa", 25, "dd", "vip", "monir");
        b.accountinfo(50211);
        //  b.addmoney(30211, 1000);
         //b.accountinfo(30211);
        //b.accountinfo(30211);
          // b.transition(50211, 60211, 500);

 //b.employeeSalary(501);
 

     //  b.withdraw_money(30211, 50);
        //   b.addmoney(30211, 30);
       
//       b.accounts_details();
//         b.accountinfo(20211);
    // b.calc_invesment(20211, 2);
  
 
  // b.accounts_details();
  // b.accountinfo(20211);
   // b.transition(30211, 20211, 500);
   
  b.take_loan(20211, 5000, 2);
 // b.accountinfo(20211);
   //  b.accountinfo(30211);
   
//             
           
                     
                     
     

    }

}
