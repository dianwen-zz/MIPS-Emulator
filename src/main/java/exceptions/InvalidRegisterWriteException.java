package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class InvalidRegisterWriteException extends Throwable {
    int registerNumber, writeValue;
    public InvalidRegisterWriteException(int registerNumber, int value) {
        this.registerNumber = registerNumber;
        this.writeValue = value;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public int getWriteValue() {
        return writeValue;
    }
}
