/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Ammar
 */
public class DateTimeUtil {
    public static Date updateTime(Date date, String time) {
        try {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = sdf.format(date);

            strDate = strDate + " " + time;

            sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

