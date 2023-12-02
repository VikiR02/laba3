package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("Method       Size    ArrayList_Time    LinkedList_Time");
        Time();
    }

    public static void Time() {
        ArrayList_ arrayList = new ArrayList_();
        LinkedList_ linkedList = new LinkedList_();
        long startTime = System.nanoTime();
        for (int j = 0; j < 1000; j++) arrayList.add(j);
        long estimatedTime = System.nanoTime() - startTime;

        long startTime1 = System.nanoTime();
        for (int j = 0; j < 1000; j++) linkedList.add(j);
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("ADD          " + 1000 + "    " + estimatedTime + "           " + estimatedTime1);

        long startTime2 = System.nanoTime();
        for (int j = 0; j < 1000; j++) arrayList.get(j);
        long estimatedTime2 = System.nanoTime() - startTime2;

        long startTime3 = System.nanoTime();
        for (int j = 0; j < 1000; j++) linkedList.get(j);
        long estimatedTime3 = System.nanoTime() - startTime3;
        System.out.println("GET          " + 1000 + "    " + estimatedTime2 + "          " + estimatedTime3);

        long startTime6 = System.nanoTime();
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        for (int j = 0; j < 1000; j++) {
            arrayList.add(j,randomNumber);
            randomNumber = random.nextInt(1000);}
        long estimatedTime6 = System.nanoTime() - startTime6;

        long startTime7 = System.nanoTime();
        randomNumber = random.nextInt(1000);
        for (int j = 0; j < 1000; j++) {
            linkedList.add(j,randomNumber);
            randomNumber = random.nextInt(1000);}
        long estimatedTime7 = System.nanoTime() - startTime7;
        System.out.println("Add_Middle  " + 1000 + "    " + estimatedTime6 + "          " + estimatedTime7);

        long startTime4 = System.nanoTime();
        for (int j = 0; j < 2000; j++) arrayList.remove(j);
        long estimatedTime4 = System.nanoTime() - startTime4;

        long startTime5 = System.nanoTime();
        for (int j = 0; j < 2000; j++) linkedList.remove(j);
        long estimatedTime5 = System.nanoTime() - startTime5;
        System.out.println("REMOVE      " + 2000 + "    " + estimatedTime4 + "          " + estimatedTime5);


    }
}