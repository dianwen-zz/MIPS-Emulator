package main.java.instruction.IInstructions;

import main.java.exceptions.ImproperInstructionSizeException;
import main.java.exceptions.ImproperInstructionValueException;
import main.java.instruction.Instruction;

/**
 * Created by dianwen on 5/8/15.
 */
abstract public class IInstruction extends Instruction {

    protected int registerS, registerT, immediate;

    public IInstruction(String instructionValue) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instructionValue);
    }

    public void getReady() {
        registerS = Integer.parseInt(instruction.substring(6, 11), 2);
        registerT = Integer.parseInt(instruction.substring(11, 16), 2);
        immediate = Integer.parseInt(instruction.substring(16, 32), 2);
        executionReady = true;
    }
}
