package br.wtf.souza.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CsvUtils {

    private String filePath;
    private String line;
    private BufferedReader reader;

    /*
    * @p filePath - Path of the CSV file.
    * Load the csv class.
     */
    public void loadCSV(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        reader = new BufferedReader(new FileReader(filePath));
    }

}
