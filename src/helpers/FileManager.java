package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    private File file;

    public FileManager(int year, int day) {

        String path;

        String d = Integer.toString(day);
        if (d.length() == 1) {
            d = "0" + d;
        }

        path = "src/year" + year + "/inputs/day" + d + ".in";

        this.file = new File(path);
    }

    public FileManager() {}

    public Scanner generateScanner() {
        Scanner myReader;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return myReader;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
