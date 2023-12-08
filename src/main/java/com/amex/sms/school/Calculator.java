package com.amex.sms.school;


/**
 * @author Mayukha
 * Created on 07 Nov, 2023
 * @project school
 */
public class Calculator {

    public int add(int a, int b){
        if(a<0){
            a=Math.abs(a);

        }
        if(b<0){
            b=Math.abs(b);

        }
        return a+b;
    }

    public int sub(int a, int b){
        if(a<b){
            throw new RuntimeException("a cannot be less than b");
        }
        return a-b;
    }

    public int product(int a, int b){
        int c = a*b;
        if(c<0){
            return Math.abs(c);
        }
        return c;
    }

    public double divide(int a, int b){
        if(b==0){
            throw new RuntimeException("Cannot divide by 0");
        }
        if(a<b){
            throw new RuntimeException("a cannot be less than b");
        }
        return a/b;
    }


}
