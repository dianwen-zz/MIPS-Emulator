package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class OpCodeNotFoundException extends Exception {
    private String opCode;

    public OpCodeNotFoundException(String opCode) {
        this.opCode = opCode;
    }

    public String getOpCode() {
        return opCode;
    }
}
