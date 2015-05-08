package main.java.exceptions;

/**
 * Created by dianwen on 5/7/15.
 */
public class ImproperInstructionValueException extends Throwable {
    String instruction;

    public ImproperInstructionValueException(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
