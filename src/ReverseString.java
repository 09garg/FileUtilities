import Exceptions.ReadFileException;
import Exceptions.WriteFileException;

import java.io.*;

//This class is responsible for  - Read an ascii input file, reverse the contents and write the reversed contents to an output file.
//This utility will successfully run if the file size <= RAM
// If fileSize >= RAM , we will face out of Memory Error ,and we need to
// 1. break file into small parts
// 2. Get a string
// 3. Reverse a string
// 4. Write to the multiple files
public class ReverseString {
    private static final String inputFileLocation = "resources/InputFile.txt";
    private static final String outputFileLocation = "resources/OutputFile.txt";

    // Method to read from file
    // returns StringBuilder
    protected static StringBuilder readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileLocation))) {
            int iLine = 0;
            String line;
            StringBuilder inputString = new StringBuilder();
            while ((line = br.readLine()) != null) {
                inputString.append(line).append("\n");
                iLine++;
            }
            return inputString;
        } catch( IOException ex ){
            throw new ReadFileException(ex.getMessage());
        }
    }

    // Method to write to file
    // arguments - String
    protected static void writeFile(String inputString) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileLocation))) {
            bw.write(inputString);
        } catch( IOException ex ){
            throw new WriteFileException(ex.getMessage());
        }
    }

    protected static StringBuilder reverseString(StringBuilder inputString) {
        return inputString.reverse();
    }

    public static void main(String[] args) {
        try {
            //reading the file
            System.out.println("Reading the File");
            StringBuilder inputString  = readFile();

            System.out.println("Input String: " + inputString);

            //reverse the input String
            StringBuilder reverseString = reverseString(inputString);

            System.out.println("Reverse String: " + reverseString);

            //writing reverse String to a file
            writeFile(reverseString.toString());


        } catch(Exception ex) {
           if (ex instanceof WriteFileException) {
               System.out.println("Exception occurred while writing to file. " + ex);
           }
           else if (ex instanceof ReadFileException) {
                System.out.println("Exception occurred while reading file. " + ex);
           } else {
               System.out.println("Exception occurred " + ex);
           }
        }

    }
}