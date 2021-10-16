package br.wtf.souza.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    /*
    * Get row by row and return it into a List
     */
    public List<String[]> readCSV() throws IOException {
        List<String[]> rows;
        rows = new ArrayList<String[]>();
        try {
            while ((line = reader.readLine()) != null) {
                row = line.split(";");
                for (int i = 0; i < row.length; i++) {
                    if ((i + 1) % 4 == 0) {
                        rows.add(row);
                    }
                }
            }
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        } finally {
            reader.close();
        }
    }

}
