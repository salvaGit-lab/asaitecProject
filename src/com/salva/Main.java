package com.salva;


import com.salva.manager.FileManager;

public class Main {

    /**
     * Main with file to process (fisrt argument)
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Processing of people's data..." + args[0]);
        FileManager.getInstance().processFile(args[0]);

        System.out.println("Computing stats...");
        FileManager.StatisticalComputer.getInstance().showResults();

    }

}
