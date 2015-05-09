package main.java.instruction.IInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by dianwen on 5/8/15.
 */
public class AddiInstruction extends IInstruction {
    public AddiInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        super.executeCheck();

        int sum = s.getRegisterValue(registerS) + immediate;
        s.setRegisterValue(registerT, sum);

    }
}
