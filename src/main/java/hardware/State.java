package main.java.hardware;

import main.java.exceptions.InvalidRegisterAccessException;
import main.java.exceptions.InvalidRegisterWriteException;

/**
 * Created by dianwen on 5/7/15.
 */
public class State {
    public static final int DEFAULT_REGISTER_SIZE = 32;
    public static final int DEFAULT_STACK_SIZE = 256;

    int sp, ip;
    private int[] register;
    private int[] stack;

    public State() {
        this(DEFAULT_REGISTER_SIZE, DEFAULT_STACK_SIZE);
    }

    public State(int registerSize, int stackSize) {
        sp = -1;
        ip = 0;
        register = new int[registerSize];
        stack = new int[stackSize];
    }

    public State(int[] register, int[] stack, int sp, int ip) {
        this.sp = sp;
        this.ip = ip;
        this.register = register;
        this.stack = stack;
    }

    public int getRegisterValue(int registerNumber) throws InvalidRegisterAccessException {
        try {
            return register[registerNumber];
        }
        catch(Exception e) {
            throw new InvalidRegisterAccessException(registerNumber);
        }
    }

    public void setRegisterValue(int registerNumber, int value) throws InvalidRegisterWriteException {
        try {
            register[registerNumber] = value;
        }
        catch(Exception e) {
            throw new InvalidRegisterWriteException(registerNumber, value);
        }
    }
}
