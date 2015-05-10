package main.java.instruction.RInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by Kevin on 5/9/2015.
 */
public class SubInstruction extends RInstruction {
    public SubInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        super.executeCheck();

        int sum = s.getRegisterValue(registerS) - s.getRegisterValue(registerT);
        s.setRegisterValue(registerD, sum);

    }
}
