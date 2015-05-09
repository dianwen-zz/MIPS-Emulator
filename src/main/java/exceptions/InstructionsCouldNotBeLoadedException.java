package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class InstructionsCouldNotBeLoadedException extends Exception {
    String fileName;

    public InstructionsCouldNotBeLoadedException(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
