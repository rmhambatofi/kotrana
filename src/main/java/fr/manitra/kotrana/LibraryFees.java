package fr.manitra.kotrana;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * Created by manitra on 30/10/16.
 */
public class LibraryFees {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.nextLine();
        String expected = scanner.nextLine();
        scanner.close();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d M yyyy");
        LocalDate retDate = LocalDate.parse(ret.trim(), f);
        LocalDate expectedDate = LocalDate.parse(expected.trim(), f);
        int fee = 0;
        if (retDate.isAfter(expectedDate)) {
            if (retDate.getYear() != expectedDate.getYear()) {
                fee = 10000;
            } else if (retDate.getMonthValue() != expectedDate.getMonthValue()) {
                fee = 500 * (retDate.get(ChronoField.MONTH_OF_YEAR) - expectedDate.get(ChronoField.MONTH_OF_YEAR));
            } else {
                fee = 15 * (retDate.get(ChronoField.DAY_OF_MONTH) - expectedDate.get(ChronoField.DAY_OF_MONTH));
            }
        }
        System.out.println(fee);
    }
}
