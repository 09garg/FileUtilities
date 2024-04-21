package Exceptions;

// Exceptions Class related to exceptions occurred while writing To File
public class WriteFileException extends RuntimeException{
    public WriteFileException(String message){
        super(message);
    }
}
