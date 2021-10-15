package br.wtf.souza.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvUtils {

    private String line;
    private static BufferedReader reader;
    private String row[];


    /*
     * @p filePath - Path of the CSV file.
     * Load the csv class.
     */
    public static void loadCSV(String filePath) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filePath));
    }


    public String[] readCSV() throws IOException {
        try {
            while ((line = reader.readLine()) != null) {
                row = line.split(",");
            }
            return row;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            reader.close();
        }
    }

}
