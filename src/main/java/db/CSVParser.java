package db;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) {
        ConnectionDB.getConnection();
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader("sample_data.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                List<String> row = Arrays.asList(values);
                if(!row.get(10).equals("1.00")) {
                    records.add(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(records.size());
        System.out.println("oko");
    }
}
