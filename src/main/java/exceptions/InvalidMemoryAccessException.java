package main.java.exceptions;

/**
 * Created by Kevin on 5/10/2015.
 */
public class InvalidMemoryAccessException extends Exception {
    private int memoryAddress;

    public InvalidMemoryAccessException(int address){
        this.memoryAddress = address;
    }

    public int getMemoryAddress(){
        return memoryAddress;
    }
}
