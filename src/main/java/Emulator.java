package main.java;

import com.google.common.collect.ImmutableList;
import main.java.exceptions.*;
import main.java.instruction.Instruction;
import main.java.instruction.InstructionFactory;
import main.java.hardware.State;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by dianwen on 5/8/15.
 */
public class Emulator {

    private InstructionFactory factory;
    private ArrayList<Instruction> instructions;
    private State emulatorState;

    public Emulator(File f) throws InstructionsCouldNotBeLoadedException {
        this(f, new State());
    }

    public Emulator(File f, State s) throws InstructionsCouldNotBeLoadedException {
        factory = new InstructionFactory();
        emulatorState = s;
        emulatorState.setSP(State.DEFAULT_STACK_SIZE - 1);
        emulatorState.setIP(0);
        try {
            loadInstructions(f);
        } catch (Exception e) {
            //throw new InstructionsCouldNotBeLoadedException(f.getAbsolutePath());
            e.printStackTrace();
        }
    }

    private void loadInstructions(File f) throws IOException, InstructionCannotBeCreatedException {
        instructions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine();
            while (line != null) {
                try {
                    instructions.add(factory.createInstruction(line));
                } catch (Exception e) {
                    e.printStackTrace();
                    //throw new InstructionCannotBeCreatedException(line);
                }
                line = br.readLine();
            }
        }
    }

    public void readyInstructions() {
        for(Instruction i : instructions) {
            i.getReady();
        }
    }

    public boolean executeInstruction() throws InstructionNotReadyException, InvalidRegisterWriteException, InvalidRegisterAccessException, InvalidMemoryAccessException {
        if(emulatorState.getIP() < instructions.size() && !emulatorState.isHalted()) {
            instructions.get(emulatorState.getIP()).execute(emulatorState);
            emulatorState.incrementIP();
            return true;
        }
        return false;
    }

    public ImmutableList<Integer> getState() {
        return emulatorState.getRegisters();
    }
}
