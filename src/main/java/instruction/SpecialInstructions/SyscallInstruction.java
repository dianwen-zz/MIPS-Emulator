package main.java.instruction.SpecialInstructions;

import main.java.exceptions.*;
import main.java.hardware.State;
import main.java.instruction.Instruction;

/**
 * Created by dianwen on 5/8/15.
 */
public class SyscallInstruction extends Instruction {

    protected int registerServiceNumber;

    public SyscallInstruction(String instruction) throws ImproperInstructionSizeException, ImproperInstructionValueException {
        super(instruction);
    }

    public void getReady() {
        registerServiceNumber = 2;
        executionReady = true;
    }

    @Override
    public void execute(State s) throws InstructionNotReadyException, InvalidRegisterAccessException, InvalidRegisterWriteException {
        super.executeCheck();

        int serviceNumber = s.getRegisterValue(registerServiceNumber);

        switch(serviceNumber) {
            case 1:
                printIntSyscall.run(s);
            case 4:
                printStringSyscall.run(s);
        }
    }

}
