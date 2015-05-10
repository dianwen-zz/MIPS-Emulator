package main.java.instruction;

import com.google.common.collect.ImmutableMap;
import main.java.exceptions.ImproperInstructionSizeException;
import main.java.exceptions.ImproperInstructionValueException;
import main.java.exceptions.OpCodeNotFoundException;
import main.java.instruction.IInstructions.AddiInstruction;
import main.java.instruction.IInstructions.LwInstruction;
import main.java.instruction.IInstructions.SwInstruction;
import main.java.instruction.RInstructions.AddInstruction;
import main.java.instruction.SpecialInstructions.SyscallInstruction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by dianwen on 5/8/15.
 */
public class InstructionFactory {

    static final ImmutableMap<String, Class> instructionMap = new ImmutableMap.Builder<String, Class>()
            .put("000000", AddInstruction.class)
            .put("001000", AddiInstruction.class)
            .put("100011", LwInstruction.class)
            .put("101011", SwInstruction.class)
            .build();
    static final ImmutableMap<String, Class> specialInstructionMap = new ImmutableMap.Builder<String, Class>()
            .put("00000000000000000000000000001100", SyscallInstruction.class)
            .build();

    public Instruction createInstruction(String instructionValue) throws OpCodeNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(specialInstructionMap.containsKey(instructionValue)) {
            return createInstruction(specialInstructionMap.get(instructionValue), instructionValue);
        }
        String opCode = instructionValue.substring(0, 6);
        if(instructionMap.containsKey(opCode)) {
            return createInstruction(instructionMap.get(opCode), instructionValue);
        }
        else {
            throw new OpCodeNotFoundException(opCode);
        }
    }

    private Instruction createInstruction(Class c, String instructionValue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = c.getConstructor(String.class);
        Object inst = constructor.newInstance(instructionValue);
        return (Instruction) inst;
    }
}
