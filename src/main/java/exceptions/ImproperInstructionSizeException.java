package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class ImproperInstructionSizeException extends Exception {
    private int instructionSize;

    public ImproperInstructionSizeException(int instructionSize) {
        this.instructionSize = instructionSize;
    }

    public int getInstructionSize() {
        return instructionSize;
    }
}
