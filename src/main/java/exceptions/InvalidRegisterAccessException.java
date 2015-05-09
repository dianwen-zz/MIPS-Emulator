package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class InvalidRegisterAccessException extends Exception {
    private int registerNumber;

    public InvalidRegisterAccessException(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }
}
