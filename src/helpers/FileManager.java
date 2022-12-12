package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    /** The file to read. */
    private final File file;

    public FileManager(int year, int day) {
        this.file = getFile(year, day);
    }

    /**
     * Finds the input file using the day (1-25) and the year.
     *
     * @param year the year of the problem
     * @param day the problem day (1-25)
     * @return the input file
     */
    private File getFile(int year, int day) {
        String filePath;

        String d = Integer.toString(day);
        if (d.length() == 1) {
            d = "0" + d;
        }

        filePath = "src/year" + year + "/inputs/day" + d + ".in";

        return new File(filePath);
    }

    /**
     * Generate a Scanner object to read the file.
     *
     * @return the scanner.
     */
    public Scanner generateScanner() {
        Scanner myReader;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return myReader;
    }
}
