package com.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringCalculator {
	
	public static int Add(String numbers) {
        int sum = 0;
        List<Integer> pVeList = new ArrayList<Integer>();
        List<Integer> nVeList = new ArrayList<Integer>();
            if(null == numbers || numbers.isBlank()) return 0;
            String[] numberArr = numbers.split(",");
            for(String str : numberArr){
                try{
                    int num = Integer.parseInt(str);
                    if(num<0) nVeList.add(num);
                    else pVeList.add(num);
                }catch (Exception e){
                    System.out.println("The character is not a integer- "+str);
                }
            }
            if(!nVeList.isEmpty()) {
                StringJoiner nVeStr = new StringJoiner(",");
                for(Integer nVeValue : nVeList){
                    nVeStr.add(String.valueOf(nVeValue));
                }
                throw new IllegalArgumentException("negatives not allowed- "+ nVeStr);
            }
            for(Integer pVeNum : pVeList){
                sum += pVeNum;
            }
        return sum;
    }

}
