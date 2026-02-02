package filehandling;

import java.io.*;

public class FileHandlingDemo {

    // 1️⃣ Writing using FileWriter (Character Stream)
    static void writeUsingFileWriter(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Hello from FileWriter\n");
        writer.write("This is character stream");
        writer.close();
        System.out.println("File written using FileWriter");
    }

    // 2️⃣ Reading using FileReader (Character Stream)
    static void readUsingFileReader(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        int ch;

        System.out.println("Reading using FileReader:");
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }
        reader.close();
        System.out.println("\n");
    }

    // 3️⃣ Writing using FileOutputStream (Byte Stream)
    static void writeUsingFileOutputStream(String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        String data = "Hello from FileOutputStream\nThis is byte stream";

        fos.write(data.getBytes()); // convert String → bytes
        fos.close();
        System.out.println("File written using FileOutputStream");
    }

    // 4️⃣ Reading using FileInputStream (Byte Stream)
    static void readUsingFileInputStream(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        int b;

        System.out.println("Reading using FileInputStream:");
        while ((b = fis.read()) != -1) {
            System.out.print((char) b); // manual byte → char conversion
        }
        fis.close();
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException {

        String charFile = "charStream.txt";
        String byteFile = "byteStream.txt";

        // Character stream
        writeUsingFileWriter(charFile);
        readUsingFileReader(charFile);

        // Byte stream
        writeUsingFileOutputStream(byteFile);
        readUsingFileInputStream(byteFile);
    }
}

