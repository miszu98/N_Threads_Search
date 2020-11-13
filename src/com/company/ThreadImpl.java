package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThreadImpl extends Thread{

    List<String> data;
    int id;
    double minSalary = 100000;
    int[] intervals;
    List<String> resultFromThreads = new ArrayList<>();

    public ThreadImpl(List<String> data, int[] intervals) {
        this.data = data;
        this.intervals = intervals;
    }

    @Override
    public void run() {
        long startTimer = System.currentTimeMillis();
        for (int i=intervals[0]; i<intervals[1]; i++) {
            //System.out.println("Przedzial: " + intervals[0] + ":" + intervals[1] + " element: " + i);
            if ((Double.parseDouble(data.get(i).split(";")[1])) < minSalary) {
                id = Integer.parseInt(data.get(i).split(";")[0]);
                minSalary = Double.parseDouble(data.get(i).split(";")[1]);
            }
        }
        long stopTimer = System.currentTimeMillis() - startTimer;
        resultFromThreads.add(id + ";" + minSalary);
        System.out.println(resultFromThreads + " Z przedzialu: " + intervals[0] + ":" + intervals[1] + "| CZAS WYKONANIA: " + new DecimalFormat("##.###").format(stopTimer * 0.001) + "|");
    }

}
