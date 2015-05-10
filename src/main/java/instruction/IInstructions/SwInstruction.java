package main.java.instruction.IInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by Kevin on 5/10/2015.
 */
public class SwInstruction extends IInstruction {
    public SwInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException, InvalidMemoryAccessException {
        super.executeCheck();

        int memAddress = s.getRegisterValue(registerS) + immediate;
        int memData = s.getRegisterValue(registerT);
        s.setMemoryValue(memAddress / 4, memData);

    }
}
