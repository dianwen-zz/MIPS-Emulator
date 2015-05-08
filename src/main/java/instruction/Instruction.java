package main.java.instruction;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by dianwen on 5/7/15.
 */
abstract public class Instruction {

    public static final int INSTRUCTION_SIZE = 32;

    boolean executionReady;
    String instruction;
    int opCode;

    public Instruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        if(isValidInstruction(instruction)) {
            this.instruction = instruction;
            opCode = Integer.parseInt(instruction.substring(0, 6));
            executionReady = false;
        }
    }

    abstract public void getReady();

    protected void executeCheck() throws InstructionNotReadyException {
        if(!executionReady) {
            throw new InstructionNotReadyException();
        }
    }

    abstract public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException;

    private boolean isValidInstruction(String s) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        if(instruction.length() != 32) {
            throw new ImproperInstructionSizeException(instruction.length());
        }
        try {
            Integer.parseInt(instruction);
        }
        catch (Exception e){
            throw new ImproperInstructionValueException(instruction);
        }
        return true;
    }
}
