package db;

import com.opencsv.CSVReader;

import java.io.*;
import java.sql.Connection;
import java.util.*;

public class CSVParser {
    public static void main(String[] args) {

        Connection conn = ConnectionDB.getConnection();
        CreationDB.createDB(conn);

        List<List<String>> records = new ArrayList<>();

        /*String fileName = "sample_data.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader("sample_data.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> row = Arrays.asList(values);
                if (row.get(10).equals("1.00") || row.get(12).equals("1.00")) {
                    records.add(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("oko");
        Collections.shuffle(records);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dane.csv"))) {
            for (int i = 0; i < 10000; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < 5; j++) {
                    stringBuilder.append(records.get(i).get(j));
                    stringBuilder.append(",");
                }
                for (int j = 5; j < 9; j++) {
                    stringBuilder.append("\"").append(records.get(i).get(j)).append("\"");
                    stringBuilder.append(",");
                }
                for (int j = 9; j < 14; j++) {
                    stringBuilder.append(records.get(i).get(j));
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(records.get(i).get(14)).append("\"").append(",");
                for (int j = 15; j < 22; j++) {
                    stringBuilder.append(records.get(i).get(j));
                    stringBuilder.append(",");
                }
                bufferedWriter.write(stringBuilder.toString() + "\n");
            }
        } catch (IOException ignored) {
        }*/


        records = new ArrayList<>();
        try (
                CSVReader csvReader = new CSVReader(new FileReader("dane.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> row = Arrays.asList(values);
                records.add(row);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(records.size());

        InsertionDB ins = InsertionDB.getInstance();


        if (ins.insertDB(conn, records)) {
            System.out.println("YAAS");
        } else {
            System.out.println("NOPE");
        }
    }

}

