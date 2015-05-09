package main.java.instruction.SpecialInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;
import main.java.instruction.Instruction;

/**
 * Created by dianwen on 5/8/15.
 */
public class SyscallInstruction extends Instruction {
    public SyscallInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void getReady() {

    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {

    }
}
