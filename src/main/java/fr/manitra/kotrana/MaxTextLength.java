package fr.manitra.kotrana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by manitra on 30/10/2016.
 */
public class MaxTextLength {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(buffer.readLine());
        LineEntry[] entries = new LineEntry[n];
        String line;
        int nbEntries = 0;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            LineEntry entry = new LineEntry(line, line.length());
            if (nbEntries < entries.length || entry.getSize() > entries[nbEntries - 1].getSize()) {
                if (nbEntries < entries.length) {
                    nbEntries++;
                }
                int j = nbEntries - 1;
                while (j > 0 && entries[j - 1].getSize() < entry.getSize()) {
                    entries[j] = entries[j - 1];
                    j--;
                }
                entries[j] = entry;
            }
        }

        Stream.of(entries).forEach(lineEntry -> System.out.println(lineEntry.getText()));
    }

    private static class LineEntry {
        private String text;
        private int size;

        public LineEntry(String text, int size) {
            this.text = text;
            this.size = size;
        }

        public String getText() {
            return text;
        }

        public int getSize() {
            return size;
        }
    }
}
