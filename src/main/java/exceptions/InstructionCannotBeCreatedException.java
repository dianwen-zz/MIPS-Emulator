package main.java.exceptions;

/**
 * Created by dianwen on 5/8/15.
 */
public class InstructionCannotBeCreatedException extends Exception {
    private String instructionValue;

    public InstructionCannotBeCreatedException(String instructionValue) {
        this.instructionValue = instructionValue;
    }

    public String getInstructionValue() {
        return instructionValue;
    }
}
