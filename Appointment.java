/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Youssef
 */
class Appointment {
       private final String date;
  
    private final Date dateF;

    protected Appointment( String date) throws ParseException {
        
        this.date = date;
        dateF = new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }


    public String getDate() {
        return dateF.toLocaleString();
    }

}
