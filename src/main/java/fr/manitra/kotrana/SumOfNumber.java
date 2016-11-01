package fr.manitra.kotrana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by manitra on 30/10/16.
 */
public class SumOfNumber {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char[] digits = line.toCharArray();
            int sum = 0;
            for (int i = 0; i < digits.length; i++) {
                sum = sum + Integer.parseInt(String.valueOf(digits[i]));
            }
            System.out.println(sum);
        }
    }
}
