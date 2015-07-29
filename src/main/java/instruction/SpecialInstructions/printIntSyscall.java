package main.java.instruction.SpecialInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;

/**
 * Created by Kevin on 5/11/2015.
 */
public class printIntSyscall extends SyscallInstruction{
    public printIntSyscall(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    public static void run(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        int argumentValue = s.getRegisterValue(4);
        System.out.println(argumentValue);
    }
}
