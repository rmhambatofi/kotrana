package fr.manitra.kotrana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manitra on 30/10/16.
 */
public class Fibobacci {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            String[] tokens = line.split(",");
            Pattern p = Pattern.compile("[" + tokens[1].trim() + "]");
            Matcher m = p.matcher(tokens[0]);
            System.out.println(m.replaceAll(""));
            long[] l = fibonacci(6);
        }
    }

    private static long[] fibonacci(int n) {
        if (n <= 1) {
            return new long[]{n, 0};
        } else {
            long[] temp = fibonacci(n - 1);
            return new long[]{temp[0] + temp[1], temp[0]};
        }
    }
}
