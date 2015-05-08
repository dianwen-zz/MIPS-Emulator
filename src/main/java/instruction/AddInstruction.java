package main.java.instruction;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by dianwen on 5/8/15.
 */
public class AddInstruction extends RInstruction {
    public AddInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        super.executeCheck();

        int sum = s.getRegisterValue(registerS) + s.getRegisterValue(registerT);
        s.setRegisterValue(registerD, sum);
    }

}
