import java.io.*;
import java.util.Scanner;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
        }
    }

    public String readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void replaceInFile(String text) throws IOException {
        writeToFile(text);
    }

    public void appendToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text);
            writer.newLine();
        }
    }
}
