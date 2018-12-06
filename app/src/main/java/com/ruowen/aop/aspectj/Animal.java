package com.ruowen.aop.aspectj;

import android.util.Log;

public class Animal {
    private static final String TAG = "zhengbin Animal";

    private int weight;

    static {
        Log.d(TAG, "animal static");
    }

    public Animal() {
        Log.d(TAG, this.toString() + ", animal new");
        this.weight = 50;
    }

    public String eat(String food) {
        Log.d(TAG, this.toString() + ", animal eat food=" + food);
        try {
            Thread.sleep(20);
        } catch (Exception e) {

        }

        return "aaa";
    }

    public void setWeight(int weight) {
        Log.d(TAG, this.toString() + ", animal setWeight");

        this.weight = weight;
    }

    public int getWeight() {
        Log.d(TAG, this.toString() + ", animal getWeight");
        return this.weight;
    }

    public int getMyWeight() {
        Log.d(TAG, this.toString() + ", animal getMyWeight");
        //return this.weight + 200;
        return this.weight;
    }

    public int hurt() {
        //return 4/0; //afterThrowing
        try {
            int i = 4 / 0;
            return i;
        } catch (ArithmeticException e) {
            Log.d(TAG, this.toString() + ", animal ArithmeticException");
            e.printStackTrace();
            return 0;
        }
    }
}
