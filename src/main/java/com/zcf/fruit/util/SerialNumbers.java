package com.microCredit.sms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
public class SerialNumbers {

    public  String getSerialNumber(){
        String serialNumber = "";
        String dateString  = this.dateString();
//        System.out.println(dateString);
        String numStr = randNum();
        serialNumber = "S00010"+dateString+numStr;
//        System.out.println(serialNumber);
        return serialNumber;
    }

    public String dateString(){
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHHmmssS");
        return myFmt.format(new Date());
    }

    public String randNum(){
        int[] numArr = {0,1,2,3,4,5,6,7,8,9};
        int index = 10;
        Random random = new Random();
        String numStr = "";
        for(int j=0;j<3;j++){
            int i = random.nextInt(index);
            numStr =numStr+ numArr[i];
        }

//        System.out.println(numStr);
        return numStr;
    }

    public static void main(String[] args){
        SerialNumbers serialNumbers = new SerialNumbers();
//        System.out.println(serialNumbers.getSerialNumber("001"));
        serialNumbers.getSerialNumber();
    }
}
