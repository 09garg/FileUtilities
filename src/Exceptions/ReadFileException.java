package Exceptions;

// Exceptions Class related to exceptions occurred while reading from File
public class ReadFileException extends RuntimeException{
    public ReadFileException(String message){
        super(message);
    }
}
