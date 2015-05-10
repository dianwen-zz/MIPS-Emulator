package main.java.instruction;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by dianwen on 5/7/15.
 */
abstract public class Instruction {

    public static final int INSTRUCTION_SIZE = 32;

    protected boolean executionReady;
    protected String instruction;

    public Instruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        if(isValidInstruction(instruction)) {
            this.instruction = instruction;
            executionReady = false;
        }
    }

    abstract public void getReady();

    protected void executeCheck() throws InstructionNotReadyException {
        if(!executionReady) {
            throw new InstructionNotReadyException();
        }
    }

    abstract public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException, InvalidMemoryAccessException;

    private boolean isValidInstruction(String s) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        if(s.length() != 32) {
            throw new ImproperInstructionSizeException(s.length());
        }
        /*try {
            Integer.parseInt(s,2);
        }
        catch (Exception e){
            throw new ImproperInstructionValueException(s);
        }*/
        return true;
    }
}
