package main.java.instruction.IInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by Kevin on 5/9/2015.
 */
public class LwInstruction extends IInstruction {
    public LwInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException, InvalidMemoryAccessException {
        super.executeCheck();

        int memAddress = s.getRegisterValue(registerS) + immediate;
        int memData = s.getMemoryValue(memAddress / 4);
        s.setRegisterValue(registerT, memData);

    }
}


