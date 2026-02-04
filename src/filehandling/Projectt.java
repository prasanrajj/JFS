package filehandling;

import java.io.*;

public class Projectt {

    static final String BASE_PATH = "C:\\Users\\Prasanna\\Desktop\\Project";
    static final String MASTER_FILE = BASE_PATH + "\\file.txt";

    public static void main(String[] args) throws IOException {

        setup();
        processFolders(2, 10); // 2 folders, 10 files each
    }

    // ---------------- SETUP ----------------

    static void setup() throws IOException {
        createMainFolder();
        createMasterFile();

        for (int i = 1; i <= 2; i++) {
            createSubFolder(i);
        }
    }

    // ---------------- PROCESS ----------------

    static void processFolders(int folderCount, int filesPerFolder) throws IOException {

        for (int folder = 1; folder <= folderCount; folder++) {
            for (int file = 1; file <= filesPerFolder; file++) {
                copyFile(folder, file);
            }
        }
    }

    // ---------------- UTILITIES ----------------

    static void createMainFolder() {
        new File(BASE_PATH).mkdirs();
    }

    static void createSubFolder(int number) {
        new File(BASE_PATH + "\\folder_" + number).mkdirs();
    }

    static void createMasterFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(MASTER_FILE)) {
            fos.write("This is the master file".getBytes());
        }
    }

    static void copyFile(int folderNumber, int fileNumber) throws IOException {

        String targetPath =
                BASE_PATH +
                "\\folder_" + folderNumber +
                "\\file_" + fileNumber + ".txt";

        try (
            FileInputStream fis = new FileInputStream(MASTER_FILE);
            FileOutputStream fos = new FileOutputStream(targetPath, true)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fos.write((", copied to file_" + fileNumber).getBytes());
        }
    }
}

