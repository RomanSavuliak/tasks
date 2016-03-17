/**

 * CIS 2348, Prof. Zhang, Homework 2, SP 2016,

 * <Student Name>

 * <Student PSID> */
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ThesecondHW {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("input.txt"));
        String outputFile = "output.csv";

        String[] header;
        ArrayList<String> data = new ArrayList<>();

        if (inputFile.hasNextLine()) {
            header = inputFile.nextLine().split(", ");

            while (inputFile.hasNextLine()){
                data.add(inputFile.nextLine());
            }

            try {
                // use FileWriter constructor that specifies close for appending
                CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, false), ',');

                // write the header line
                    for (int i = 0; i < header.length; i++) {
                        csvOutput.write(header[i]);
                    }
                    csvOutput.endRecord();

                // write records

                for (int i = 0; i < data.size(); i++) {
                    String[] line = data.get(i).split(", ");
                    for (int j = 0; j < line.length; j++) {
                        csvOutput.write(line[j]);
                    }
                    csvOutput.endRecord();
                }

                csvOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
