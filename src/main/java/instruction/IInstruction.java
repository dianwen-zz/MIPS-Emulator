package main.java.instruction;

import main.java.exceptions.ImproperInstructionSizeException;
import main.java.exceptions.ImproperInstructionValueException;

/**
 * Created by dianwen on 5/8/15.
 */
abstract public class IInstruction extends Instruction{

    protected int registerS, registerT, immediate;

    public IInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    public void getReady() {
        registerS = Integer.parseInt(instruction.substring(6, 11), 2);
        registerT = Integer.parseInt(instruction.substring(11, 16), 2);
        immediate = Integer.parseInt(instruction.substring(16, 32), 2);
        executionReady = true;
    }
}
