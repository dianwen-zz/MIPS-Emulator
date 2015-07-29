package main.java.instruction.SpecialInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by Kevin on 7/28/2015.
 */
public class printFloatSyscall extends SyscallInstruction{
    public printFloatSyscall(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    public static void run(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        int argumentValue = s.getRegisterValue(4);
        System.out.println(argumentValue);
    }
}
