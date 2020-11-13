package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        loadFile();
        useThreadToFindMin(5);
    }

    public static void loadFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\micha\\IdeaProjects\\N_Threads_Search\\src\\com\\company\\dane.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            data.add(line);
            line = bufferedReader.readLine();
        }
    }

    public static int[] getIntevals(int k) {
        int partition = 1_000_000 / k;

        int savedPart = partition;
        int[] interval = new int[k + 1];

        int i = 0;
        int x = 1;
        while (i < k) {
            if (partition <= 1000000) {
                interval[x] = partition;
                partition += savedPart;
                x++;
            }
            i++;
        }
        return interval;
    }

    public static void useThreadToFindMin(int k) {
        for (int i = 0; i < getIntevals(k).length - 1; i++) {
            ThreadImpl threadImpl = new ThreadImpl(data, new int[]{getIntevals(k)[i], getIntevals(k)[i + 1]});
            threadImpl.start();
        }
    }
}


