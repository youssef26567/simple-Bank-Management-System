/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Scanner;

/**
 *
 * @author Youssef
 */
public class Owner {
    
    private final String name, gender, address, BirthDate;
    private final int age;

    public Owner() {
        this.name = "youssef";
        this.age = 60;
        this.gender = "male";
        this.address = "Cairo";
        this.BirthDate = "12/1/1994";
    }

    @Override
    public String toString() {
        String statement;
        if (Login()) {
            statement = "The Owner's Name is " + name + " She is " + age + "\nLives in " + address + "\nBorn In " + BirthDate;
        } else {
            statement = "You Don't have the permisson to access this information";
        }
        return statement;
    }

    private boolean Login() {
        Scanner sc = new Scanner(System.in);
        String userName, Password;
        System.out.println("Enter the Username");
        userName = sc.nextLine();
        System.out.println("Enter the Password");
        Password = sc.nextLine();
        return userName.equals("Admin") && Password.equals("Admin");
    }
}
