package com.sanefox.webapp.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by aslisicin on 19.06.2018.
 */
public class DateUtil {
    public static LocalDate of(int year, Month month){
       return LocalDate.of(year, month, 1);
    }
}
