package com.back.global;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ut {

    public static String getFormattedDate(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = localDateTime.format(formatter);

        return formattedDate;
    }
}
