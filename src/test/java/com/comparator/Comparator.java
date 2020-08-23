package com.comparator;

public class Comparator {


    public static boolean compareTemperatures(Double temp1, Double temp2){

        boolean tempMatches = false;
        double tempDiff = temp1 - temp2;

        System.out.println(tempDiff);

        if((tempDiff>=0 && tempDiff<=3) || (tempDiff<=0 && tempDiff>=-3)){
            tempMatches = true;
        }

        return tempMatches;
    }

}
