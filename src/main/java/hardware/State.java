package main.java.hardware;

import com.google.common.collect.ImmutableList;
import main.java.exceptions.InvalidRegisterAccessException;
import main.java.exceptions.InvalidRegisterWriteException;

import java.util.Arrays;

/**
 * Created by dianwen on 5/7/15.
 */
public class State {
    public static final int DEFAULT_REGISTER_SIZE = 32;
    public static final int DEFAULT_STACK_SIZE = 256;

    private int sp, ip;
    private Integer[] register;
    private Integer[] stack;
    private boolean halted;

    public State() {
        this(DEFAULT_REGISTER_SIZE, DEFAULT_STACK_SIZE);
    }

    public State(int registerSize, int stackSize) {
        sp = -1;
        ip = 0;
        register = new Integer[registerSize];
        stack = new Integer[stackSize];
        Arrays.fill(register, 0);
        Arrays.fill(stack, 0);
    }

    public State(Integer[] register, Integer[] stack, int sp, int ip) {
        this.sp = sp;
        this.ip = ip;
        this.register = register;
        this.stack = stack;
        halted = false;
    }

    public ImmutableList<Integer> getRegisters() {
        return ImmutableList.copyOf(register);
    }

    public ImmutableList<Integer> getStack() {
        return ImmutableList.copyOf(stack);
    }

    public int getRegisterValue(int registerNumber) throws InvalidRegisterAccessException {
        try {
            if(registerNumber == 0) {
                return 0;
            }
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

    public int getIP() {
        return ip;
    }

    public void setIP(int newValue) {
        ip = newValue;
    }

    public void incrementIP() {
        ip++;
    }

    public int getSP() {
        return sp;
    }

    public void setSP(int newValue) {
        sp = newValue;
    }

    public void haltProgram() {
        halted = true;
    }

    public boolean isHalted() {
        return halted;
    }

}
